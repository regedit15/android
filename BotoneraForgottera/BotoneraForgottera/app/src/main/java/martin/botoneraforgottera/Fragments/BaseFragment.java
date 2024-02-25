package martin.botoneraforgottera.Fragments;

import androidx.fragment.app.Fragment;

import java.io.File;

import martin.botoneraforgottera.Services.AudioService;
import martin.botoneraforgottera.Services.RealmService;
import martin.botoneraforgottera.Services.UtilService;

public class BaseFragment extends Fragment {

    protected UtilService utilService = new UtilService();
    protected AudioService audioService = new AudioService();
    protected RealmService realmService = new RealmService();
    protected File fileAudio;

    public BaseFragment() {

    }

    protected void compartirAudio(int idAudio) {
        fileAudio = audioService.compartirAudio(this, idAudio);
    }

}
