package com.example.seccion10_tabs_tarea.Adapters;

import com.example.seccion10_tabs_tarea.Fragments.FromFragment;
import com.example.seccion10_tabs_tarea.Fragments.ListFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

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
			case 0:
				fragment = new FromFragment();
				break;
			case 1:
				fragment = new ListFragment();
				break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return cantidadTabs;
	}
}
