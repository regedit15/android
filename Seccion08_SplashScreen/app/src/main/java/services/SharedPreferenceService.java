package services;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferenceService extends AppCompatActivity {

	private SharedPreferences sharedPreferences;

	public SharedPreferenceService(SharedPreferences preferences) {
		this.sharedPreferences = preferences;

		sharedPreferences.edit().putString("aaa", "aaaasas");
		sharedPreferences.edit().commit();

		String ccc = sharedPreferences.getString("aaa", null);
		// ccc.toString();
	}

	public void guardarString(String clave, String valor) {
		sharedPreferences.edit().putString(clave, valor);
	}

	public String getString(String clave) {
		return sharedPreferences.getString(clave, null);
	}

	public void commit() {
		// Este commit es sincrónico, va a guardar los cambios y despues sigue con la proxima linea
		sharedPreferences.edit().commit();
	}

	public void apply() {
		// El apply es asincrono, va a crear un nuevo hilo para guardar todas esas cosas
		sharedPreferences.edit().apply();
	}

	public void borraTodo() {
		sharedPreferences.edit().clear().apply();
	}

}
