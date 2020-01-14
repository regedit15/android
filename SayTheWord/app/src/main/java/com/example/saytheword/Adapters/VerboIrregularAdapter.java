package com.example.saytheword.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Activities.MainActivity;
import com.example.saytheword.Models.VerboIrregular;
import com.example.saytheword.R;
import com.example.saytheword.Services.RealmService;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.saytheword.Services.UtilService.LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES;
import static com.example.saytheword.Services.UtilService.LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL;

public class VerboIrregularAdapter extends RecyclerView.Adapter<VerboIrregularAdapter.ViewHolder> {

	private List<VerboIrregular> lista;
	private int layout;
	private String TIPO_TRADUCCION;
	private RealmService realmService = new RealmService();
	private Activity activity;

	public VerboIrregularAdapter(List<VerboIrregular> lista, int layout, String TIPO_TRADUCCION, Activity activity) {
		this.lista = lista;
		this.layout = layout;
		this.TIPO_TRADUCCION = TIPO_TRADUCCION;
		this.activity = activity;
	}

	@NonNull
	@Override
	public VerboIrregularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
		VerboIrregularAdapter.ViewHolder viewHolder = new VerboIrregularAdapter.ViewHolder(view);
		return viewHolder;
	}

	// metodo que se ejecuta cuando se crea el RecyclerView. Realiza el volcado de datos
	@Override
	public void onBindViewHolder(@NonNull final VerboIrregularAdapter.ViewHolder holder, final int position) {
		holder.bind(lista.get(position));
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView tvInfinitivo;
		public TextView tvPronunciacion;
		public TextView tvPasado;
		public TextView tvPasadoPronunciacion;
		public TextView tvParticipio;
		public TextView tvParticipioPronunciacion;
		public TextView tvTraduccion;
		public ConstraintLayout lyRespuesta;
		public MaterialButton btMostrarRespuesta;
		public MaterialButton btPalabraProblematicaListado;

		public ViewHolder(View itemView) {
			super(itemView);

			this.tvInfinitivo = itemView.findViewById(R.id.tvInfinitivo);
			this.tvPronunciacion = itemView.findViewById(R.id.tvPronunciacion);
			this.tvPasado = itemView.findViewById(R.id.tvPasado);
			this.tvPasadoPronunciacion = itemView.findViewById(R.id.tvPasadoPronunciacion);
			this.tvParticipio = itemView.findViewById(R.id.tvParticipio);
			this.tvParticipioPronunciacion = itemView.findViewById(R.id.tvParticipioPronunciacion);
			this.tvTraduccion = itemView.findViewById(R.id.tvTraduccion);
			this.lyRespuesta = itemView.findViewById(R.id.lyRespuesta);
			this.btMostrarRespuesta = itemView.findViewById(R.id.btMostrarRespuesta);
			this.btPalabraProblematicaListado = itemView.findViewById(R.id.btPalabraProblematicaListado);
		}

		public void bind(final VerboIrregular verboIrregular) {

			switch (TIPO_TRADUCCION) {
				case LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL:
					tvInfinitivo.setText(verboIrregular.getInfinitivo());
					tvTraduccion.setText(verboIrregular.getTraduccion());
					break;
				case LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES:
					tvInfinitivo.setText(verboIrregular.getTraduccion());
					tvTraduccion.setText(verboIrregular.getInfinitivo());
					break;
			}

			tvPronunciacion.setText(verboIrregular.getPronunciacion());
			tvPasado.setText(verboIrregular.getPasado());
			tvPasadoPronunciacion.setText(verboIrregular.getPasadoPronunciacion());
			tvParticipio.setText(verboIrregular.getParticipio());
			tvParticipioPronunciacion.setText(verboIrregular.getParticipioPronunciacion());


			setear(verboIrregular.isMostrarRespuesta());
			setearColorPalabraProblematica(verboIrregular);

			btMostrarRespuesta.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					realmService.cambiarMostrarRespuestaVerbosIrregulares(verboIrregular);
					setear(verboIrregular.isMostrarRespuesta());
				}
			});

			btPalabraProblematicaListado.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					realmService.cambiarPalabraProblematicaVerbosIrregulares(verboIrregular);
					setearColorPalabraProblematica(verboIrregular);
					notifyDataSetChanged();

					((MainActivity) activity).getSupportActionBar().setTitle(new StringBuilder(((MainActivity) activity).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(lista.size()).append(")").toString());
				}
			});
		}

		private void setear(boolean mostrarRespuesta) {
			if (mostrarRespuesta) {
				lyRespuesta.setVisibility(View.VISIBLE);
				btMostrarRespuesta.setIconResource(R.drawable.ic_eye_open);
			} else {
				lyRespuesta.setVisibility(View.INVISIBLE);
				btMostrarRespuesta.setIconResource(R.drawable.ic_eye_closed);
			}
		}

		private void setearColorPalabraProblematica(VerboIrregular verboIrregular) {
			if (verboIrregular.isPalabraProblematica()) {
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
		realmService.cambiarMostrarRespuestasVerbosIrregulares(lista, valor);
		notifyDataSetChanged();
	}

	public void cambiarAInglesEspaniol() {
		cambiarTipoListado(LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL);
	}

	public void cambiarAEspaniolIngles() {
		cambiarTipoListado(LISTADO_TIPO_TRADUCCION_ESPANIOL_INGLES);
	}

	private void cambiarTipoListado(String tipo) {
		TIPO_TRADUCCION = tipo;
		notifyDataSetChanged();
	}

	public List<VerboIrregular> getLista() {
		return lista;
	}

	public void setLista(List<VerboIrregular> lista) {
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

