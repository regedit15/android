package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.seccion09_fragment.R;

import androidx.fragment.app.Fragment;

public class DataFragment extends Fragment {

	private DataListener dataListener;
	private Button btEnviar;

	public DataFragment() {
		// Required empty public constructor
	}

	// Esto devuelvo un view que esta inflado con nuestro layout
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


		final View view = inflater.inflate(R.layout.fragment_data, container, false);

		final EditText etDato = view.findViewById(R.id.et_dato);
		btEnviar = view.findViewById(R.id.bt_enviar);

		// no se puede usar el metodo al boton directamente porque da un error.
		// Ya que el boton esta en el activity y no puede ver este metodo
		btEnviar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// aca no esta el findViewById directamente, ya que estamos dentro del activity
				dataListener.enviarDatos(etDato.getText().toString());
			}
		});

		return view;
	}

	// El contexto que le llega aca es el del activity
	// entonces tenemos que comprobar que este usando la
	// interfaz que definimos (DataListener)
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		try {
			dataListener = (DataListener) context;
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " debe implementar DataListener");
		}
	}

	public interface DataListener {
		void enviarDatos(String dato);
	}

}
