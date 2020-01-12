package martin.botoneraforgottera.Services;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferenceService extends AppCompatActivity {

	private SharedPreferences sharedPreferences;
	private Editor editor;

	public SharedPreferenceService(SharedPreferences preferences) {
		this.sharedPreferences = preferences;
		this.editor = sharedPreferences.edit();
	}

	// Acordate de commitear despues!
	public void guardarString(String clave, String valor) {
		editor.putString(clave, valor);
	}

	public void guardarStringYCommitear(String clave, String valor) {
		editor.putString(clave, valor);
		commit();
	}

	public String getString(String clave) {
		return sharedPreferences.getString(clave, null);
	}

	// Este commit es sincrónico, va a guardar los cambios y despues sigue con la proxima linea
	public void commit() {
		editor.commit();
	}

	// El apply es asincrono, va a crear un nuevo hilo para guardar todas esas cosas
	public void apply() {
		editor.apply();
	}

	public void borraTodo() {
		editor.clear().apply();
	}

	public void borraClave(String clave) {
		editor.remove(clave).apply();
	}

}