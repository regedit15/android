package martin.botoneraforgottera.Adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {

	private Context context;
	private List<Audio> lista;
	private int layout;
	// private OnItemClickListener itemClickListener;
	// private OnButtonClickListener btnClickListener;

	// public CiudadAdapter(List<Audio> lista, int layout, OnItemClickListener itemListener, OnButtonClickListener btnListener) {
	// 	this.lista = lista;
	// 	this.layout = layout;
	// 	this.itemClickListener = itemListener;
	// 	this.btnClickListener = btnListener;
	// }

	// public AudioAdapter(List<Audio> lista, int layout, OnButtonClickListener btnListener) {
	public AudioAdapter(List<Audio> lista, int layout) {
		this.lista = lista;
		this.layout = layout;
		// this.btnClickListener = btnListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
		context = parent.getContext();
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// holder.bind(lista.get(position), itemClickListener, btnClickListener);
		// holder.bind(lista.get(position), btnClickListener);
		holder.bind(lista.get(position));
	}

	@Override
	public int getItemCount() {
		return lista.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView nombre;
		public TextView descripcion;
		// public TextView cantidadEstrellas;
		// public ImageView imagen;
		public Button btnPlay;

		public ViewHolder(View itemView) {
			super(itemView);
			nombre = itemView.findViewById(R.id.tvCiudadNombre);
			descripcion = itemView.findViewById(R.id.tvCiudadDescripcion);
			// imagen = itemView.findViewById(R.id.ivCiudadImagen);
			// cantidadEstrellas = itemView.findViewById(R.id.tvCiudadCantidadEstrellas);
			btnPlay = itemView.findViewById(R.id.btEliminarCiudad);
		}

		// public void bind(final Audio ciudad, final OnItemClickListener itemListener, final OnButtonClickListener btnListener) {
		public void bind(final Audio ciudad) {
			nombre.setText(ciudad.getNombre());
			descripcion.setText(ciudad.getDescripcion());
			// cantidadEstrellas.setText(ciudad.getRating().toString());

			// ImageView imagen = new ImageView(this);
			// Picasso.get().load(ciudad.getUrlImagen()).into(imagen);
			// Picasso.get().load("https://concepto.de/wp-content/uploads/2018/08/Londres-e1533855310803.jpg").into(imagen);
			// Log.d("myTag", ciudad.getUrlImagen());
			// Picasso.get().load(ciudad.getUrlImagen()).into(imagen);

			btnPlay.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					// btnListener.onButtonClick(ciudad, getAdapterPosition());

					// MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.uber1);
					MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.uber1);

					mediaPlayer.start();
				}
			});

			// itemView.setOnClickListener(new View.OnClickListener() {
			// 	@Override
			// 	public void onClick(View view) {
			// 		itemListener.onItemClick(ciudad, getAdapterPosition());
			// 	}
			// });
		}
	}

	// public interface OnItemClickListener {
	// 	void onItemClick(Ciudad ciudad, int position);
	// }

	// public interface OnButtonClickListener {
	// 	void onButtonClick(Audio ciudad, int position);
	// }

}
