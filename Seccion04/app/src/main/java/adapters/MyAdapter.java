package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seccion02.seccion04.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import models.Pelicula;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	private int layout;
	private OnItemClickListener onItemClickListener;
	// Este contexto es necesario para la libreria Picasso
	private Context context;

	public MyAdapter(List<Pelicula> peliculas, int layout, OnItemClickListener onItemClickListener) {
		this.peliculas = peliculas;
		this.layout = layout;
		this.onItemClickListener = onItemClickListener;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		context = parent.getContext();
		View view = LayoutInflater.from(context).inflate(layout, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	// metodo que se ejecuta cuando se crea el RecyclerView. Realiza el volcado de datos
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.bind(peliculas.get(position), onItemClickListener);
	}

	@Override
	public int getItemCount() {
		return peliculas.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView textViewDescripcion;
		public ImageView imageView;

		public ViewHolder(View itemView) {
			super(itemView);
			this.textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
			this.imageView = itemView.findViewById(R.id.imageView);
		}

		public void bind(final Pelicula pelicula, final OnItemClickListener onItemClickListener) {

			// -- Se se setean todos los elementos del layout
			textViewDescripcion.setText(pelicula.getNombre());
			Picasso.get().load(pelicula.getImagen()).fit().into(imageView);
			// imageView.setImageResource(pelicula.getImagen());
			// ----------------------------------------------

			itemView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// se le pasa el nombre y la posicion
						onItemClickListener.onItemClick(pelicula, getAdapterPosition());
					}
			});
		}
	}

	public interface OnItemClickListener {
		void onItemClick(Pelicula pelicula, int position);
	}
}
