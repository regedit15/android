package martin.saytheword.Adapters;

import static martin.saytheword.Services.UtilService.ESTADO_DIFICIL;
import static martin.saytheword.Services.UtilService.ESTADO_FACIL;
import static martin.saytheword.Services.UtilService.ESTADO_NORMAL;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import martin.saytheword.Activities.MainActivity;
import martin.saytheword.Models.Palabra;
import martin.saytheword.R;
import martin.saytheword.Services.RealmService;
import martin.saytheword.Services.UtilService;

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
		public MaterialButton btDificultad;

		public ViewHolder(View itemView) {
			super(itemView);

			this.tvPalabraIzquierda = itemView.findViewById(R.id.tvPalabraIzquierda);
			this.tvPalabraDerechaArriba = itemView.findViewById(R.id.tvPalabraDerechaArriba);
			this.tvPalabraDerechaAbajo = itemView.findViewById(R.id.tvPalabraDerechaAbajo);
			this.lyRespuesta = itemView.findViewById(R.id.lyRespuesta);
			this.mbMostrarRespuesta = itemView.findViewById(R.id.btMostrarRespuesta);
			this.btDificultad = itemView.findViewById(R.id.btDificultad);
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
			setearColorDificultad(palabra);

			mbMostrarRespuesta.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					realmService.cambiarMostrarRespuestaPalabra(palabra);
					setear(palabra.isMostrarRespuesta());
				}
			});

			btDificultad.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					realmService.cambiarDificultadPalabra(palabra);

					setearColorDificultad(palabra);
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

		private void setearColorDificultad(Palabra palabra) {
			switch (palabra.getDificultad()) {
				case ESTADO_FACIL:
					btDificultad.setIconResource(R.drawable.ic_happy);
					btDificultad.setBackgroundTintList(activity.getResources().getColorStateList(R.color.colorDificultadFacil));
					break;
				case ESTADO_NORMAL:
					btDificultad.setIconResource(R.drawable.ic_smile);
					btDificultad.setBackgroundTintList(activity.getResources().getColorStateList(R.color.colorDificultadNormal));
					break;
				case ESTADO_DIFICIL:
					btDificultad.setIconResource(R.drawable.ic_angry);
					btDificultad.setBackgroundTintList(activity.getResources().getColorStateList(R.color.colorDificultadDificil));
					break;
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

