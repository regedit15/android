package com.example.compartiraudio;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

public class MainActivity extends AppCompatActivity {

	private File file;
	private int CODIGO_OK = 1515;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// Esto al parecer no es necesario pero queda comentado por las dudas
		// ------------ Esto se saco de: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
		// porque sino daba un error de FileUriExposedException
		// StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		// StrictMode.setVmPolicy(builder.build());
		// ------------------------------------------------

		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
	}

	public void shareClick(View view) {

		// Directorio del telefono, el de mas arriba, el de "Este equipo\moto g(7)\Almacenamiento interno compartido"
		File filePath = Environment.getExternalStorageDirectory();
		// Directorio de Downloads: "Este equipo\moto g(7)\Almacenamiento interno compartido\Download"
		// File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

		InputStream inputStream = getResources().openRawResource(R.raw.audio);
		file = new File(filePath, "audiocopia.mp3");

		try {
			FileUtils.copyInputStreamToFile(inputStream, file);
		} catch (IOException e) {
			e.printStackTrace();
		}


		Intent shareIntent = new Intent(Intent.ACTION_SEND);

		// File a = getApplicationContext().getFilesDir();
		// File sharedFolderPath = new File(a, "/external_files");

		// Este es el mismo nombre que esta en el Manifest
		String nombreProvider = getApplicationContext().getPackageName() + ".myfileprovider";

		Uri photoURI = FileProvider.getUriForFile(this, nombreProvider, file);

		shareIntent.setType("audio/mp3");
		// shareIntent.setType("image/png");
		// shareIntent.setType("audio/*");
		// shareIntent.setType("aplication/pdf");

		shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
		shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		// startActivity(Intent.createChooser(shareIntent, "Share images..."));

		startActivityForResult(Intent.createChooser(shareIntent, "Share images..."), CODIGO_OK);
		// Esto lo elimina cuando el activity se cierra. Pero a veces funciona y a veces no..
		// file.deleteOnExit();
	}


	// ----------------- Soluciones para eliminar el archivo despues de compartir
	// 1- Esta el file.deleteOnExit(); pero a veces lo elimina y otras no
	// 2- onResume() el problema de este es que se llama muchas veces, mas de lo necesario
	// 3- onActivityResult() este esta bueno pero si eliminas la aplicacion despues de
	// compartir no se llama
	// 4- onDestroy() este funciona pero lo elimina al finalizar la aplicacion, no exactamente
	// despues de compartir el audio
	// 5- Decidimos usar una solucion hibrida con el onDestroy y el onActivityResult
	// --------------------------------------------------------------------------

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (file.exists()) {
			file.delete();
		}
	}

	// @Override
	// protected void onResume() {
	// 	super.onResume();
	//
	// 	if (file != null && file.exists()) {
	// 		file.delete();
	// 	}
	// }

	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == CODIGO_OK && file != null && file.exists()) {
			file.delete();
		}
	}
}
