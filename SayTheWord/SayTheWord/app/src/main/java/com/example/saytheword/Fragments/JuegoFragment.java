package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saytheword.R;

import androidx.fragment.app.Fragment;

public class JuegoFragment extends Fragment {

	public JuegoFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_blank, container, false);


		view.findViewById(R.id.btUnIntento).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				irAJuego(1);
			}
		});

		view.findViewById(R.id.btDosIntento).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				irAJuego(2);
			}
		});

		view.findViewById(R.id.btTresIntento).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				irAJuego(3);
			}
		});
		return view;
	}
	
	private void irAJuego(int intentos){

	}

}
