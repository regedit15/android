package actividades;

import android.content.Intent;
import android.os.Bundle;

import com.example.seccion09_fragment.R;

import Fragments.DataFragment;
import Fragments.DetalleFragment;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {
	// Esto lo puso el del curso pero al parecer no es necesario. Se deja comentado por las dudas
	// public class MainActivity extends FragmentActivity  implements DataFragment.DataListener {

	private boolean multipanel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//comprobamos si el fragmen esta renderizado. Si es nulo es porque no esta renderizado
		multipanel = getSupportFragmentManager().findFragmentById(R.id.fg_detalle) != null;
	}

	@Override
	public void enviarDatos(String dato) {

		if (multipanel) {
			DetalleFragment detalleFragment = (DetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fg_detalle);
			detalleFragment.setearTexto(dato);
		} else {
			Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
			intent.putExtra("dato", dato);
			startActivity(intent);
		}
	}
}
