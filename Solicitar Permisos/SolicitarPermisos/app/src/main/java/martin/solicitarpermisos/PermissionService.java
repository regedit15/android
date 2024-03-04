package martin.solicitarpermisos;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

// TODO: corregir error de que si se negaron todos los permisos no aparece ningun cartel. Tiene que aparecer ele de ir a ajustes
public class PermissionService {

	private static final int PERMISSION_REQ_CODE = 100;
	private int allQuantityPermissionsOk = 0;
	private int actualIndexPermission = 1;
	List<String> quantityPermissionsNegative = new ArrayList<String>();


	private void messageOk(Activity activity, String[] permissions) {
		String message;
		if (permissions.length == 1) {
			message = "Permiso concedido, puede usar la app!";
		} else {
			message = "Todos los permisos han sido concedidos, puede usar la app!";
		}

		Toast.makeText(activity, message.toString(), Toast.LENGTH_SHORT).show();
	}


	public void checkIfAllPermissionIsOk(Activity activity, String[] permissions, List<String>... parametersQuantityPermissionsNegativeLocal) throws PermisoException {

		List<String> quantityPermissionsNegativeLocal;

		if (parametersQuantityPermissionsNegativeLocal.length > 0) {
			quantityPermissionsNegativeLocal = parametersQuantityPermissionsNegativeLocal[0];
		} else {
			quantityPermissionsNegativeLocal = new ArrayList<String>();
		}

		int quantityPermissionsOk = 0;


		for (String permission : permissions) {

			if (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
				// por aca entran cuando el usuario ya le ha dado el permiso para siempre
				quantityPermissionsOk++;
			} else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
				// por aca entran cuando el usuario ha negado el permiso o cuando le dió "permitir sólo esta vez" y está entrando de nuevo a la app
				quantityPermissionsNegativeLocal.add(permission);
			} else {
				// por aca entran la primera vez
				quantityPermissionsNegativeLocal.add(permission);
			}
		}

		if (quantityPermissionsOk != permissions.length) {
			throw new PermisoException();
		}
	}

	public void requestRuntimePermissions(Activity activity, String[] permissions) {
		quantityPermissionsNegative.clear();

		try {
			checkIfAllPermissionIsOk(activity, permissions, quantityPermissionsNegative);

			messageOk(activity, permissions);
		} catch (PermisoException e) {
			StringBuilder message = new StringBuilder("La aplicación necesita los siguientes permisos para continuar: \n\n");

			for (String p : quantityPermissionsNegative) {
				message.append("\n- ").append(p.split("\\.")[2]);
			}

			new AlertDialog.Builder(activity)
					.setMessage(message)
					.setTitle("Permisos requeridos")
					.setCancelable(false)
					.setPositiveButton("ok", (dialog, which) -> {

						ActivityCompat.requestPermissions(activity, new String[]{quantityPermissionsNegative.get(0)}, PERMISSION_REQ_CODE);
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
			}

			if (allQuantityPermissionsOk == permissionsOriginal.length) {
				// si todos los permisos fueron dados se muestra el mensaje de ok
				messageOk(activity, permissionsOriginal);
			} else if (actualIndexPermission < quantityPermissionsNegative.size()) {
				// si se negó el permiso pero aún falta por preguntar los otros
				actualIndexPermission++;
				ActivityCompat.requestPermissions(activity, new String[]{permissionsOriginal[actualIndexPermission - 1]}, PERMISSION_REQ_CODE);
			} else {
				// si terminó la vuelta de preguntarle a todos los permisos
				actualIndexPermission = 1;
			}

		}
	}


}
