package com.example.cuantocuesta.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cuantocuesta.Fragments.CalculoFragment;
import com.example.cuantocuesta.R;

public class MainActivity extends AppCompatActivity {

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