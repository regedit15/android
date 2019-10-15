package com.seccion04.seccion04_ciudades.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.seccion04.seccion04_ciudades.R;
import com.seccion04.seccion04_ciudades.app.ApplicationService;
import com.seccion04.seccion04_ciudades.models.Ciudad;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;

public class CrearCiudad extends AppCompatActivity {

	private Realm realm;
	private Integer idCiudad;
	private Ciudad ciudad;
	private ApplicationService applicationService = new ApplicationService();
	private ImageView imagentt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crear_ciudad);

		realm = Realm.getDefaultInstance();


		Bundle bundle = getIntent().getExtras();

		String titulo = "Alta de ciudad";

		if (bundle != null) {
			idCiudad = bundle.getInt("idCiudad");

			if (idCiudad == null) {
				ciudad = new Ciudad();
			} else {
				titulo = "Editar ciudad";

				ciudad = realm.where(Ciudad.class).equalTo("id", idCiudad).findFirst();

				((EditText) findViewById(R.id.etCiudadNombre)).setText(ciudad.getNombre());
				((EditText) findViewById(R.id.etCiudadDescripcion)).setText(ciudad.getDescripcion());
				((EditText) findViewById(R.id.etCiudadUrlImagen)).setText(ciudad.getUrlImagen());
				((RatingBar) findViewById(R.id.ratingBar)).setRating(ciudad.getRating());
				Picasso.get().load(ciudad.getUrlImagen()).into((ImageView) findViewById(R.id.ivCiudadImagen));
			}
		} else {
			ciudad = new Ciudad();
		}

		setTitle(titulo);
	}

	public void guardarCiudadClick(View view) {

		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.copyToRealmOrUpdate(ciudad);

				ciudad.setNombre(((EditText) findViewById(R.id.etCiudadNombre)).getText().toString());
				ciudad.setDescripcion(((EditText) findViewById(R.id.etCiudadDescripcion)).getText().toString());
				ciudad.setRating(((RatingBar) findViewById(R.id.ratingBar)).getRating());
				ciudad.setUrlImagen(((EditText) findViewById(R.id.etCiudadUrlImagen)).getText().toString());
			}
		});

		applicationService.guardarCiudad(ciudad);

		Toast.makeText(CrearCiudad.this, "Ciudad guardada!", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(CrearCiudad.this, MainActivity.class);
		startActivity(intent);
	}

}
