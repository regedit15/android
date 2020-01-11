package com.example.ejemploreciclerview.adapters;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
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

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
		public TextView textViewTitulo;
		public TextView textViewDescripcion;
		public ImageView imageView;

		public ViewHolder(View itemView) {
			super(itemView);
			this.textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
			this.textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
			this.imageView = itemView.findViewById(R.id.imageView);
			itemView.setOnCreateContextMenuListener(this);
		}

		public void bind(final Fruta fruta, final OnItemClickListener onItemClickListener) {

			// -- Se se setean todos los elementos del layout
			textViewTitulo.setText(fruta.getNombre());
			textViewDescripcion.setText(fruta.getDescripcion());

			// Fit significa que nos abarque todo el contenido
			Picasso.get().load(fruta.getImagen()).fit().into(imageView);
			// ----------------------------------------------

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// se le pasa el nombre y la posicion
					onItemClickListener.onItemClick(fruta, getAdapterPosition());
				}
			});
		}

		// -------------------------------------------
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

			Fruta frutaSeleccionada = frutas.get(this.getAdapterPosition());
			menu.setHeaderTitle(frutaSeleccionada.getNombre());
			// menu.setHeaderIcon(frutaSeleccionada.getImagen());

			activity.getMenuInflater().inflate(R.menu.context_menu, menu);
			// Recorremos los items del listado y le vamos seteando un objeto, en este caso el MyAdapter
			// que implementa el onMenuItemClick
			for (int i = 0; i < menu.size(); i++) {
				menu.getItem(i).setOnMenuItemClickListener(this);
			}
		}

		@Override
		public boolean onMenuItemClick(MenuItem item) {
			boolean resultado;

			switch (item.getItemId()) {
				case R.id.it_eliminar:
					frutas.remove(getAdapterPosition());
					// refrezca el cambio
					notifyItemRemoved(getAdapterPosition());
					resultado = true;
					break;
				default:
					resultado = false;
			}
			return resultado;
		}
		// -------------------------------------------
	}

	public interface OnItemClickListener {
		void onItemClick(Fruta fruta, int position);
	}

	public List<Fruta> getFrutas() {
		return frutas;
	}

	public void setFrutas(List<Fruta> frutas) {
		this.frutas = frutas;
	}
}
