package com.example.saytheword.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.saytheword.Services.UtilService.TIPO_LISTADO_ESPANIOL_INGLES;
import static com.example.saytheword.Services.UtilService.TIPO_LISTADO_INGLES_ESPANIOL;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

	private List<Palabra> lista;
	private int layout;
	private int TIPO_LISTADO;

	public MyAdapter(List<Palabra> lista, int layout, int TIPO_LISTADO) {
		this.lista = lista;
		this.layout = layout;
		this.TIPO_LISTADO = TIPO_LISTADO;
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

		public ViewHolder(View itemView) {
			super(itemView);
			this.tvPalabraIzquierda = itemView.findViewById(R.id.tvPalabraIzquierda);
			this.tvPalabraDerechaArriba = itemView.findViewById(R.id.tvPalabraDerechaArriba);
			this.tvPalabraDerechaAbajo = itemView.findViewById(R.id.tvPalabraDerechaAbajo);
			this.lyRespuesta = itemView.findViewById(R.id.lyRespuesta);
			this.mbMostrarRespuesta = itemView.findViewById(R.id.btMostrarRespuesta);
		}

		public void bind(final Palabra palabra) {

			switch (TIPO_LISTADO) {
				case TIPO_LISTADO_ESPANIOL_INGLES:
					tvPalabraIzquierda.setText(palabra.getPalabraEsp());
					tvPalabraDerechaArriba.setText(palabra.getPalabraIng());
					tvPalabraDerechaAbajo.setText(palabra.getPronunciacion());
					break;
				case TIPO_LISTADO_INGLES_ESPANIOL:
					tvPalabraIzquierda.setText(palabra.getPalabraIng());
					tvPalabraDerechaArriba.setText(palabra.getPalabraEsp());
					tvPalabraDerechaAbajo.setText(palabra.getPronunciacion());
					break;
			}


			setear(palabra.isMostrarRespuesta());

			mbMostrarRespuesta.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					palabra.cambiarMostrarRespuesta();
					setear(palabra.isMostrarRespuesta());
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

	}

	public void ocultarTodos() {
		for (Palabra palabra : lista) {
			palabra.setMostrarRespuesta(false);
		}
		notifyDataSetChanged();
	}

	public void cambiarAInglesEspaniol() {
		cambiarTipoListado(TIPO_LISTADO_INGLES_ESPANIOL);
	}

	public void cambiarAEspaniolIngles() {
		cambiarTipoListado(TIPO_LISTADO_ESPANIOL_INGLES);
	}

	private void cambiarTipoListado(int tipo) {
		TIPO_LISTADO = tipo;
		notifyDataSetChanged();
	}

	public List<Palabra> getLista() {
		return lista;
	}

	public void setLista(List<Palabra> Palabras) {
		this.lista = Palabras;
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

