package martin.solicitarpermisos;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	// private static final int PERMISSION_REQ_CODE = 100;
	private PermissionService permissionService = new PermissionService();
	private String[] permissions = new String[]{
			Manifest.permission.RECORD_AUDIO,
			Manifest.permission.MANAGE_DEVICE_POLICY_MICROPHONE
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.requestPermissions).setOnClickListener(v -> {


			permissionService.requestRuntimePermissions(this, permissions);
		});
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		permissionService.onRequestPermissionsResult(this, requestCode, grantResults, getPackageName(), permissions);
	}
}