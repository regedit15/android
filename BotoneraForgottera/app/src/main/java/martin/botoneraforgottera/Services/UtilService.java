package martin.botoneraforgottera.Services;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.core.content.FileProvider;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;

public class UtilService {

	public List<Audio> getAudios() {
		return new ArrayList<Audio>() {{
			add(new Audio(R.raw.uber1, "Te voy a tocar la jalea", "Descripción 1"));
			// add(new Audio(R.raw.uber1, "Te voy a tocar la jalea", "Descripción 1"));
			add(new Audio(R.raw.luacha1, "Luacha 1", "Descripción 22"));
		}};
	}

	public void getAudios2() {
		// // Directorio del telefono, el de mas arriba, el de "Este equipo\moto g(7)\Almacenamiento interno compartido"
		// File filePath = Environment.getExternalStorageDirectory();
		// // Directorio de Downloads: "Este equipo\moto g(7)\Almacenamiento interno compartido\Download"
		// // File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		//
		// InputStream inputStream = getResources().openRawResource(R.raw.audio);
		// File file = new File(filePath, "audiocopia.mp3");
		//
		// try {
		// 	FileUtils.copyInputStreamToFile(inputStream, file);
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }
		//
		//
		// Intent shareIntent = new Intent(Intent.ACTION_SEND);
		//
		// // File a = getApplicationContext().getFilesDir();
		// // File sharedFolderPath = new File(a, "/external_files");
		//
		// // Este es el mismo nombre que esta en el Manifest
		// String nombreProvider = getApplicationContext().getPackageName() + ".myfileprovider";
		//
		// Uri photoURI = FileProvider.getUriForFile(this, nombreProvider, file);
		//
		// shareIntent.setType("audio/mp3");
		// // shareIntent.setType("image/png");
		// // shareIntent.setType("audio/*");
		// // shareIntent.setType("aplication/pdf");
		//
		// shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
		// shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		// // startActivity(Intent.createChooser(shareIntent, "Share images..."));
		//
		// startActivityForResult(Intent.createChooser(shareIntent, "Share images..."), CODIGO_OK);
		// // Esto lo elimina cuando el activity se cierra. Pero a veces funciona y a veces no..
		// // file.deleteOnExit();
	}



}
