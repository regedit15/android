package martin.botoneraforgottera.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import java.io.File;

import androidx.fragment.app.Fragment;
import martin.botoneraforgottera.Exceptions.PermisoException;
import martin.botoneraforgottera.Services.UtilService;

public class BaseFragment extends Fragment {

	protected String NOMBRE_FILE_PROVIDER = "myfileprovider";
	protected int CODIGO_SHARE_OK = 1515;
	protected UtilService utilService = new UtilService();

	protected void validarPermisos() throws PermisoException {
		if (!checkPermisos(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
			throw new PermisoException();
		}
	}

	protected boolean checkPermisos(String permission) {
		return getContext().checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	}

	protected String getNombreProvider() {
		return new StringBuilder(getContext().getApplicationContext().getPackageName()).append(".").append(NOMBRE_FILE_PROVIDER).toString();
	}

	protected void eliminarFileSiExiste(File file) {
		if (file != null && file.exists()) {
			file.delete();
		}
	}

	protected void irAConfiguracionDeLaApp() {
		Toast.makeText(getContext(), "No aceptaste los permisos", Toast.LENGTH_LONG).show();

		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setData(Uri.parse("package:" + getContext().getApplicationContext().getPackageName()));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		startActivity(intent);
	}

}
