package martin.cuantocuesta.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import martin.cuantocuesta.Fragments.CalculoFragment;
import martin.cuantocuesta.R;

public class MainActivity extends AppCompatActivity {

	//-------------------------------------------------------------------------------------------------------
	//                                            ISSUES
	//-------------------------------------------------------------------------------------------------------
	// 1- Agregar a la app: el ejemplo de la barrita de cereal no calza con ninguno. Si compro una caja, cuanto cuesta cada barrita
	// 2- Hacer como un check de comparar o algo que solo muestr los nombre y los precios
	// 3- Poner el icono del chanchito en la barra de menu, eso debe ser fácil
	// 4- Mostrar un demo, así investigamos como podemos hacer uno de esos demos en android
	//-------------------------------------------------------------------------------------------------------


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cambiarFragment(new CalculoFragment());
	}

	private void cambiarFragment(Fragment fragment) {
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
	}

}