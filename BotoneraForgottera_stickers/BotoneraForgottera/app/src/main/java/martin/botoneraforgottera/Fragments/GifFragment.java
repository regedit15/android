package martin.botoneraforgottera.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import martin.botoneraforgottera.R;

public class GifFragment extends BaseFragment {

	public GifFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_gif, container, false);
	}

}
