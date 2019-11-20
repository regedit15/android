package com.example.compartiraudio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ------------ Esto se saco de: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
		// porque sino daba un error de FileUriExposedException
		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		// ------------------------------------------------
	}

	public void compartirClick(View view) {

		try {

			File file = new File(Environment.getExternalStorageDirectory(), "audio.mp3");
			file.setReadable(true, false);

			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
			intent.setType("audio/mp3");
			startActivity(Intent.createChooser(intent, "Share image via"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
