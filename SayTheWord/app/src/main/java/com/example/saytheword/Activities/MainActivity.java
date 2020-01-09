package com.example.saytheword.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.saytheword.Adapters.MyAdapter;
import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.example.saytheword.Services.UtilService;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;
	private MyAdapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	private List<Palabra> palabras;
	private UtilService utilService = new UtilService();

	private boolean showingBack = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// if (savedInstanceState == null) {
		// 	getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new CardFront()).commit();
		// }

		palabras = utilService.getPalabras();

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
		adapter = new MyAdapter(palabras, R.layout.recycler_view_item, this, new MyAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(Palabra fruta, int position) {
				Toast.makeText(MainActivity.this, "Tocada: " + palabras.get(position).getPalabraEsp(), Toast.LENGTH_SHORT).show();
			}
		});


		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		// si sabemos que este layout no va a ser mas grande, como por ejemplo, el nombre no va a ser muy grande, etc.
		// Seteando esta propiedad en true mejora la performance
		recyclerView.setHasFixedSize(true);

		// Le seteamos una animacion, en este caso, la que viene por defecto. Pero se puede crear una personalizada
		recyclerView.setItemAnimator(new DefaultItemAnimator());
	}

	public void aaa(View view) {
		flipCard();
	}

	private void flipCard() {
		// if (showingBack) {
		// 	getSupportFragmentManager().popBackStack();
		// } else {
		//
		//
		// 	// Flip to the back.
		//
		// 	// Create and commit a new fragment transaction that adds the fragment for
		// 	// the back of the card, uses custom animations, and is part of the fragment
		// 	// manager's back stack.
		//
		// 	getSupportFragmentManager().beginTransaction()
		//
		// 			// Replace the default fragment animations with animator resources
		// 			// representing rotations when switching to the back of the card, as
		// 			// well as animator resources representing rotations when flipping
		// 			// back to the front (e.g. when the system Back button is pressed).
		// 			.setCustomAnimations(R.animator.card_flip_right_in, R.animator.card_flip_right_out, R.animator.card_flip_left_in, R.animator.card_flip_left_out)
		//
		// 			// Replace any fragments currently in the container view with a
		// 			// fragment representing the next page (indicated by the
		// 			// just-incremented currentPage variable).
		// 			.replace(R.id.contenedor, new CardBack())
		//
		// 			// Add this transaction to the back stack, allowing users to press
		// 			// Back to get to the front of the card.
		// 			.addToBackStack(null)
		//
		// 			// Commit the transaction.
		// 			.commit();
		// }

		showingBack = !showingBack;
	}
}
