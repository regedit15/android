package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saytheword.R;

import androidx.fragment.app.Fragment;

public class CardBack extends Fragment {

	public CardBack() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_card_back, container, false);
	}

}
