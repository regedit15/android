package martin.botoneraforgottera.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import martin.botoneraforgottera.Activities.MainActivity;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Interfaces.OnTagClickListener;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;
import martin.botoneraforgottera.R;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {

	private Context context;
	private List<Audio> lista;
	private int layout;
	private OnPlayClickListener onPlayClickListener;

	public AudioAdapter(List<Audio> lista, int layout, OnPlayClickListener onPlayClickListener) {
		this.lista = lista;
		this.layout = layout;
		this.onPlayClickListener = onPlayClickListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
		context = parent.getContext();
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.bind(lista.get(position), onPlayClickListener);
	}

	@Override
	public int getItemCount() {
		return lista.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView nombre;
		public TextView descripcion;
		public MaterialButton btPlay;
		public MaterialButton btShare;
		public MaterialButton ibCorazon;

		//--------------------------- Segundo listado
		private RecyclerView recyclerViewTags;
		private TagsAdapter tagsAdapter;
		private List<Tag> tags;
		private RecyclerView.LayoutManager layoutManagerTags;
		//---------------------------

		public ViewHolder(View itemView) {
			super(itemView);
			nombre = itemView.findViewById(R.id.tvCiudadNombre);
			descripcion = itemView.findViewById(R.id.tvCiudadDescripcion);
			btPlay = itemView.findViewById(R.id.btPlay);
			btShare = itemView.findViewById(R.id.btShare);
			ibCorazon = itemView.findViewById(R.id.ibCorazon);

			//--------------------------- Segundo listado
			recyclerViewTags = itemView.findViewById(R.id.rvListadoTags);
			//----------------------------------------------------------------
		}

		public void bind(final Audio audio, final OnPlayClickListener onPlayClickListener) {
			nombre.setText(audio.getNombre());
			descripcion.setText(audio.getDescripcion());

			btPlay.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onPlayClickListener.onPlayClickListener(audio);
				}
			});


			btShare.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onPlayClickListener.onShareClickListener(audio);
				}
			});

			//--------------------------- Segundo listado
			tags = audio.getTags();
			recyclerViewTags.setHasFixedSize(true);
			recyclerViewTags.setItemAnimator(new DefaultItemAnimator());
			layoutManagerTags = new GridLayoutManager(context, 3);
			recyclerViewTags.setLayoutManager(layoutManagerTags);

			tagsAdapter = new TagsAdapter(tags, R.layout.item_tags, new OnTagClickListener() {
				@Override
				public void onTagClick(Tag tag) {
					Toast.makeText(context, "Proximamente filtrado", Toast.LENGTH_LONG).show();
				}
			});

			recyclerViewTags.setAdapter(tagsAdapter);
			//----------------------------------------------------------------

			//--------------------------- Corazon Favorito
			setearCorazon(audio.isFavorito());

			ibCorazon.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {

					Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
						@Override
						public void execute(Realm realm) {
							audio.setFavorito(!audio.isFavorito());
							setearCorazon(audio.isFavorito());

							((MainActivity) context).getSupportActionBar().setTitle(new StringBuilder(((MainActivity) context).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(getLista().size()).append(")").toString());
						}
					});
				}
			});
			//----------------------------------------------------------------
		}

		private void setearCorazon(boolean favorito) {
			if (favorito) {
				ibCorazon.setIconResource(R.drawable.ic_like_2);
			} else {
				ibCorazon.setIconResource(R.drawable.ic_like_1);
			}
		}
	}

	public List<Audio> getLista() {
		return lista;
	}

	public void setLista(List<Audio> lista) {
		this.lista = lista;
	}
}
