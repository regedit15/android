package com.example.seccion10_tabs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seccion10_tabs.R;

import androidx.fragment.app.Fragment;

public class SegundoFragment extends Fragment {

	public SegundoFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_segundo, container, false);
	}

}
