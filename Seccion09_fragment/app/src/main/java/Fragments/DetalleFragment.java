package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seccion09_fragment.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {

	TextView tvTexto;

	public DetalleFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_detalle, container, false);

		tvTexto = view.findViewById(R.id.tvTexto);

		return view;
	}

	public void setearTexto(String dato) {
		tvTexto.setText(dato);
	}

}
