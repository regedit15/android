package martin.botoneraforgottera.Fragments;

import android.content.Context;

import androidx.fragment.app.Fragment;

import java.io.File;

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
    protected static final String SI = "SI";
    protected SharedPreferenceService sharedPreferenceService;

    public BaseFragment() {

    }

    protected SharedPreferenceService getsharedPreferenceService() {
        if (sharedPreferenceService == null) {
            sharedPreferenceService = new SharedPreferenceService(getActivity().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE));
        }
        return sharedPreferenceService;
    }

    protected void compartirAudio(int idAudio) {
        fileAudio = audioService.compartirAudio(this, idAudio);
    }

}
