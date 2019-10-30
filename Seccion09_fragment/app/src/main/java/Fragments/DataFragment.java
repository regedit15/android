package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seccion09_fragment.R;

import androidx.fragment.app.Fragment;

public class DataFragment extends Fragment {

	public DataFragment() {
		// Required empty public constructor
	}

	// Esto devuelvo un view que esta inflado con nuestro layout
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_data, container, false);

		return view;
	}

}
