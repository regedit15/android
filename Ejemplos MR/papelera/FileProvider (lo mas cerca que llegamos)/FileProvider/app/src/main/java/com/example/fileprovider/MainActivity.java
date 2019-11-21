package com.example.fileprovider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

public class MainActivity extends AppCompatActivity {

	private Button btShare;
	private ImageView ivImagen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btShare = findViewById(R.id.btShare);
		ivImagen = findViewById(R.id.ivImagen);


		// ------------ Esto se saco de: https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
		// porque sino daba un error de FileUriExposedException
		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		// ------------------------------------------------

		// ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);


		// String downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/";

		// InputStream inputStream = getResources().openRawResource(R.raw.audio);
		// File firstAudio = new File(downloadPath + "audio.mp3");
		// FileUtils.copyInputStreamToFile(inputStream, firstAudio);
		// FileUtils.copy(inputStream, firstAudio);


		// Intent intent = getIntent();
		// uri = intent.getParcelableExtra("uri");
		// uri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
		// uri = intent.getData();
		// ivImagen.setImageURI(uri);


		// Intent shareIntent = new Intent();
		// shareIntent.setAction(Intent.ACTION_SEND);
		// shareIntent.setType("audio/mp3");
		//
		// Uri uri = FileProvider.getUriForFile(this, "com.example.fileprovider.my_files", "audio.mp3");
		// shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		//
		// startActivity(Intent.createChooser(shareIntent, "holaaaaa"));


		// File file = new File(getFilesDir(), "external_files");
		//
		// if (!file.exists()) {
		// 	file.mkdirs();
		// }
		//
		// File newFile = new File(file.getPath(), "audio.mp3");
		//
		// // Write data in your file
		//
		//
		// Intent shareIntent = new Intent();
		// shareIntent.setAction(Intent.ACTION_SEND);
		//
		// Uri uri = FileProvider.getUriForFile(this, "com.example.fileprovider.myfileprovider", newFile);
		//
		// shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		// shareIntent.setType("audio/mp3");
		// shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		// startActivity(Intent.createChooser(shareIntent, "holaaaaa"));
		//
		// // Intent intent = ShareCompat.IntentBuilder.from(this).setStream(uri) // uri from FileProvider
		// // 		.setType("audio/mp3").getIntent().setAction(Intent.ACTION_VIEW) //Change if needed
		// // 		.setDataAndType(uri, "audio/mp3").addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		// //
		// // startActivity(intent);


	}

	public void shareClick(View view) {

		// ------------------- Esto es lo mas cerca que pudimos llegar con el file provider
		Intent shareIntent = new Intent(Intent.ACTION_SEND);

		File a = getApplicationContext().getFilesDir();
		File sharedFolderPath = new File(a, "/external_files");
		File toOpen = new File(sharedFolderPath.getAbsolutePath(), "robot.png");

		String nombreProvider = "com.example.fileprovider.myfileprovider";

		Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), nombreProvider, toOpen);

		shareIntent.setType("image/png");
		shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
		shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		startActivity(Intent.createChooser(shareIntent, "Share images..."));
		//-------------------------------------------------------------

		// Intent intent = ShareCompat.IntentBuilder.from(this)
		//
		// 		.setType("image/png")
		//
		// 		.setStream(photoURI)
		//
		// 		.setChooserTitle("Choose bar")
		//
		// 		.createChooserIntent()
		//
		// 		.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		//
		// startActivity(intent);

	}


}
