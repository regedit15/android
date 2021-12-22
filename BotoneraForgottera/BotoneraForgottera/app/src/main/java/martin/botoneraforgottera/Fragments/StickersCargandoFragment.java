package martin.botoneraforgottera.Fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import martin.botoneraforgottera.Activities.MainActivity;
import martin.botoneraforgottera.Interfaces.StickerListener;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Sticker.StickerPack;
import martin.botoneraforgottera.Sticker.StickerPackLoader;
import martin.botoneraforgottera.Sticker.StickerPackValidator;

public class StickersCargandoFragment extends BaseFragment {

    private View progressBar;
    private LoadListAsyncTask loadListAsyncTask;
    private TextView errorMessageTV;
    private StickerListener stickerListener;

    public StickersCargandoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paquete_stickers, container, false);

        errorMessageTV = view.findViewById(R.id.error_message);

        getActivity().overridePendingTransition(0, 0);

        // if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
        // 	((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        // }

        progressBar = view.findViewById(R.id.entry_activity_progress);
        loadListAsyncTask = new LoadListAsyncTask((MainActivity) getActivity());
        loadListAsyncTask.execute();

        return view;
    }

    private void showStickerPack(ArrayList<StickerPack> stickerPackList) {
        progressBar.setVisibility(View.GONE);

        if (stickerPackList.size() > 1) {
            // Entra aca si solo tenes mas de 1 paquete de stickers
            stickerListener.listarPaquetes(stickerPackList);
        } else {
            // Entra aca si solo tenes 1 paquete de stickers
            stickerListener.listarStickers(stickerPackList.get(0));
        }
    }

    private void showErrorMessage(String errorMessage) {
        progressBar.setVisibility(View.GONE);
        Log.e("EntryActivity", "error fetching sticker packs, " + errorMessage);
        errorMessageTV.setText(getString(R.string.error_message, errorMessage));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (loadListAsyncTask != null && !loadListAsyncTask.isCancelled()) {
            loadListAsyncTask.cancel(true);
        }
    }

    class LoadListAsyncTask extends AsyncTask<Void, Void, Pair<String, ArrayList<StickerPack>>> {
        private final WeakReference<MainActivity> contextWeakReference;

        LoadListAsyncTask(MainActivity activity) {
            this.contextWeakReference = new WeakReference<>(activity);
        }

        @Override
        protected Pair<String, ArrayList<StickerPack>> doInBackground(Void... voids) {
            ArrayList<StickerPack> stickerPackList;
            try {
                final Context context = contextWeakReference.get();
                if (context != null) {
                    stickerPackList = StickerPackLoader.fetchStickerPacks(context);
                    if (stickerPackList.size() == 0) {
                        return new Pair<>("could not find any packs", null);
                    }
                    for (StickerPack stickerPack : stickerPackList) {
                        StickerPackValidator.verifyStickerPackValidity(context, stickerPack);
                    }
                    return new Pair<>(null, stickerPackList);
                } else {
                    return new Pair<>("could not fetch sticker packs", null);
                }
            } catch (Exception e) {
                Log.e("EntryActivity", "error fetching sticker packs", e);
                return new Pair<>(e.getMessage(), null);
            }
        }

        @Override
        protected void onPostExecute(Pair<String, ArrayList<StickerPack>> stringListPair) {

            if (stringListPair.first != null) {
                showErrorMessage(stringListPair.first);
            } else {
                showStickerPack(stringListPair.second);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            stickerListener = (StickerListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " debe implementar DataListener");
        }
    }

}
