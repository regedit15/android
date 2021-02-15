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
    // 2- Poder agregar items
    // 3- Hacer un limpiar que saque todos los items
    // 4- Hacer como un check de comparar o algo que solo muestr los nombre y los precios
    //-------------------------------------------------------------------------------------------------------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        cambiarFragment(new CalculoFragment( ), navigationView.getMenu().getItem(0));
        cambiarFragment(new CalculoFragment());
    }


    //    private void cambiarFragment(Fragment fragment, MenuItem menuItem) {
    private void cambiarFragment(Fragment fragment) {
        //cambiamos de fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

        //para que se muestre seleccionado
        //        menuItem.setChecked(true);

        // Seteamos que el titulo de la barra sea igual que el item
        //        getSupportActionBar().setTitle(menuItem.getTitle());
    }

}