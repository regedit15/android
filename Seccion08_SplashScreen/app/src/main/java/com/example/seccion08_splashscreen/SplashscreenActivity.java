package com.example.seccion08_splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class SplashscreenActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Para que se vea el splashscreen sino tarda muy poco
		SystemClock.sleep(4000);

		if (sharedPreferenceService.getString(EMAIL) != null && sharedPreferenceService.getString(PASSWORD) != null) {
			startActivity(new Intent(this, MainActivity.class));
		} else {
			startActivity(new Intent(this, LoginActivity.class));
		}

		//Esto es para finalizar el activity, para que si apretas volver no vuelva. Finaliza la instancia del activity
		finish();

	}
}
