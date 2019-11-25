package martin.botoneraforgottera.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Activities.MainActivity;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Sticker.StickerPack;
import martin.botoneraforgottera.Sticker.StickerPackListAdapter;
import martin.botoneraforgottera.Sticker.StickerPackListItemViewHolder;
import martin.botoneraforgottera.Sticker.WhitelistCheck;

public class StickersListadoPaquetesFragment extends BaseFragmentStickers {

	public static final String EXTRA_STICKER_PACK_LIST_DATA = "sticker_pack_list";
	private static final int STICKER_PREVIEW_DISPLAY_LIMIT = 5;
	private LinearLayoutManager packLayoutManager;
	private RecyclerView packRecyclerView;
	private static StickerPackListAdapter allStickerPacksListAdapter;
	private WhiteListCheckAsyncTask whiteListCheckAsyncTask;
	private ArrayList<StickerPack> stickerPackList;

	public StickersListadoPaquetesFragment(ArrayList<StickerPack> stickerPackList) {
		this.stickerPackList = stickerPackList;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_listado_paquetes_stickers, container, false);

		packRecyclerView = view.findViewById(R.id.sticker_pack_list);
		showStickerPackList(stickerPackList);

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		whiteListCheckAsyncTask = new WhiteListCheckAsyncTask((MainActivity) getActivity());
		whiteListCheckAsyncTask.execute(stickerPackList.toArray(new StickerPack[0]));
	}

	@Override
	public void onPause() {
		super.onPause();
		if (whiteListCheckAsyncTask != null && !whiteListCheckAsyncTask.isCancelled()) {
			whiteListCheckAsyncTask.cancel(true);
		}
	}

	private void showStickerPackList(List<StickerPack> stickerPackList) {
		allStickerPacksListAdapter = new StickerPackListAdapter(stickerPackList, onAddButtonClickedListener);
		packRecyclerView.setAdapter(allStickerPacksListAdapter);
		packLayoutManager = new LinearLayoutManager(getContext());
		packLayoutManager.setOrientation(RecyclerView.VERTICAL);
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(packRecyclerView.getContext(), packLayoutManager.getOrientation());
		packRecyclerView.addItemDecoration(dividerItemDecoration);
		packRecyclerView.setLayoutManager(packLayoutManager);
		packRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this::recalculateColumnCount);
	}

	private final StickerPackListAdapter.OnAddButtonClickedListener onAddButtonClickedListener = pack -> addStickerPackToWhatsApp(pack.identifier, pack.name);

	private void recalculateColumnCount() {

		// Solucion al error Illegalstateexception fragment .... not attached to a contex
		// Fuente: https://stackoverflow.com/questions/28672883/java-lang-illegalstateexception-fragment-not-attached-to-activity
		if (isAdded()) {

			final int previewSize = getResources().getDimensionPixelSize(R.dimen.sticker_pack_list_item_preview_image_size);
			int firstVisibleItemPosition = packLayoutManager.findFirstVisibleItemPosition();
			StickerPackListItemViewHolder viewHolder = (StickerPackListItemViewHolder) packRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
			if (viewHolder != null) {
				final int widthOfImageRow = viewHolder.imageRowView.getMeasuredWidth();
				final int max = Math.max(widthOfImageRow / previewSize, 1);
				int maxNumberOfImagesInARow = Math.min(STICKER_PREVIEW_DISPLAY_LIMIT, max);
				int minMarginBetweenImages = (widthOfImageRow - maxNumberOfImagesInARow * previewSize) / (maxNumberOfImagesInARow - 1);
				allStickerPacksListAdapter.setImageRowSpec(maxNumberOfImagesInARow, minMarginBetweenImages);
			}
		}
	}

	static class WhiteListCheckAsyncTask extends AsyncTask<StickerPack, Void, List<StickerPack>> {
		private final WeakReference<MainActivity> mainActivityWeakReference;

		WhiteListCheckAsyncTask(MainActivity mainActivity) {
			this.mainActivityWeakReference = new WeakReference<>(mainActivity);
		}

		@Override
		protected final List<StickerPack> doInBackground(StickerPack... stickerPackArray) {
			final MainActivity mainActivity = mainActivityWeakReference.get();
			if (mainActivity == null) {
				return Arrays.asList(stickerPackArray);
			}
			for (StickerPack stickerPack : stickerPackArray) {
				stickerPack.setIsWhitelisted(WhitelistCheck.isWhitelisted(mainActivity, stickerPack.identifier));
			}
			return Arrays.asList(stickerPackArray);
		}

		@Override
		protected void onPostExecute(List<StickerPack> stickerPackList) {
			final MainActivity mainActivity = mainActivityWeakReference.get();
			if (mainActivity != null) {
				allStickerPacksListAdapter.setStickerPackList(stickerPackList);
				allStickerPacksListAdapter.notifyDataSetChanged();
			}
		}
	}

}
