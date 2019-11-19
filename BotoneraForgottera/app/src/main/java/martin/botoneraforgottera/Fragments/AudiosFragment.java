package martin.botoneraforgottera.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Adapters.AudioAdapter;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Services.UtilService;

public class AudiosFragment extends Fragment {

	private RecyclerView recyclerView;
	private AudioAdapter audioAdapter;
	private List<Audio> audios;
	private RecyclerView.LayoutManager mLayoutManager;
	private UtilService utilService = new UtilService();
	// private ApplicationService applicationService = new ApplicationService();

	public AudiosFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_audios, container, false);
		audios = utilService.getAudios();

		// ciudades = realm.where(Ciudad.class).findAll();
		// audios.addChangeListener(this);


		recyclerView = view.findViewById(R.id.rvListadoCiudades);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		// mLayoutManager = new LinearLayoutManager(this);
		mLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(mLayoutManager);


		// floatingActionButton = view.findViewById(R.id.btAgregarCiudad);

		// recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
		// 	@Override
		// 	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		// 		if (dy > 0) {
		// 			floatingActionButton.hide();
		// 		} else if (dy < 0) {
		// 			floatingActionButton.show();
		// 		}
		// 	}
		// });


		// audioAdapter = new AudioAdapter(audios, R.layout.item_audio, new AudioAdapter.OnItemClickListener() {
		// 	@Override
		// 	public void onItemClick(Ciudad ciudad, int position) {
		// 		Intent intent = new Intent(MainActivity.this, CrearCiudad.class);
		// 		intent.putExtra("idCiudad", ciudad.getId());
		// 		startActivity(intent);
		// 	}
		// }, new CiudadAdapter.OnButtonClickListener() {
		// 	@Override
		// 	public void onButtonClick(Ciudad ciudad, int position) {
		// 		mostrarPopupEliminarCiudad("Eliminar ciudad", "Esta seguro que desea eliminar la ciudad " + ciudad.getNombre() + "?", position);
		// 	}
		// });
		audioAdapter = new AudioAdapter(audios, R.layout.item_audio);

		recyclerView.setAdapter(audioAdapter);
		// audios.addChangeListener(this);


		return view;
	}

}
