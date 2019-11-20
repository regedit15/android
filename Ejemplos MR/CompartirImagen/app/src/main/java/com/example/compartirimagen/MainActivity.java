package com.example.compartirimagen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private Button btShare;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btShare = findViewById(R.id.btShare);
		imageView = findViewById(R.id.ivImagen);


		// ------------ Esto se saco de: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
		// porque sino daba un error de FileUriExposedException
		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		// ------------------------------------------------

		btShare.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Drawable drawable = imageView.getDrawable();
				Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

				try {
					File file = new File(MainActivity.this.getExternalCacheDir(), "robot.png");
					FileOutputStream fileOutputStream = new FileOutputStream(file);

					bitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
					fileOutputStream.flush();
					fileOutputStream.close();
					file.setReadable(true, false);


					Intent intent = new Intent(Intent.ACTION_SEND);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
					intent.setType("image/png");
					startActivity(Intent.createChooser(intent, "Share image via"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
