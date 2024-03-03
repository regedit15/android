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


	private final String[] messages = new String[]{
			"message 1",
			"message 2"
	};
	// private int currentIndex = 0;
	// private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// runOnUiThread(() -> {
		// Button aaa = findViewById(R.id.myButton);
		// aaa.setText("pepeeeeeeee");

		// new AlertDialog.Builder(this)
		// 		.setMessage("message 1")
		// 		.setCancelable(false)
		// 		.setPositiveButton("ok", (dialog, which) -> {
		// 			dialog.dismiss();
		// 		})
		// 		.setNegativeButton("Cancel", (dialog, which) -> {
		// 			dialog.dismiss();
		// 		})
		// 		.show();
		//
		// new AlertDialog.Builder(this)
		// 		.setMessage("message 1")
		// 		.setCancelable(false)
		// 		.setPositiveButton("okB", (dialog, which) -> {
		//
		// 			// ActivityCompat.requestPermissions(this, new String[]{permission}, PERMISSION_REQ_CODE);
		// 			dialog.dismiss();
		// 		})
		// 		.setNegativeButton("CancelarB", (dialog, which) -> {
		// 			dialog.dismiss();
		// 		})
		// 		.show();
		// });


		findViewById(R.id.requestPermissions).setOnClickListener(v -> {


			permissionService.requestRuntimePermissions(this, permissions);
		});


		// String[] messages = new String[]{
		// 		"message 1",
		// 		"message 2"
		// };
		//
		// for (String message : messages) {
		// 	new AlertDialog.Builder(this)
		// 			.setMessage(message)
		// 			.setCancelable(false)
		// 			.setPositiveButton("ok", (dialog, which) -> {
		// 				System.out.println("ok!");
		// 				dialog.dismiss();
		// 			})
		// 			.show();
		// }

		// showNextDialog();
	}


	// private void showNextDialog() {
	// 	if (currentIndex < messages.length) {
	// 		new AlertDialog.Builder(this)
	// 				.setMessage(messages[currentIndex])
	// 				.setCancelable(false)
	// 				.setPositiveButton("ok", (dialog, which) -> {
	// 					dialog.dismiss();
	// 					currentIndex++;
	// 					showNextDialog(); // Mostrar el siguiente diálogo
	// 				})
	// 				.show();
	// 	} else {
	// 		// Cuando se hayan mostrado todos los diálogos
	// 		Toast.makeText(this, "Todos los diálogos se han mostrado", Toast.LENGTH_SHORT).show();
	// 	}
	// }

	// private void mostrarDialogo(String title) {
	// 	new AlertDialog.Builder(this)
	// 			.setMessage("BBBBB")
	// 			.setTitle("BBBBBB")
	// 			.setCancelable(false)
	// 			.setPositiveButton("okB", (dialog, which) -> {
	//
	// 				// ActivityCompat.requestPermissions(this, new String[]{permission}, PERMISSION_REQ_CODE);
	// 				dialog.dismiss();
	// 			})
	// 			.setNegativeButton("CancelarB", (dialog, which) -> {
	// 				dialog.dismiss();
	// 			})
	// 			.show();
	// }

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		permissionService.onRequestPermissionsResult(this, requestCode, grantResults, getPackageName(), permissions);
	}
}