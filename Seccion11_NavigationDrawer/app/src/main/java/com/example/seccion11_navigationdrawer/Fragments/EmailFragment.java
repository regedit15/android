package com.example.seccion11_navigationdrawer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seccion11_navigationdrawer.R;

import androidx.fragment.app.Fragment;

public class EmailFragment extends Fragment {

	public EmailFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_email, container, false);
	}

}
