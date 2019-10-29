package com.example.seccion08_splashscreen;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import services.SharedPreferenceService;
import services.ValidationService;

public class BaseActivity extends AppCompatActivity {

	private static final String PREFERENCES = "Preferences";
	protected static final String EMAIL = "email";
	protected static final String PASSWORD = "password";
	protected SharedPreferenceService sharedPreferenceService;
	protected ValidationService validationService = new ValidationService();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//va a crear una instancia, un archivo donde vamos a guardar las preferencias del usuario. Se puede tener mas de una cambiandole el nombre
		// Hay que pasarle tambien un modo, el mas comun es el privado, pero hay otros como para compartirlo entre otras aplicaciones
		sharedPreferenceService = new SharedPreferenceService(getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE));
	}
}
