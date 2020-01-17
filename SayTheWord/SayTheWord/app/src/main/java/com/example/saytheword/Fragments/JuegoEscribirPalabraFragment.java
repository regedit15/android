package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saytheword.R;

import androidx.fragment.app.Fragment;

public class JuegoEscribirPalabraFragment extends Fragment {

	public JuegoEscribirPalabraFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_escribir_palabra, container, false);

		return view;
	}

}
