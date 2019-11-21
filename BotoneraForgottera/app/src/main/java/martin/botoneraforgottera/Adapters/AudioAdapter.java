package martin.botoneraforgottera.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Models.Audio;
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
		public Button btnPlay;
		public Button btnShare;

		public ViewHolder(View itemView) {
			super(itemView);
			nombre = itemView.findViewById(R.id.tvCiudadNombre);
			descripcion = itemView.findViewById(R.id.tvCiudadDescripcion);
			btnPlay = itemView.findViewById(R.id.btPlay);
			btnShare = itemView.findViewById(R.id.btShare);
		}

		public void bind(final Audio audio, final OnPlayClickListener onPlayClickListener) {
			nombre.setText(audio.getNombre());
			descripcion.setText(audio.getDescripcion());

			btnPlay.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onPlayClickListener.onPlayClickListener(audio);
				}
			});

			btnShare.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onPlayClickListener.onShareClickListener(audio);
				}
			});
		}
	}
}
