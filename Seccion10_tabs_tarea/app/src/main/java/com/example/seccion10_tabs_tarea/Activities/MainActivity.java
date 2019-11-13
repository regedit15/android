package com.example.seccion10_tabs_tarea.Activities;

import android.os.Bundle;

import com.example.seccion10_tabs_tarea.Adapters.PageAdapter;
import com.example.seccion10_tabs_tarea.Fragments.ListFragment;
import com.example.seccion10_tabs_tarea.Interfaces.OnPersonaCreada;
import com.example.seccion10_tabs_tarea.Models.Persona;
import com.example.seccion10_tabs_tarea.R;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements OnPersonaCreada {

	// Esto seria el numero de los tabs basicamente
	public static final int FRAGMENT_PERSONA = 0;
	public static final int FRAGMENT_LISTA = 1;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar myToolbar = findViewById(R.id.toolbar);
		setSupportActionBar(myToolbar);

		TabLayout tabLayout = findViewById(R.id.tabs);

		viewPager = findViewById(R.id.viewPager);
		viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				int posicion = tab.getPosition();
				viewPager.setCurrentItem(posicion);
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
			}
		});
	}

	@Override
	public void enviarPersona(Persona persona) {
		ListFragment listFragment = (ListFragment) getSupportFragmentManager().getFragments().get(FRAGMENT_LISTA);
		listFragment.agregarPersona(persona);
		viewPager.setCurrentItem(FRAGMENT_LISTA);
	}
}
