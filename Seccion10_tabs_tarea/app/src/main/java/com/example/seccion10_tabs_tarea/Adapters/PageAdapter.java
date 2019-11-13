package com.example.seccion10_tabs_tarea.Adapters;

import com.example.seccion10_tabs_tarea.Fragments.FromFragment;
import com.example.seccion10_tabs_tarea.Fragments.ListFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import static com.example.seccion10_tabs_tarea.Activities.MainActivity.FRAGMENT_LISTA;
import static com.example.seccion10_tabs_tarea.Activities.MainActivity.FRAGMENT_PERSONA;

public class PageAdapter extends FragmentStatePagerAdapter {
	private int cantidadTabs;

	public PageAdapter(@NonNull FragmentManager fm, int cantidadTabs) {
		super(fm, cantidadTabs);
		this.cantidadTabs = cantidadTabs;
	}

	@NonNull
	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		switch (position) {
			case FRAGMENT_PERSONA:
				fragment = new FromFragment();
				break;
			case FRAGMENT_LISTA:
				fragment = new ListFragment();
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + position);
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return cantidadTabs;
	}
}
