package com.seccion02.seccion03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {

	private List<String> nombres;
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	private int contador = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setearLista();
		recyclerView = findViewById(R.id.recyclerView);


		// ----------- Tipos de Layout
		// Layout lineal
		layoutManager = new LinearLayoutManager(this);
		// Layout de grilla
		// layoutManager = new GridLayoutManager(this, 2);
		// Esto es como un grid donde tienen diferentes tamaños, como cuando ponene imagenes como en
		// mozaicos que unas son mas grandes que otras, medias desordenadas
		// layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		// -----------------------------------------------

		adapter = new MyAdapter(nombres, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(String nombre, int position) {
				eliminarItem(position);
				// Toast.makeText(MainActivity.this, nombre + " eliminado", Toast.LENGTH_SHORT).show();
			}
		});

		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		// si sabemos que este layout no va a ser mas grande, como por ejemplo, el nombre no va a ser muy grande, etc.
		// Seteando esta propiedad en true mejora la performance
		recyclerView.setHasFixedSize(true);

		// Le se teamos una animacion, en este caso, la que viene por defecto. Pero se puede crear una personalizada
		recyclerView.setItemAnimator(new DefaultItemAnimator());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.itemMenuAgregar:
				agregarItem(0);
				resultado = true;
				break;
			default:
				resultado = super.onOptionsItemSelected(item);
				break;
		}
		return resultado;
	}

	private void agregarItem(int posicion) {
		nombres.add(posicion, "Nuevo Nombre " + contador++);
		adapter.notifyItemInserted(posicion);
		layoutManager.scrollToPosition(posicion);
	}

	private void eliminarItem(int posicion) {
		nombres.remove(posicion);
		adapter.notifyItemRemoved(posicion);
	}

	private void setearLista() {
		nombres = new ArrayList<String>();
		nombres.add("Martin");
		nombres.add("Vidal");
		nombres.add("Pepe");
		nombres.add("Massa");
		nombres.add("Pedro");
		nombres.add("Pepin");
		nombres.add("Gonzalo");
		nombres.add("Macri");
		nombres.add("Del Caño");
	}
}
