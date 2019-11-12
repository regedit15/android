package com.example.seccion10_tabs.adapters;

import com.example.seccion10_tabs.fragments.PrimeroFragment;
import com.example.seccion10_tabs.fragments.SegundoFragment;
import com.example.seccion10_tabs.fragments.TerceroFragment;

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
				fragment = new PrimeroFragment();
				break;
			case 1:
				fragment = new SegundoFragment();
				break;
			case 2:
				fragment = new TerceroFragment();
				break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return cantidadTabs;
	}
}
