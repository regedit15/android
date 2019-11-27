package martin.botoneraforgottera.Fragments;

import java.io.File;

import androidx.fragment.app.Fragment;
import martin.botoneraforgottera.Services.AudioService;
import martin.botoneraforgottera.Services.RealmService;
import martin.botoneraforgottera.Services.SharedPreferenceService;
import martin.botoneraforgottera.Services.UtilService;

public class BaseFragment extends Fragment {

	protected UtilService utilService = new UtilService();
	protected AudioService audioService = new AudioService();
	protected RealmService realmService = new RealmService();
	protected File fileAudio;
	protected static final String PREFERENCES = "Preferences";
	protected static final String AUDIOS_GUARDADOS = "audiosGuardados";
	// protected SharedPreferenceService sharedPreferenceService = new SharedPreferenceService(getActivity().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE));
	protected SharedPreferenceService sharedPreferenceService;

	protected void compartirAudoooo(int idAudio) {
		fileAudio = audioService.compartirAudio(this, idAudio);
		// sharedPreferenceService = new SharedPreferenceService(getActivity().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE));
		toString();
	}

}
