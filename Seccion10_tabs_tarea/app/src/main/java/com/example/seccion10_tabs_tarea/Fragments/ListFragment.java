package com.example.seccion10_tabs_tarea.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seccion10_tabs_tarea.R;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

	public ListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_list, container, false);
	}

}
