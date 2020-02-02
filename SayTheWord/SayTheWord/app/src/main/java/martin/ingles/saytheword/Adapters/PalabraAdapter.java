package martin.ingles.saytheword.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import martin.ingles.saytheword.Activities.MainActivity;
import martin.ingles.saytheword.Models.Palabra;
import martin.ingles.saytheword.R;
import martin.ingles.saytheword.Services.RealmService;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import martin.ingles.saytheword.Services.UtilService;

public class PalabraAdapter extends RecyclerView.Adapter<PalabraAdapter.ViewHolder> {

	private List<Palabra> lista;
	private int layout;
	private String TIPO_TRADUCCION;
	private RealmService realmService = new RealmService();
	private Activity activity;

	public PalabraAdapter(List<Palabra> lista, int layout, String TIPO_TRADUCCION, Activity activity) {
		this.lista = lista;
		this.layout = layout;
		this.TIPO_TRADUCCION = TIPO_TRADUCCION;
		this.activity = activity;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	// metodo que se ejecuta cuando se crea el RecyclerView. Realiza el volcado de datos
	@Override
	public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
		holder.bind(lista.get(position));
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView tvPalabraIzquierda;
		public TextView tvPalabraDerechaArriba;
		public TextView tvPalabraDerechaAbajo;
		public ConstraintLayout lyRespuesta;
		public MaterialButton mbMostrarRespuesta;
		public MaterialButton btPalabraProblematicaListado;

		public ViewHolder(View itemView) {
			super(itemView);

			this.tvPalabraIzquierda = itemView.findViewById(R.id.tvPalabraIzquierda);
			this.tvPalabraDerechaArriba = itemView.findViewById(R.id.tvPalabraDerechaArriba);
			this.tvPalabraDerechaAbajo = itemView.findViewById(R.id.tvPalabraDerechaAbajo);
			this.lyRespuesta = itemView.findViewById(R.id.lyRespuesta);
			this.mbMostrarRespuesta = itemView.findViewById(R.id.btMostrarRespuesta);
			this.btPalabraProblematicaListado = itemView.findViewById(R.id.btPalabraProblematicaListado);
		}

		public void bind(final Palabra palabra) {

			switch (TIPO_TRADUCCION) {
				case UtilService.LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES:
					tvPalabraIzquierda.setText(palabra.getPalabraEsp());
					tvPalabraDerechaArriba.setText(palabra.getPalabraIng());
					break;
				case UtilService.LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL:
					tvPalabraIzquierda.setText(palabra.getPalabraIng());
					tvPalabraDerechaArriba.setText(palabra.getPalabraEsp());
					break;
			}
			tvPalabraDerechaAbajo.setText(palabra.getPronunciacion());


			setear(palabra.isMostrarRespuesta());
			setearColorPalabraProblematica(palabra);

			mbMostrarRespuesta.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					realmService.cambiarMostrarRespuestaPalabra(palabra);
					setear(palabra.isMostrarRespuesta());
				}
			});

			btPalabraProblematicaListado.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					realmService.cambiarPalabraProblematicaPalabra(palabra);
					setearColorPalabraProblematica(palabra);
					notifyDataSetChanged();

					((MainActivity) activity).getSupportActionBar().setTitle(new StringBuilder(((MainActivity) activity).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(lista.size()).append(")").toString());
				}
			});
		}

		private void setear(boolean mostrarRespuesta) {
			if (mostrarRespuesta) {
				lyRespuesta.setVisibility(View.VISIBLE);
				mbMostrarRespuesta.setIconResource(R.drawable.ic_eye_open);
			} else {
				lyRespuesta.setVisibility(View.INVISIBLE);
				mbMostrarRespuesta.setIconResource(R.drawable.ic_eye_closed);
			}
		}

		private void setearColorPalabraProblematica(Palabra palabra) {
			if (palabra.isPalabraProblematica()) {
				btPalabraProblematicaListado.setIconResource(R.drawable.ic_angry);
				btPalabraProblematicaListado.setBackgroundTintList(activity.getResources().getColorStateList(R.color.colorPalabraProblematica));
			} else {
				btPalabraProblematicaListado.setIconResource(R.drawable.ic_smile);
				btPalabraProblematicaListado.setBackgroundTintList(activity.getResources().getColorStateList(R.color.colorPalabraBuena));
			}
		}

	}

	public void ocultarTodo() {
		cambiarTodo(false);
	}

	public void verTodo() {
		cambiarTodo(true);
	}

	private void cambiarTodo(final boolean valor) {
		realmService.cambiarMostrarRespuestasPalabras(lista, valor);
		notifyDataSetChanged();
	}

	public void cambiarAInglesEspaniol() {
		cambiarTipoListado(UtilService.LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL);
	}

	public void cambiarAEspaniolIngles() {
		cambiarTipoListado(UtilService.LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES);
	}

	private void cambiarTipoListado(String tipo) {
		TIPO_TRADUCCION = tipo;
		notifyDataSetChanged();
	}

	public List<Palabra> getLista() {
		return lista;
	}

	public void setLista(List<Palabra> lista) {
		this.lista = lista;
	}

	@Override
	public int getItemCount() {
		return lista.size();
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}
}

