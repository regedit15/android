package com.example.fileprovider;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

public class MainActivity extends AppCompatActivity {

	private File firstAudio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ------------ Esto se saco de: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
		// porque sino daba un error de FileUriExposedException
		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		// ------------------------------------------------

		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

		// Environment.getExternalStorageDirectory()
		// String downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/";
		// String downloadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

		// String downloadPath = Environment.getExternalStorageDirectory() + "/";
		File downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

		InputStream inputStream = getResources().openRawResource(R.raw.audio);
		// firstAudio = new File(downloadPath + "audiocopia.mp3");
		firstAudio = new File(downloadPath, "audiocopia.mp3");

		try {
			FileUtils.copyInputStreamToFile(inputStream, firstAudio);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void shareClick(View view) {

		Intent shareIntent = new Intent(Intent.ACTION_SEND);

		File a = getApplicationContext().getFilesDir();
		File sharedFolderPath = new File(a, "/external_files");

		// Este es el mismo nombre que esta en el Manifest
		String nombreProvider = getApplicationContext().getPackageName() + ".myfileprovider";

		Uri photoURI = FileProvider.getUriForFile(this, nombreProvider, firstAudio);

		shareIntent.setType("audio/mp3");
		// shareIntent.setType("image/png");
		// shareIntent.setType("audio/*");
		// shareIntent.setType("aplication/pdf");

		shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
		shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		startActivity(Intent.createChooser(shareIntent, "Share images..."));
		//-------------------------------------------------------------

		//esto lo elimina cuando el activity se cierra. Pero a veces funciona y a veces no..
		firstAudio.deleteOnExit();
	}


}
