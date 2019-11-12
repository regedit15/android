package com.example.seccion10_tabs.activities;

import android.os.Bundle;
import android.view.Menu;

import com.example.seccion10_tabs.R;
import com.example.seccion10_tabs.adapters.PageAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar myToolbar = findViewById(R.id.toolbar);
		//Esto es para convertir el toolbar en un action bar. Por lo que mostrara el titulo
		setSupportActionBar(myToolbar);

		TabLayout tabLayout = findViewById(R.id.tabs);

		//Se puede poner asi o como en el xml. Me parece un poco mas ordenado en el xml
		// tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
		// tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
		// tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

		// No se para que lo puso el del curso, no cambia nada. Queda comentado por las dudas
		// tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

		final ViewPager viewPager = findViewById(R.id.viewPager);
		viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));

		// para que cada vez que cambiemos de tab el view pager que es el
		// encargadod de cambiar los fragments tambien lo haga
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

			// cuando se selecciona un tab
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				int posicion = tab.getPosition();
				viewPager.setCurrentItem(posicion);
			}

			// Cuando se desselecciona un tab
			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
			}

			// Cuando se vuelve a seleccionar el mismo tab
			@Override
			public void onTabReselected(TabLayout.Tab tab) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_action_bar, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
