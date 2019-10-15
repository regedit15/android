package com.seccion04.seccion04_ciudades.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.seccion04.seccion04_ciudades.R;
import com.seccion04.seccion04_ciudades.models.Ciudad;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.ViewHolder> {

	private Context context;
	private List<Ciudad> lista;
	private int layout;
	private OnItemClickListener itemClickListener;
	private OnButtonClickListener btnClickListener;

	public CiudadAdapter(List<Ciudad> lista, int layout, OnItemClickListener itemListener, OnButtonClickListener btnListener) {
		this.lista = lista;
		this.layout = layout;
		this.itemClickListener = itemListener;
		this.btnClickListener = btnListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
		context = parent.getContext();
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.bind(lista.get(position), itemClickListener, btnClickListener);
	}

	@Override
	public int getItemCount() {
		return lista.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView nombre;
		public TextView descripcion;
		public TextView cantidadEstrellas;
		public ImageView imagen;
		public Button btnDelete;

		public ViewHolder(View itemView) {
			super(itemView);
			nombre = itemView.findViewById(R.id.tvCiudadNombre);
			descripcion = itemView.findViewById(R.id.tvCiudadDescripcion);
			imagen = itemView.findViewById(R.id.ivCiudadImagen);
			cantidadEstrellas = itemView.findViewById(R.id.tvCiudadCantidadEstrellas);
			btnDelete = itemView.findViewById(R.id.btEliminarCiudad);
		}

		public void bind(final Ciudad ciudad, final OnItemClickListener itemListener, final OnButtonClickListener btnListener) {
			nombre.setText(ciudad.getNombre());
			descripcion.setText(ciudad.getDescripcion());
			cantidadEstrellas.setText(ciudad.getRating().toString());

			// ImageView imagen = new ImageView(this);
			// Picasso.get().load(ciudad.getUrlImagen()).into(imagen);
			// Picasso.get().load("https://concepto.de/wp-content/uploads/2018/08/Londres-e1533855310803.jpg").into(imagen);
			Log.d("myTag", ciudad.getUrlImagen());
			Picasso.get().load(ciudad.getUrlImagen()).into(imagen);

			btnDelete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					btnListener.onButtonClick(ciudad, getAdapterPosition());
				}
			});

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					itemListener.onItemClick(ciudad, getAdapterPosition());
				}
			});
		}
	}

	public interface OnItemClickListener {
		void onItemClick(Ciudad ciudad, int position);
	}

	public interface OnButtonClickListener {
		void onButtonClick(Ciudad ciudad, int position);
	}

}
