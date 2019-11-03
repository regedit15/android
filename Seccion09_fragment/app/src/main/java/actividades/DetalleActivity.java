package actividades;

import android.os.Bundle;

import com.example.seccion09_fragment.R;

import Fragments.DetalleFragment;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);

		Bundle bundle = getIntent().getExtras();

		if (bundle != null) {
			DetalleFragment detalleFragment = (DetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fg_detalle);
			detalleFragment.setearTexto(bundle.getString("dato"));
		}
	}

}
