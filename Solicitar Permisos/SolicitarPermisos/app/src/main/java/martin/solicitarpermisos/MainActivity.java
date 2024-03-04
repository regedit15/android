package martin.solicitarpermisos;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private PermissionService permissionService = new PermissionService();
	private PermissionServiceOriginal permissionServiceOriginal = new PermissionServiceOriginal();
	private String[] permissionsOriginal = new String[]{
			Manifest.permission.RECORD_AUDIO,
			Manifest.permission.READ_SMS
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.requestPermissions).setOnClickListener(v -> {
			try {
				permissionService.checkIfAllPermissionIsOk(this, permissionsOriginal);

				findViewById(R.id.requestPermissions).setVisibility(View.INVISIBLE);
				findViewById(R.id.textView).setVisibility(View.VISIBLE);
			} catch (PermisoException e) {
				permissionService.requestRuntimePermissions(this, permissionsOriginal);
			}

		});
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		permissionService.onRequestPermissionsResult(this, requestCode, grantResults, getPackageName(), permissions, permissionsOriginal);
		// permissionServiceOriginal.onRequestPermissionsResult(this, requestCode, grantResults, getPackageName());
	}

}