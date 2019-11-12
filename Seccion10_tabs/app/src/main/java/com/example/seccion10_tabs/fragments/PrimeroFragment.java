package com.example.seccion10_tabs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seccion10_tabs.R;

import androidx.fragment.app.Fragment;

public class PrimeroFragment extends Fragment {

	public PrimeroFragment() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_primero, container, false);
	}

}
