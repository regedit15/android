package martin.solicitarpermisos;

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

	//------------------------ String
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
	//-----------------------------------------

	//------------------------ Boolean
	// Acordate de commitear despues!
	public void guardarBoolean(String clave, boolean valor) {
		editor.putBoolean(clave, valor);
	}

	public void guardarBooleanYCommitear(String clave, boolean valor) {
		editor.putBoolean(clave, valor);
		commit();
	}

	public boolean getBoolean(String clave) {
		return sharedPreferences.getBoolean(clave, false);
	}
	//-----------------------------------------

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
