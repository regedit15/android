package martin.saytheword.Fragments;

import androidx.fragment.app.Fragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import martin.saytheword.Activities.MainActivity;
import martin.saytheword.Services.RealmService;
import martin.saytheword.Services.UtilService;

public class BaseFragment extends Fragment {

	protected UtilService utilService = new UtilService();
	protected RealmService realmService = new RealmService();

	public BaseFragment() {
	}

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

	protected void mostrarPopup(String titulo, String mensaje) {
		new MaterialAlertDialogBuilder(getContext()).setTitle(titulo).setMessage(mensaje).setPositiveButton("Aceptar", null).show();
	}
}
