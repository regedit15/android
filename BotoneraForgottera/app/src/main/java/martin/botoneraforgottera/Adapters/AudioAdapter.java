package martin.botoneraforgottera.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
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
		public Button btnShare;

		public ViewHolder(View itemView) {
			super(itemView);
			nombre = itemView.findViewById(R.id.tvCiudadNombre);
			descripcion = itemView.findViewById(R.id.tvCiudadDescripcion);
			// imagen = itemView.findViewById(R.id.ivCiudadImagen);
			// cantidadEstrellas = itemView.findViewById(R.id.tvCiudadCantidadEstrellas);
			btnPlay = itemView.findViewById(R.id.btPlay);
			btnShare = itemView.findViewById(R.id.btShare);
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
					MediaPlayer mediaPlayer = MediaPlayer.create(context, ciudad.getId());

					mediaPlayer.start();
				}
			});

			btnShare.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					// Intent intent = new Intent(Intent.ACTION_SEND);
					// intent.setType("text/plain");
					// intent.putExtra(Intent.EXTRA_SUBJECT, "Titulooooo");
					// intent.putExtra(Intent.EXTRA_TEXT, "Holaaaa como estaaaas!");
					// context.startActivity(Intent.createChooser(intent, "Share using"));

					//- ---------------------------


					// // String sharePath = Environment.getExternalStorageDirectory().getPath() + "/Soundboard/Ringtones/custom_ringtone.ogg";
					// String aaa = Environment.getExternalStorageDirectory().getPath();
					// // E:\martincho\E - Documentos\android\BotoneraForgottera\app\src\main\res\raw\luacha1.opus
					// String sharePath = Environment.getExternalStorageDirectory().getPath() + "/app/src/main/res/raw/uber1mp3.mp3";
					// // Uri uri = Uri.parse(sharePath);
					// Intent share = new Intent(Intent.ACTION_SEND);
					// share.setType("audio/*");
					// // share.putExtra(Intent.EXTRA_STREAM, uri);
					//
					// // String downloadPath = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).absolutePath + "/"
					//
					// // File file = File(downloadPath + "audio.mp3");
					// // Uri uri = FileProvider.getUriForFile(context, "com.restart.shareaudiofiles.fileprovider", file);
					// // share.putExtra(Intent.EXTRA_STREAM, uri);
					//
					// // martin.botoneraforgottera.Adapters
					//
					// // Uri uri = Uri.parse("android.resource://com.my.package/drawable/icon");
					// Uri uri = Uri.parse("android.resource://martin.botoneraforgottera/raw/uber1mp3.mp3");
					//
					// share.putExtra(Intent.EXTRA_STREAM, uri);
					//
					//
					// context.startActivity(Intent.createChooser(share, "Share Sound File"));


					// sssssssssssssss


					// // String sharePath = Environment.getExternalStorageDirectory().getPath() + "/Soundboard/Ringtones/custom_ringtone.ogg";
					// // String aaa = Environment.getExternalStorageDirectory().getPath();
					// // E:\martincho\E - Documentos\android\BotoneraForgottera\app\src\main\res\raw\luacha1.opus
					// // String sharePath = Environment.getExternalStorageDirectory().getPath() + "/app/src/main/res/raw/uber1mp3.mp3";
					// // Uri uri = Uri.parse("android.resource://martin.botoneraforgottera/raw/uber1mp3.mp3");
					//
					// // Uri uri = Uri.parse("android.resource://martin.botoneraforgottera/" + R.raw.uber1mp3);
					//
					// // Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/audio");
					//
					// // String ppp = ContentResolver.SCHEME_ANDROID_RESOURCE + File.pathSeparator + File.separator + context.getPackageName() + "/raw/" + "audio2222";
					// // Uri uri = Uri.parse(ppp);
					// Uri uri = Uri.parse("android.resource://martin.botoneraforgottera/" + R.raw.audio + ".mp3");
					//
					//
					// Intent share = new Intent(Intent.ACTION_SEND);
					// share.setType("audio/*");
					// share.putExtra(Intent.EXTRA_STREAM, uri);
					// context.startActivity(Intent.createChooser(share, "Share Sound File"));


					//--------------------

					// Intent share = new Intent(Intent.ACTION_SEND);
					// share.setType("audio/*");
					// share.putExtra(Intent.EXTRA_STREAM,Uri.parse("file:///"+mypath));
					// startActivity(Intent.createChooser(share, "Share Sound File"));

					// -------------------------


					// Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sticky_notes); // your bitmap
					// ByteArrayOutputStream bs = new ByteArrayOutputStream();
					// bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
					// intent.putExtra("byteArray", bs.toByteArray());


					// --------------


					// val path = FileProvider.getUriForFile(this, authorities, firstAudio!!)

					// val shareIntent = Intent();
					// shareIntent.action = Intent.ACTION_SEND;
					// shareIntent.putExtra(Intent.EXTRA_STREAM, path);
					// shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
					// shareIntent.type = "audio/mp3";
					// startActivity(Intent.createChooser(shareIntent, "Share..."))

					//		--------------------------------------
					// intent.setType("audio/*");
					//	 -------------------------------
					// Intent shareIntent = new Intent(Intent.ACTION_SEND);
					// shareIntent.setType("audio/*");
					// shareIntent.setPackage("martin.botoneraforgottera");
					// shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.audio + ".mp3"));
					// shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
					// context.startActivity(shareIntent);
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
