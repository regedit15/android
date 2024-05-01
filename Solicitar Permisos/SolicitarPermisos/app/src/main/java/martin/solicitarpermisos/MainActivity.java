package martin.solicitarpermisos;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private PermissionService permissionService;
	private PermissionServiceOriginal permissionServiceOriginal = new PermissionServiceOriginal();
	private String[] permissionsApp = new String[]{
			Manifest.permission.RECORD_AUDIO,
			Manifest.permission.READ_SMS
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		permissionService = new PermissionService(this, getPackageName(), permissionsApp);

		findViewById(R.id.buttonRequestPermissions).setOnClickListener(v -> {
			try {
				permissionService.checkIfAllPermissionIsOk();

				findViewById(R.id.buttonRequestPermissions).setVisibility(View.INVISIBLE);
				findViewById(R.id.textView).setVisibility(View.VISIBLE);
			} catch (PermissionException e) {
				System.out.println("No se continua con la ejecución porque no estan todos los permisos concedidos");
			}

		});
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		permissionService.onRequestPermissionsResult(requestCode, grantResults);
		// permissionServiceOriginal.onRequestPermissionsResult(this, requestCode, grantResults, getPackageName());
	}

}