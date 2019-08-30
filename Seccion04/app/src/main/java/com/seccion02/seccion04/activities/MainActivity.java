package com.seccion02.seccion04.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.seccion02.seccion04.R;
import com.seccion02.seccion04.adapters.MyAdapter;
import com.seccion02.seccion04.models.Fruta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;

	private List<Fruta> frutas;
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


		// Enviamos el parametro this para tener tanto el activity como el contexto
		adapter = new MyAdapter(frutas, R.layout.recycler_view_item, this, new MyAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(Fruta fruta, int position) {
				fruta.agregarCantidad(1);
				adapter.notifyItemChanged(position);
				// eliminarItem(position);
				// Toast.makeText(MainActivity.this, " eliminado222", Toast.LENGTH_SHORT).show();
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
				agregarItem();
				resultado = true;
				break;
			default:
				resultado = super.onOptionsItemSelected(item);
				break;
		}
		return resultado;
	}

	private void agregarItem() {
		frutas.add(new Fruta("Nueva Fruta " + contador++, "Descripcion default", R.drawable.question));
		adapter.notifyItemInserted(frutas.size());
		layoutManager.scrollToPosition(frutas.size());
	}

	private void eliminarItem(int posicion) {
		frutas.remove(posicion);
		adapter.notifyItemRemoved(posicion);
	}

	private void setearLista() {
		frutas = new ArrayList<Fruta>();
		frutas.add(new Fruta("Ananá", "Soy un ananá muy rica", R.drawable.anana));
		frutas.add(new Fruta("Banana", "Soy una banana muy rica", R.drawable.banana));
		frutas.add(new Fruta("Brocoli", "Soy un brocoli muy rico", R.drawable.brocoli));
		frutas.add(new Fruta("Cebolla", "Soy una cebolla muy rica", R.drawable.cebolla));
		frutas.add(new Fruta("Kiwi", "Soy un kiwi muy rico", R.drawable.kiwi));
		frutas.add(new Fruta("Lechuga", "Soy un lechuga muy rica", R.drawable.lechuga));
		frutas.add(new Fruta("Limón", "Soy un limón muy rico", R.drawable.limon));
		frutas.add(new Fruta("Manzana", "Soy una manzana muy rica", R.drawable.manzana));
		frutas.add(new Fruta("Morrón", "Soy un morrón muy rico", R.drawable.morron));
		frutas.add(new Fruta("Naranja", "Soy un naranja muy rica", R.drawable.naranja));
		frutas.add(new Fruta("Pepino", "Soy un pepin muy rico", R.drawable.pepino));
		frutas.add(new Fruta("Pera", "Soy una pera muy rica", R.drawable.pera));
		frutas.add(new Fruta("Pimiento", "Soy un pimiento muy rico", R.drawable.pimiento));
		frutas.add(new Fruta("Sandía", "Soy una sandía muy rica", R.drawable.sandia));
		frutas.add(new Fruta("Uva", "Soy una uva muy rica", R.drawable.uva));
	}
}
