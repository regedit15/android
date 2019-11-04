package com.example.ejemplolistview.activities;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejemplolistview.R;
import com.example.ejemplolistview.adapters.MyListAdapter;
import com.example.ejemplolistview.models.Fruta;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private ListView listView;
	private List<Fruta> frutas = new ArrayList<Fruta>();
	private MyListAdapter myListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);

		frutas.add(new Fruta("Manzana", "Soy una rica manzanita", R.drawable.manzana));
		frutas.add(new Fruta("Banana", "Soy una rica bananita", R.drawable.banana));
		frutas.add(new Fruta("Naranja", "Soy una rica naranjita", R.drawable.naranja));
		frutas.add(new Fruta("Ananá", "Soy una rica ananita", R.drawable.anana));
		frutas.add(new Fruta("Pera", "Soy una rica perita", R.drawable.pera));
		frutas.add(new Fruta("Kiwi", "Soy un rica kiwicito", R.drawable.kiwi));
		frutas.add(new Fruta("Uva", "Soy una rica uvita", R.drawable.uva));
		frutas.add(new Fruta("Limón", "Soy un rico limoncito", R.drawable.limon));
		frutas.add(new Fruta("Tomate", "Soy un rico tomatito", R.drawable.tomate));
		frutas.add(new Fruta("Lechuga", "Soy una rica lechuguita", R.drawable.lechuga));
		frutas.add(new Fruta("Morron", "Soy un rico morroncito", R.drawable.morron));
		frutas.add(new Fruta("Sandía", "Soy una rica sandiita", R.drawable.sandia));
		frutas.add(new Fruta("Chile", "Soy un rico chilecito", R.drawable.pimiento));
		frutas.add(new Fruta("Pepino", "Soy un rico pepinito", R.drawable.pepino));
		frutas.add(new Fruta("Brocoli", "Soy un rico brocolito", R.drawable.brocoli));
		frutas.add(new Fruta("Cebolla", "Soy una rica cebollita", R.drawable.cebolla));

		listView = findViewById(R.id.listView);
		myListAdapter = new MyListAdapter(this, R.layout.item_lista, frutas);
		listView.setAdapter(myListAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, "Click a: " + frutas.get(position).getNombre(), Toast.LENGTH_SHORT).show();
			}
		});

		// ------------------------- Menu contextual parte 1
		registerForContextMenu(listView);
		// ------------------------------------------------------------------
	}

	// ------------------------- Menu contextual parte 2
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(frutas.get(info.position).getNombre());
		getMenuInflater().inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		boolean resultado;

		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

		switch (item.getItemId()) {
			case R.id.item_eliminar:
				frutas.remove(info.position);
				// refrezca el cambio
				myListAdapter.notifyDataSetChanged();
				resultado = true;
				break;
			default:
				resultado = super.onContextItemSelected(item);
		}
		return resultado;
	}
	// ------------------------------------------------------------------

// ------------------------- Menu tres puntitos
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.action_bar_menu, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	boolean resultado;

	switch (item.getItemId()) {
		case R.id.ic_eliminarTodos:
			frutas.clear();
			myListAdapter.notifyDataSetChanged();
			resultado = true;
			break;
		default:
			resultado = super.onOptionsItemSelected(item);
			break;
	}
	return resultado;
}
// ------------------------------------------------------------------
}
