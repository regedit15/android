package com.example.saytheword.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private List<Palabra> palabras = new ArrayList<Palabra>();
	private int layout;

	public MyAdapter(List<Palabra> Palabras, int layout) {
		this.palabras = Palabras;
		this.layout = layout;
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
		holder.bind(palabras.get(position));
	}

	@Override
	public int getItemCount() {
		return palabras.size();
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}

	public void ocultarTodos() {
		for (Palabra palabra : palabras) {
			palabra.setMostrarRespuesta(false);
		}

		notifyItemRangeChanged(0, getItemCount() - 1);
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView tvPalabraIng;
		public TextView tvPalabraEsp;
		public TextView tvPronunciacion;
		public ConstraintLayout lyRespuesta;
		public MaterialButton mbMostrarRespuesta;

		public ViewHolder(View itemView) {
			super(itemView);
			this.tvPalabraIng = itemView.findViewById(R.id.tvPalabraIng);
			this.tvPalabraEsp = itemView.findViewById(R.id.tvPalabraEsp);
			this.tvPronunciacion = itemView.findViewById(R.id.tvPronunciacion);
			this.lyRespuesta = itemView.findViewById(R.id.lyRespuesta);
			this.mbMostrarRespuesta = itemView.findViewById(R.id.btMostrarRespuesta);
		}

		public void bind(final Palabra palabra) {

			tvPalabraIng.setText(palabra.getPalabraEsp());
			tvPalabraEsp.setText(palabra.getPalabraIng());
			tvPronunciacion.setText(palabra.getPronunciacion());

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

		// -------------------------------------------
		// @Override
		// public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		//
		// 	Palabra PalabraSeleccionada = palabras.get(this.getAdapterPosition());
		// 	menu.setHeaderTitle(PalabraSeleccionada.getNombre());
		// 	// menu.setHeaderIcon(PalabraSeleccionada.getImagen());
		//
		// 	activity.getMenuInflater().inflate(R.menu.context_menu, menu);
		// 	// Recorremos los items del listado y le vamos seteando un objeto, en este caso el MyAdapter
		// 	// que implementa el onMenuItemClick
		// 	for (int i = 0; i < menu.size(); i++) {
		// 		menu.getItem(i).setOnMenuItemClickListener(this);
		// 	}
		// }
		//
		// @Override
		// public boolean onMenuItemClick(MenuItem item) {
		// 	boolean resultado;
		//
		// 	switch (item.getItemId()) {
		// 		case R.id.it_eliminar:
		// 			palabras.remove(getAdapterPosition());
		// 			// refrezca el cambio
		// 			notifyItemRemoved(getAdapterPosition());
		// 			resultado = true;
		// 			break;
		// 		default:
		// 			resultado = false;
		// 	}
		// 	return resultado;
		// }
		// -------------------------------------------
	}

	public interface OnItemClickListener {
		void onItemClick(Palabra Palabra, int position);
	}

	public List<Palabra> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<Palabra> Palabras) {
		this.palabras = Palabras;
	}
}

