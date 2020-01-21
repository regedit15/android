package com.example.saytheword.Fragments;

import com.example.saytheword.Activities.MainActivity;
import com.example.saytheword.Services.RealmService;
import com.example.saytheword.Services.UtilService;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

	protected UtilService utilService = new UtilService();
	protected RealmService realmService = new RealmService();

	// Nota: el froma_layout es el id del contenedor donde va cambiando los fragments
	protected void cambiarFragment(Fragment fragment, int idFrameLayout) {
		getActivity().getSupportFragmentManager().beginTransaction().replace(idFrameLayout, fragment).addToBackStack(null).commit();
	}

	protected void setearTitulo(String titulo) {
		((MainActivity) getActivity()).getSupportActionBar().setTitle(titulo);
	}

	protected void volverAlFragmentAnterior() {
		// Nota: esto funciona siempre y cuando se le haya agregado el ".addToBackStack(null)" al cambiar de fragment
		getFragmentManager().popBackStackImmediate();
	}
}
