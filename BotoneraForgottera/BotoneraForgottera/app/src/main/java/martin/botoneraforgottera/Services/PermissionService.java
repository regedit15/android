package martin.botoneraforgottera.Services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

import martin.botoneraforgottera.Exceptions.PermissionException;

// TODO: corregir error de que si se negaron todos los permisos no aparece ningun cartel. Tiene que aparecer ele de ir a ajustes
public class PermissionService {

	private static final int PERMISSION_REQ_CODE = 100;
	private int allQuantityPermissionsOk = 0;
	private int actualIndexPermission = 1;
	List<String> permissionsForRequest = new ArrayList<String>();
	List<String> permissionsDenied = new ArrayList<String>();

	// -------------------------------------------------
	SharedPreferenceService sharedPreferenceService;
	protected static final String PERMISOS_YA_CHECKEADOS = "PERMISOS_YA_CHECKEADOS";
	protected static final String PREFERENCES = "PREFERENCES";
	// -------------------------------------------------

	Activity activity;
	String packageName;
	String[] permissionsOriginal;


	public PermissionService(Activity activity, String packageName, String[] permissionsOriginal) {
		this.activity = activity;
		this.packageName = packageName;
		this.permissionsOriginal = permissionsOriginal;
		sharedPreferenceService = new SharedPreferenceService(activity.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE));
	}


	private void messageOk() {
		if (!sharedPreferenceService.getBoolean(PERMISOS_YA_CHECKEADOS)) {
			String message;
			if (permissionsOriginal.length == 1) {
				message = "Permiso concedido, puede usar la app!";
			} else {
				message = "Todos los permisos han sido concedidos, puede usar la app!";
			}

			Toast.makeText(activity, message.toString(), Toast.LENGTH_SHORT).show();
			sharedPreferenceService.guardarBooleanYCommitear(PERMISOS_YA_CHECKEADOS, true);
		}
	}


	public void checkIfAllPermissionIsOk() throws PermissionException {
		permissionsForRequest.clear();
		int quantityPermissionsOk = 0;

		for (String permission : permissionsOriginal) {

			if (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
				// por aca entran cuando el usuario ya le ha dado el permiso para siempre
				quantityPermissionsOk++;
			} else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
				// por aca entran cuando el usuario ha negado el permiso o cuando le dió "permitir sólo esta vez" y está entrando de nuevo a la app
				permissionsDenied.add(permission);
			} else {
				// por aca entran la primera vez, cuando nunca se pidió nada
				permissionsForRequest.add(permission);
			}
		}

		if (quantityPermissionsOk == permissionsOriginal.length) {
			messageOk();
		} else {

			if (permissionsForRequest.size() > 0) {
				requestRuntimePermissions(activity);
			} else {
				StringBuilder message = new StringBuilder("La aplicación necesita los siguientes permisos que fueron rechazados: \n\n");

				addListPermissionsNegatives(message, permissionsDenied);

				message.append("\n\nPor favor vaya a los settings de la aplicación para permitirlos");


				new AlertDialog.Builder(activity)
						.setMessage(message.toString())
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
			}
			throw new PermissionException();
		}
	}

	private void addListPermissionsNegatives(StringBuilder message, List<String> permissions) {
		for (String p : permissions) {
			message.append("\n- ").append(p.split("\\.")[2]);
		}
	}

	public void requestRuntimePermissions(Activity activity) {

		StringBuilder message = new StringBuilder("La aplicación necesita los siguientes permisos para continuar: \n\n");

		addListPermissionsNegatives(message, permissionsForRequest);

		new AlertDialog.Builder(activity)
				.setMessage(message)
				.setTitle("Permisos requeridos")
				.setCancelable(false)
				.setPositiveButton("ok", (dialog, which) -> {

					ActivityCompat.requestPermissions(activity, new String[]{permissionsForRequest.get(0)}, PERMISSION_REQ_CODE);
					dialog.dismiss();

				})
				.setNegativeButton("Cancelar", (dialog, which) -> {
					dialog.dismiss();
				})
				.show();
	}

	public void onRequestPermissionsResult(int requestCode, int[] grantResults) {

		if (requestCode == PERMISSION_REQ_CODE) {

			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				// esto es si la persona le dió ok al permiso. Entonces sumamos 1 a la cantidad de permisos que estan ok
				allQuantityPermissionsOk++;
			}

			if (allQuantityPermissionsOk == permissionsOriginal.length) {
				// si todos los permisos fueron dados se muestra el mensaje de ok
				messageOk();
			} else if (actualIndexPermission < permissionsForRequest.size()) {
				// Acá entra si aún faltan permisos por aceptar
				actualIndexPermission++;
				ActivityCompat.requestPermissions(activity, new String[]{permissionsOriginal[actualIndexPermission - 1]}, PERMISSION_REQ_CODE);
			} else {
				// si terminó la vuelta de preguntarle a todos los permisos
				actualIndexPermission = 1;
			}

		}
	}


}
