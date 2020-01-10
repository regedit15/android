package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;

import androidx.fragment.app.Fragment;

public class CardFront extends Fragment {

	private Palabra palabra;

	public CardFront(Palabra palabra) {
		this.palabra = palabra;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_card_front, container, false);

		((TextView) view.findViewById(R.id.tvTextoAdelante)).setText(palabra.getPalabraEsp());

		return view;
	}
}
