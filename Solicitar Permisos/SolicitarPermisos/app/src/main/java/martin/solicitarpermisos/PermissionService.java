package martin.solicitarpermisos;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionService {

	private static final int PERMISSION_REQ_CODE = 100;

	private int allQuantityPermissionsOk = 0;
	private int actualIndexPermission = 0;
	// List<String> permissionsNegative = new ArrayList<String>();
	List<String> quantityPermissionsNegativeLocal = new ArrayList<String>();


	public void requestRuntimePermissions(Activity activity, String[] permissions) {

		int quantityPermissionsOk = 0;


		for (String permission : permissions) {

			if (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
				quantityPermissionsOk++;
			} else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

				quantityPermissionsNegativeLocal.add(permission);
				// quantityPermissionsNegativeLocal
			} else {
				quantityPermissionsNegativeLocal.add(permission);
			}
		}

		if (quantityPermissionsOk == permissions.length) {
			String message;
			if (permissions.length == 1) {
				message = "Permiso concedido, puede usar la app!";
			} else {
				message = "Todos los permisos han sido concedidos, puede usar la app!";
			}

			Toast.makeText(activity, message.toString(), Toast.LENGTH_SHORT).show();
		} else {
			StringBuilder message = new StringBuilder("La aplicación necesita los siguientes permisos para continuar: \n\n");

			for (String p : quantityPermissionsNegativeLocal) {
				message.append("\n- ").append(p.split("\\.")[2]);
			}

			new AlertDialog.Builder(activity)
					.setMessage(message)
					.setTitle("Permisos requeridos")
					.setCancelable(false)
					.setPositiveButton("ok", (dialog, which) -> {

						// int i = 0;
						// actualIndexPermission = i;
						// ActivityCompat.requestPermissions(activity, new String[]{permissions[0]}, PERMISSION_REQ_CODE);
						ActivityCompat.requestPermissions(activity, new String[]{quantityPermissionsNegativeLocal.get(0)}, PERMISSION_REQ_CODE);
						dialog.dismiss();

					})
					.setNegativeButton("Cancelar", (dialog, which) -> {
						dialog.dismiss();
					})
					.show();

		}
	}

	public void onRequestPermissionsResult(Activity activity, int requestCode, int[] grantResults, String packageName, String[] permissions, String[] permissionsOriginal) {

		if (requestCode == PERMISSION_REQ_CODE) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

				allQuantityPermissionsOk++;

			} else {
				// permissionsNegative.add(permissions[actualIndexPermission]);
			}

			actualIndexPermission++;

			if (actualIndexPermission < quantityPermissionsNegativeLocal.size()) {
				ActivityCompat.requestPermissions(activity, new String[]{permissionsOriginal[actualIndexPermission]}, PERMISSION_REQ_CODE);
			}
		}
	}


}
