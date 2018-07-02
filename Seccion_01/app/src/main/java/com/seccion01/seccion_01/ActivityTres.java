package com.seccion01.seccion_01;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivityTres extends AppCompatActivity {

    private EditText txtTelefono;
    private EditText textUsuario;
    private ImageButton btnCamara;
    private ImageButton btnUsuario;
    private ImageButton btnTelefono;
    private final int PHONE_CALL_CODE = 100;
    private final int PICTURE_POR_CAMARA = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);

        txtTelefono = findViewById(R.id.txtTelefono);
        textUsuario = findViewById(R.id.textUsuario);
    }

    @SuppressLint("MissingPermission")
    public void btnTelefonoClick(View v) {
        String telefono = txtTelefono.getText().toString();

        if (telefono == null || telefono == "") {
            Toast.makeText(ActivityTres.this, "Ingrese un nuemero!", Toast.LENGTH_LONG).show();
        } else {
            // Build.VERSION.SDK_INT = version corriendo en el dispositivo actual


            // si es una version nueva
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // pregunta al usuario los permisos
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
            }
            // si es una version vieja
            else {

                if (checkPermisos(Manifest.permission.CALL_PHONE)) {
                    llamar();
                }
                // si es una version vieja y no le habia dado permisos lo manda  a la configuracion de la app
                else {
                    Toast.makeText(ActivityTres.this, "No aceptaste los permisos", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(intent);
                }
            }
        }
    }

    public void btnBrowserClick(View v) {
        String url = textUsuario.getText().toString();
        if (url != null && !url.isEmpty()) {
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));

            // ----------- Contactos
            // Intent intentContactos = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            // startActivity(intentContactos);
            // -----------------------------

            // ----------- Mail Rapido
            // Intent intentEmail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:martinrossi9009@gmail.com"));
            // startActivity(intentEmail);
            // -----------------------------

            // ----------- Mail Completo
            Intent intentEmailCompleto = new Intent(Intent.ACTION_SEND, Uri.parse("martinrossi9009@gmail.com"));

            intentEmailCompleto.setType("plain/text");
            intentEmailCompleto.putExtra(Intent.EXTRA_SUBJECT, "Titulo del mail");
            intentEmailCompleto.putExtra(Intent.EXTRA_TEXT, "Este es mi correoooooooo");
            intentEmailCompleto.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail2@gmail.com", "mail3@gmail.com"});
            startActivity(Intent.createChooser(intentEmailCompleto, "Elije cliente de correo"));
            // -----------------------------

            // ----------- Telefono 2
            // Intent telefono2SinPermisosRequeridos = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666111222"));
            // startActivity(telefono2SinPermisosRequeridos);
            // -----------------------------
        }
    }

    public void btnCamaraClick(View v) {

        // ----------- Abrir Camara
        Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intentCamara);
        startActivityForResult(intentCamara, PICTURE_POR_CAMARA);
        // -----------------------------
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICTURE_POR_CAMARA:
                if (resultCode == Activity.RESULT_OK) {
                    String result = data.toUri(0);
                    Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show();
                } else {
                    // si cuando te abre la camara le das atras te muestra este msj
                    Toast.makeText(this, "Error con la imagen", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    private boolean checkPermisos(String permission) {
        return this.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void llamar() {
        String telefono = txtTelefono.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono));
        startActivity(intent);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        llamar();
                    } else {
                        Toast.makeText(ActivityTres.this, "No aceptaste los permisos", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse("package:" + getPackageName()));

                        // Lo de las flag es para decirle que borre el rastro de activitys que va guardando para que al darle
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        startActivity(intent);
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }


    }
}
