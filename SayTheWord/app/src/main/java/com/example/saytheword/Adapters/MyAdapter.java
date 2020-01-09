package com.example.saytheword.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private List<Palabra> palabras = new ArrayList<Palabra>();
	private int layout;
	private Activity activity;
	private OnItemClickListener onItemClickListener;

	public MyAdapter(List<Palabra> Palabras, int layout, Activity activity, OnItemClickListener onItemClickListener) {
		this.palabras = Palabras;
		this.layout = layout;
		this.onItemClickListener = onItemClickListener;
		this.activity = activity;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(activity).inflate(layout, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	// metodo que se ejecuta cuando se crea el RecyclerView. Realiza el volcado de datos
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.bind(palabras.get(position), onItemClickListener);
	}

	@Override
	public int getItemCount() {
		return palabras.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView textViewTitulo;
		// public TextView textViewDescripcion;
		// public ImageView imageView;

		public ViewHolder(View itemView) {
			super(itemView);
			this.textViewTitulo = itemView.findViewById(R.id.tv_titulo);
			// this.textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
			// this.imageView = itemView.findViewById(R.id.imageView);
			// itemView.setOnCreateContextMenuListener(this);
		}

		public void bind(final Palabra Palabra, final OnItemClickListener onItemClickListener) {

			// -- Se se setean todos los elementos del layout
			textViewTitulo.setText(Palabra.getPalabraEsp());
			// textViewDescripcion.setText(Palabra.getDescripcion());

			// Fit significa que nos abarque todo el contenido
			// Picasso.get().load(Palabra.getImagen()).fit().into(imageView);
			// ----------------------------------------------

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// se le pasa el nombre y la posicion
					onItemClickListener.onItemClick(Palabra, getAdapterPosition());
				}
			});
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

