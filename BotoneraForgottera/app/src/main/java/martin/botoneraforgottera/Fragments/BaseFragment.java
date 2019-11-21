package martin.botoneraforgottera.Fragments;

import java.io.File;

import androidx.fragment.app.Fragment;
import martin.botoneraforgottera.Services.AudioService;
import martin.botoneraforgottera.Services.UtilService;

public class BaseFragment extends Fragment {

	protected UtilService utilService = new UtilService();
	protected AudioService audioService = new AudioService();
	// protected File fileAudio;

	protected void eliminarFileSiExiste(File file) {
		if (file != null && file.exists()) {
			file.delete();
		}
	}

	protected void compartirAudoooo(int idAudio) {
		audioService.compartirAudio(this, idAudio);
	}

}
