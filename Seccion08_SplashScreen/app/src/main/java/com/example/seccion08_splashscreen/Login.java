package com.example.seccion08_splashscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import exceptions.EmailException;
import exceptions.PasswordException;

public class Login extends BaseActivity {

	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	private EditText etEmail;
	private EditText etPassword;
	private Switch swRecordarme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);


		SharedPreferences sharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
		sharedPreferences.edit().putString("aaa1", "1111");
		sharedPreferences.edit().commit();

		String ccc = sharedPreferences.getString("aaa1", null);
		ccc.toString();


		etEmail = findViewById(R.id.etEmail);
		etPassword = findViewById(R.id.etPassword);
		swRecordarme = findViewById(R.id.swRecordar);

		String aaa = sharedPreferenceService.getString(EMAIL);
		String bbb = sharedPreferenceService.getString(PASSWORD);

		if (sharedPreferenceService.getString(EMAIL) != null && sharedPreferenceService.getString(PASSWORD) != null) {
			etEmail.setText(sharedPreferenceService.getString(EMAIL));
			etPassword.setText(sharedPreferenceService.getString(PASSWORD));
		}
	}

	public void loginClick(View view) {
		try {
			validationService.validarLogin(etEmail.getText().toString(), etPassword.getText().toString());

			Intent intent = new Intent(this, MainActivity.class);

			//esto es para que una vez logueado, si presiona al flecha para volver atras no vuelva al login, ya que ya se encuentra logueado.
			// Entonces esto es como que borra el recorrido que va haciendo
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent);

			if (swRecordarme.isChecked()) {
				sharedPreferenceService.guardarString(EMAIL, etEmail.getText().toString());
				sharedPreferenceService.guardarString(PASSWORD, etPassword.getText().toString());
				sharedPreferenceService.commit();

				String aaa = sharedPreferenceService.getString(EMAIL);
				String bbb = sharedPreferenceService.getString(PASSWORD);
			}

		} catch (EmailException e) {
			Toast.makeText(this, "Email invalido!", Toast.LENGTH_LONG).show();
		} catch (PasswordException e) {
			Toast.makeText(this, "Password demasiado corta!", Toast.LENGTH_LONG).show();
		}
	}


}
