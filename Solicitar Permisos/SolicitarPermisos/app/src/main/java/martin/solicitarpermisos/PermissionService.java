package martin.solicitarpermisos;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

public class PermissionService {

	private int currentIndex = 0;
	private int currentIndex2 = 0;
	private static final int PERMISSION_REQ_CODE = 100;

	private void showNextDialog(Activity activity, String[] permissions) {
		new AlertDialog.Builder(activity)
				.setMessage("Esta aplicación necesita el permiso de " + permissions[currentIndex].split("\\.")[2] + " para continuar")
				.setTitle("Permiso requerido")
				.setCancelable(false)
				.setPositiveButton("ok", (dialog, which) -> {

					ActivityCompat.requestPermissions(activity, new String[]{permissions[currentIndex]}, PERMISSION_REQ_CODE);
					dialog.dismiss();

					currentIndex++;
					showNextDialog(activity, permissions);
				})
				.setNegativeButton("Cancelar", (dialog, which) -> {
					dialog.dismiss();
				})
				.show();
	}

	public void requestRuntimePermissions(Activity activity, String[] permissions) {

		int quantityPermissionsOk = 0;
		for (String permission : permissions) {

			if (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
				quantityPermissionsOk++;
			} else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
				showNextDialog(activity, permissions);
				// new AlertDialog.Builder(activity)
				// 		.setMessage("Esta aplicación necesita el permiso de " + permission.split("\\.")[2] + " para continuar")
				// 		.setTitle("Permiso requerido")
				// 		.setCancelable(false)
				// 		.setPositiveButton("ok", (dialog, which) -> {
				//
				// 			ActivityCompat.requestPermissions(activity, new String[]{permission}, PERMISSION_REQ_CODE);
				// 			dialog.dismiss();
				// 		})
				// 		.setNegativeButton("Cancelar", (dialog, which) -> {
				// 			dialog.dismiss();
				// 		})
				// 		.show();
			} else {
				ActivityCompat.requestPermissions(activity, new String[]{permission}, PERMISSION_REQ_CODE);
			}
		}

		if (quantityPermissionsOk == permissions.length) {
			String message;
			if (permissions.length == 1) {
				message = "Permiso concedido, puede usar la app!";
			} else {
				message = "Todos los permisos han sido concedidos, puede usar la app!";
			}
			Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
		}
	}


	private void showNextDialog2(Activity activity, String[] permissions, String packageName) {

		new AlertDialog.Builder(activity)
				.setMessage("Esta aplicación necesita el permiso de " + permissions[currentIndex2].split("\\.")[2] + " que has rechazado, por favor conceda el permiso llendo a los ajustes")
				.setCancelable(false)
				.setPositiveButton("Ir a Settings", (dialog, which) -> {

					activity.startActivity(
							new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
									.setData(Uri.fromParts("package", packageName, null))
					);
					dialog.dismiss();
					currentIndex2++;
					showNextDialog2(activity, permissions, packageName);
				})
				.setNegativeButton("Cancelar", (dialog, which) -> {
					dialog.dismiss();
				}).show();
	}

	public void onRequestPermissionsResult(Activity activity, int requestCode, int[] grantResults, String packageName, String[] permissions) {

		for (String permission : permissions) {

			if (requestCode == PERMISSION_REQ_CODE) {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

					Toast.makeText(activity, "Permiso concedido, puede usar la app!", Toast.LENGTH_SHORT).show();

				} else if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

					showNextDialog2(activity, permissions, packageName);
					// new AlertDialog.Builder(activity)
					// 		.setMessage("Esta aplicación necesita el permiso de " + permission.split("\\.")[2] + " que has rechazado, por favor conceda el permiso llendo a los ajustes")
					// 		.setCancelable(false)
					// 		.setPositiveButton("Ir a Settings", (dialog, which) -> {
					//
					// 			activity.startActivity(
					// 					new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
					// 							.setData(Uri.fromParts("package", packageName, null))
					// 			);
					// 			dialog.dismiss();
					// 		})
					// 		.setNegativeButton("Cancelar", (dialog, which) -> {
					// 			dialog.dismiss();
					// 		}).show();

				} else {
					requestRuntimePermissions(activity, permissions);
				}
			}
		}
	}


}
