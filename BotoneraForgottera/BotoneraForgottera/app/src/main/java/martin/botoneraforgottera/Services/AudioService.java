package martin.botoneraforgottera.Services;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AudioService {

	// ------------------ Tipos de Intent para compartir
	public String TYPE_IMAGE_ALL = "image/*";
	public String TYPE_IMAGE_PNG = "image/png";
	public String TYPE_AUDIO_ALL = "audio/*";
	public String TYPE_AUDIO_MP3 = "audio/mp3";
	public String TYPE_PDF = "aplication/pdf";
	//---------------------------------------------------------

	public static final String AUDIO_PARA_COMPARTIR = "audioBotoneraForgottera222.mp3";
	public String NOMBRE_FILE_PROVIDER = "myfileprovider";
	public int CODIGO_SHARE_OK = 1515;

	// //----------------------------- Compartir Audio
	// public boolean checkPermisos(Context context, String permission) {
	// 	// return getContext().checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	// 	return context.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	// }
	//
	// public void validarPermisos(Context context) throws PermisoException {
	// 	if (!checkPermisos(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
	// 		throw new PermisoException();
	// 	}
	// }
	//
	// // Esto devuelve un intent ya que la unica forma de llamar al startActivityForResult
	// // es en el fragment o haces un Fragment f = this y pasarlo por parametro
	// public Intent compartirAudio(Context context, Resources resources) throws PermisoException {
	//
	// 	validarPermisos(context);
	//
	// 	// Directorio del telefono, el de mas arriba, el de "Este equipo\moto g(7)\Almacenamiento interno compartido"
	// 	File filePath = Environment.getExternalStorageDirectory();
	// 	// Directorio de Downloads: "Este equipo\moto g(7)\Almacenamiento interno compartido\Download"
	// 	// File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	//
	// 	InputStream inputStream = resources.openRawResource(R.raw.audio);
	// 	File fileAudio = new File(filePath, AUDIO_PARA_COMPARTIR);
	//
	// 	copiarArchivo(inputStream, fileAudio);
	//
	// 	Intent shareIntent = new Intent(Intent.ACTION_SEND);
	// 	shareIntent.setType(TYPE_AUDIO_MP3);
	// 	shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(context, getNombreProvider(context), fileAudio));
	// 	shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
	//
	// 	return shareIntent;
	// }
	//
	// public void copiarArchivo(InputStream inputStream, File file) {
	// 	try {
	// 		FileUtils.copyInputStreamToFile(inputStream, file);
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	// }
	//
	// public String getNombreProvider(Context context) {
	// 	return new StringBuilder(context.getApplicationContext().getPackageName()).append(".").append(NOMBRE_FILE_PROVIDER).toString();
	// }
	//
	// public void irAConfiguracionDeLaApp(Context context) {
	// 	Toast.makeText(context, "No aceptaste los permisos", Toast.LENGTH_LONG).show();
	// 	Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
	// 	intent.addCategory(Intent.CATEGORY_DEFAULT);
	// 	intent.setData(Uri.parse("package:" + context.getApplicationContext().getPackageName()));
	// 	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	// 	intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
	// 	intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
	// 	context.startActivity(intent);
	// }
	// //	------------------------------------------------------------------------------------------

	//----------------------------- Compartir Audio
	// public boolean checkPermisos(Context context, String permission) {
	// 	// return getContext().checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	// 	return context.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	// }

	// public void validarPermisos(Context context) throws PermisoException {
	// 	if (!checkPermisos(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
	// 		throw new PermisoException();
	// 	}
	// }

	// Esto devuelve un intent ya que la unica forma de llamar al startActivityForResult
	// es en el fragment o haces un Fragment f = this y pasarlo por parametro
	public File compartirAudio(Fragment fragment, int idAudio) {

		File fileAudio = null;

		// Directorio del telefono, el de mas arriba, el de "Este equipo\moto g(7)\Almacenamiento interno compartido"
		// File filePath = Environment.getExternalStorageDirectory();
		// Directorio de Downloads: "Este equipo\moto g(7)\Almacenamiento interno compartido\Download"
		// File filePath = Enviroment.getFilesDir();
		// File filePath = fragment.getContext().getFilesDir();
		// File filePath = fragment.getContext().getExternalFilesDir(Environment.DIRECTORY_MUSIC);
		// Esta es la única que anda en android 11 y anteriores (por lo que hemos probado, así que nos parece la mejor)
		File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);


		InputStream inputStream = fragment.getResources().openRawResource(idAudio);
		fileAudio = new File(filePath, AUDIO_PARA_COMPARTIR);

		eliminarFileSiExiste(fileAudio);

		copiarArchivo(inputStream, fileAudio);

		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType(TYPE_AUDIO_MP3);
		shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(fragment.getContext(), getNombreProvider(fragment.getContext()), fileAudio));
		shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

		fragment.startActivityForResult(Intent.createChooser(shareIntent, "Share images..."), CODIGO_SHARE_OK);

		return fileAudio;
	}

	public void copiarArchivo(InputStream inputStream, File file) {
		try {
			FileUtils.copyInputStreamToFile(inputStream, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNombreProvider(Context context) {
		return new StringBuilder(context.getApplicationContext().getPackageName()).append(".").append(NOMBRE_FILE_PROVIDER).toString();
	}

	public void irAConfiguracionDeLaApp(Context context) {
		Toast.makeText(context, "No aceptaste los permisos", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setData(Uri.parse("package:" + context.getApplicationContext().getPackageName()));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		context.startActivity(intent);
	}
	//	------------------------------------------------------------------------------------------

	//----------------------------- Eliminar Audio
	public void eliminarFileSiExiste(File file) {
		if (file != null && file.exists()) {
			file.delete();
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("SE ELIMINO EL ARCHIVOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public void eliminarFileSiExisteResult(int requestCode, File file) {
		if (requestCode == CODIGO_SHARE_OK) {
			eliminarFileSiExiste(file);
		}
	}
	//	------------------------------------------------------------------------------------------
}
