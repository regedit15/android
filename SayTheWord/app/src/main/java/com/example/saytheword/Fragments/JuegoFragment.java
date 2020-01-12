package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.example.saytheword.Services.UtilService;

import java.util.Collections;
import java.util.List;

import androidx.fragment.app.Fragment;

public class JuegoFragment extends Fragment {

	private UtilService utilService = new UtilService();
	private TextView tvPalabraMostrada;
	private List<Palabra> palabrasDesordenadas;
	private int indice;

	public JuegoFragment() {
		setHasOptionsMenu(true);
		inicializarJuego();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego, container, false);

		tvPalabraMostrada = view.findViewById(R.id.tvPalabraMostrada);
		setearTexto();

		view.findViewById(R.id.btNext).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indice++;

				if (indice == palabrasDesordenadas.size()) {
					tvPalabraMostrada.setText("CONGRATULATIONS!!!!!");
					inicializarJuego();
				} else {
					setearTexto();
				}
			}
		});

		return view;
	}

	private void setearTexto() {
		tvPalabraMostrada.setText(palabrasDesordenadas.get(indice).getPalabraIng());
	}

	private void inicializarJuego() {
		palabrasDesordenadas = utilService.getPalabras();
		Collections.shuffle(palabrasDesordenadas);
		indice = 0;
	}

	//----------- Option Menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.action_bar_menu2, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.item_reset2:
				resultado = true;
				break;
			default:
				resultado = super.onOptionsItemSelected(item);
				break;
		}
		return resultado;
	}
	//-------------------------------------------------

}
