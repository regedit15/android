package martin.solicitarpermisos;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

public class PermissionService {

	private static final int PERMISSION_REQ_CODE = 100;

	public void requestRuntimePermissions(Activity activity) {
		if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {

			Toast.makeText(activity, "Permiso concedido, puede usar la app!", Toast.LENGTH_SHORT).show();
		} else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, android.Manifest.permission.RECORD_AUDIO)) {
			AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			builder.setMessage("Esta aplicación necesita el permiso de grabación de audio para continuar")
					.setTitle("Permiso requerido")
					.setCancelable(false)
					.setPositiveButton("ok", (dialog, which) -> {

						ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.RECORD_AUDIO}, PERMISSION_REQ_CODE);
						dialog.dismiss();
					})
					.setNegativeButton("Cancelar", (dialog, which) -> {
						dialog.dismiss();
					});
			builder.show();
		} else {
			ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSION_REQ_CODE);
		}
	}

	public void onRequestPermissionsResult(Activity activity, int requestCode, int[] grantResults, String packageName) {
		if (requestCode == PERMISSION_REQ_CODE) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

				Toast.makeText(activity, "Permiso concedido, puede usar la app!", Toast.LENGTH_SHORT).show();

			} else if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)) {

				new AlertDialog.Builder(activity)
						.setMessage("Esta aplicación necesita el permiso de grabación que has rechazado, por favor conceda el permiso llendo a los ajustes")
						.setCancelable(false)
						.setPositiveButton("Ir a Settings", (dialog, which) -> {

							activity.startActivity(
									new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
											.setData(Uri.fromParts("package", packageName, null))
							);
							dialog.dismiss();
						})
						.setNegativeButton("Cancelar", (dialog, which) -> {
							dialog.dismiss();
						}).show();

			} else {
				requestRuntimePermissions(activity);
			}
		}
	}


}
