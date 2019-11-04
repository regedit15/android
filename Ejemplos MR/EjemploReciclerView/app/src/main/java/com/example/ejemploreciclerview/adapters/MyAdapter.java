package com.example.ejemploreciclerview.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejemploreciclerview.R;
import com.example.ejemploreciclerview.models.Fruta;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

	private List<Fruta> frutas = new ArrayList<Fruta>();
	private int layout;
	private Activity activity;
	private OnItemClickListener onItemClickListener;
	// Este contexto es necesario para la libreria Picasso

	public MyAdapter(List<Fruta> frutas, int layout, Activity activity, OnItemClickListener onItemClickListener) {
		this.frutas = frutas;
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
		holder.bind(frutas.get(position), onItemClickListener);
	}

	@Override
	public int getItemCount() {
		return frutas.size();
	}

	// public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView textViewTitulo;
		public TextView textViewDescripcion;
		public TextView textViewCantidad;
		public ImageView imageView;

		public ViewHolder(View itemView) {
			super(itemView);
			this.textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
			this.textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
			this.textViewCantidad = itemView.findViewById(R.id.textViewCantidad);
			this.imageView = itemView.findViewById(R.id.imageView);
			// itemView.setOnCreateContextMenuListener(this);
		}

		public void bind(final Fruta fruta, final OnItemClickListener onItemClickListener) {

			// -- Se se setean todos los elementos del layout
			textViewTitulo.setText(fruta.getNombre());
			textViewDescripcion.setText(fruta.getDescripcion());

			//Nota: si se le pasa un int lo va a tomar como una referencia de un string ej: R.string.app_name
			// textViewCantidad.setText(fruta.getCantidad().toString());
			textViewCantidad.setText("1");


			// Lo seteamos en color rojo
			// textViewCantidad.setTextColor(R.color.textoGris);
			// Lo ponemos en negrita
			textViewCantidad.setTypeface(null, Typeface.NORMAL);

			// Fit significa que nos abarque todo el contenido
			Picasso.get().load(fruta.getImagen()).fit().into(imageView);

			// viewHolder.imagenFruta = convertView.findViewById(R.id.imagenFruta);
			// imageView.setImageResource(fruta.getImagen());
			// ----------------------------------------------

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// se le pasa el nombre y la posicion
					onItemClickListener.onItemClick(fruta, getAdapterPosition());
				}
			});
		}

		// // -------------------------------------------
		// @Override
		// public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		//
		// 	Fruta frutaSeleccionada = frutas.get(this.getAdapterPosition());
		// 	menu.setHeaderTitle(frutaSeleccionada.getNombre());
		// 	// menu.setHeaderIcon(frutaSeleccionada.getImagen());
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
		//
		// 	switch (item.getItemId()) {
		// 		case R.id.itemEliminar:
		// 			frutas.remove(getAdapterPosition());
		// 			// refrezca el cambio
		// 			notifyItemRemoved(getAdapterPosition());
		// 			resultado = true;
		// 			break;
		// 		case R.id.itemResetearCantidad:
		// 			frutas.get(getAdapterPosition()).resetearCantidad();
		// 			// refrezca el cambio
		// 			notifyItemChanged(getAdapterPosition());
		// 			resultado = true;
		// 			break;
		// 		default:
		// 			resultado = false;
		// 	}
		// 	return resultado;
		// }
		// // -------------------------------------------
	}

	public interface OnItemClickListener {
		void onItemClick(Fruta fruta, int position);
	}
}
