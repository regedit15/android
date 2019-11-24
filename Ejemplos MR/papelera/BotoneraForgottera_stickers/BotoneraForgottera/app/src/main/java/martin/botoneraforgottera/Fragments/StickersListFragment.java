package martin.botoneraforgottera.Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Activities.MainActivity;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Sticker.StickerPack;
import martin.botoneraforgottera.Sticker.StickerPackDetailsActivity;
import martin.botoneraforgottera.Sticker.StickerPackInfoActivity;
import martin.botoneraforgottera.Sticker.StickerPackLoader;
import martin.botoneraforgottera.Sticker.StickerPreviewAdapter;
import martin.botoneraforgottera.Sticker.WhitelistCheck;

// Este es el mismo de StickerPackDetailsActivity, no el de lista
public class StickersListFragment extends BaseFragmentStickers {

	/**
	 * Do not change below values of below 3 lines as this is also used by WhatsApp
	 */
	public static final String EXTRA_STICKER_PACK_ID = "sticker_pack_id";
	public static final String EXTRA_STICKER_PACK_AUTHORITY = "sticker_pack_authority";
	public static final String EXTRA_STICKER_PACK_NAME = "sticker_pack_name";

	public static final String EXTRA_STICKER_PACK_WEBSITE = "sticker_pack_website";
	public static final String EXTRA_STICKER_PACK_EMAIL = "sticker_pack_email";
	public static final String EXTRA_STICKER_PACK_PRIVACY_POLICY = "sticker_pack_privacy_policy";
	public static final String EXTRA_STICKER_PACK_LICENSE_AGREEMENT = "sticker_pack_license_agreement";
	public static final String EXTRA_STICKER_PACK_TRAY_ICON = "sticker_pack_tray_icon";
	public static final String EXTRA_SHOW_UP_BUTTON = "show_up_button";
	public static final String EXTRA_STICKER_PACK_DATA = "sticker_pack";

	private RecyclerView recyclerView;
	private GridLayoutManager layoutManager;
	private StickerPreviewAdapter stickerPreviewAdapter;
	private int numColumns;
	private View addButton;
	private View alreadyAddedText;
	private StickerPack stickerPack;
	private View divider;
	private WhiteListCheckAsyncTask whiteListCheckAsyncTask;

	public StickersListFragment(StickerPack stickerPack) {
		this.stickerPack = stickerPack;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_stickers_list, container, false);


		// boolean showUpButton = getActivity().getIntent().getBooleanExtra(EXTRA_SHOW_UP_BUTTON, false);
		// stickerPack = getActivity().getIntent().getParcelableExtra(EXTRA_STICKER_PACK_DATA);

		TextView packNameTextView = view.findViewById(R.id.pack_name);
		TextView packPublisherTextView = view.findViewById(R.id.author);
		ImageView packTrayIcon = view.findViewById(R.id.tray_image);
		TextView packSizeTextView = view.findViewById(R.id.pack_size);

		addButton = view.findViewById(R.id.add_to_whatsapp_button);
		alreadyAddedText = view.findViewById(R.id.already_added_text);
		layoutManager = new GridLayoutManager(getContext(), 1);
		recyclerView = view.findViewById(R.id.sticker_list);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(pageLayoutListener);
		recyclerView.addOnScrollListener(dividerScrollListener);
		divider = view.findViewById(R.id.divider);
		if (stickerPreviewAdapter == null) {
			stickerPreviewAdapter = new StickerPreviewAdapter(getLayoutInflater(), R.drawable.sticker_error, getResources().getDimensionPixelSize(R.dimen.sticker_pack_details_image_size), getResources().getDimensionPixelSize(R.dimen.sticker_pack_details_image_padding), stickerPack);
			recyclerView.setAdapter(stickerPreviewAdapter);
		}
		packNameTextView.setText(stickerPack.name);
		packPublisherTextView.setText(stickerPack.publisher);
		packTrayIcon.setImageURI(StickerPackLoader.getStickerAssetUri(stickerPack.identifier, stickerPack.trayImageFile));
		packSizeTextView.setText(Formatter.formatShortFileSize(getContext(), stickerPack.getTotalSize()));
		addButton.setOnClickListener(v -> addStickerPackToWhatsApp(stickerPack.identifier, stickerPack.name));

		// if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
		// 	((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
		// 	((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(showUpButton ? getResources().getString(R.string.title_activity_sticker_pack_details_multiple_pack) : getResources().getQuantityString(R.plurals.title_activity_sticker_packs_list, 1));
		// }

		return view;
	}

	private void launchInfoActivity(String publisherWebsite, String publisherEmail, String privacyPolicyWebsite, String licenseAgreementWebsite, String trayIconUriString) {
		Intent intent = new Intent(getContext(), StickerPackInfoActivity.class);
		intent.putExtra(StickerPackDetailsActivity.EXTRA_STICKER_PACK_ID, stickerPack.identifier);
		intent.putExtra(StickerPackDetailsActivity.EXTRA_STICKER_PACK_WEBSITE, publisherWebsite);
		intent.putExtra(StickerPackDetailsActivity.EXTRA_STICKER_PACK_EMAIL, publisherEmail);
		intent.putExtra(StickerPackDetailsActivity.EXTRA_STICKER_PACK_PRIVACY_POLICY, privacyPolicyWebsite);
		intent.putExtra(StickerPackDetailsActivity.EXTRA_STICKER_PACK_LICENSE_AGREEMENT, licenseAgreementWebsite);
		intent.putExtra(StickerPackDetailsActivity.EXTRA_STICKER_PACK_TRAY_ICON, trayIconUriString);
		startActivity(intent);
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// 	getActivity().getMenuInflater().inflate(R.menu.toolbar, menu);
	// 	return super.onCreateOptionsMenu(menu);
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// 	if (item.getItemId() == R.id.action_info && stickerPack != null) {
	// 		Uri trayIconUri = StickerPackLoader.getStickerAssetUri(stickerPack.identifier, stickerPack.trayImageFile);
	// 		launchInfoActivity(stickerPack.publisherWebsite, stickerPack.publisherEmail, stickerPack.privacyPolicyWebsite, stickerPack.licenseAgreementWebsite, trayIconUri.toString());
	// 		return true;
	// 	}
	// 	return super.onOptionsItemSelected(item);
	// }

	private final ViewTreeObserver.OnGlobalLayoutListener pageLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
		@Override
		public void onGlobalLayout() {
			setNumColumns(recyclerView.getWidth() / recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.sticker_pack_details_image_size));
		}
	};

	private void setNumColumns(int numColumns) {
		if (this.numColumns != numColumns) {
			layoutManager.setSpanCount(numColumns);
			this.numColumns = numColumns;
			if (stickerPreviewAdapter != null) {
				stickerPreviewAdapter.notifyDataSetChanged();
			}
		}
	}

	private final RecyclerView.OnScrollListener dividerScrollListener = new RecyclerView.OnScrollListener() {
		@Override
		public void onScrollStateChanged(@NonNull final RecyclerView recyclerView, final int newState) {
			super.onScrollStateChanged(recyclerView, newState);
			updateDivider(recyclerView);
		}

		@Override
		public void onScrolled(@NonNull final RecyclerView recyclerView, final int dx, final int dy) {
			super.onScrolled(recyclerView, dx, dy);
			updateDivider(recyclerView);
		}

		private void updateDivider(RecyclerView recyclerView) {
			boolean showDivider = recyclerView.computeVerticalScrollOffset() > 0;
			if (divider != null) {
				divider.setVisibility(showDivider ? View.VISIBLE : View.INVISIBLE);
			}
		}
	};

	@Override
	public void onResume() {
		super.onResume();
		whiteListCheckAsyncTask = new WhiteListCheckAsyncTask((MainActivity) getActivity());
		whiteListCheckAsyncTask.execute(stickerPack);
	}

	@Override
	public void onPause() {
		super.onPause();
		if (whiteListCheckAsyncTask != null && !whiteListCheckAsyncTask.isCancelled()) {
			whiteListCheckAsyncTask.cancel(true);
		}
	}

	class WhiteListCheckAsyncTask extends AsyncTask<StickerPack, Void, Boolean> {
		private final WeakReference<MainActivity> stickerPackDetailsActivityWeakReference;

		WhiteListCheckAsyncTask(MainActivity stickerPackListActivity) {
			this.stickerPackDetailsActivityWeakReference = new WeakReference<>(stickerPackListActivity);
		}

		@Override
		protected final Boolean doInBackground(StickerPack... stickerPacks) {
			StickerPack stickerPack = stickerPacks[0];
			final MainActivity stickerPackDetailsActivity = stickerPackDetailsActivityWeakReference.get();
			if (stickerPackDetailsActivity == null) {
				return false;
			}
			return WhitelistCheck.isWhitelisted(stickerPackDetailsActivity, stickerPack.identifier);
		}

		@Override
		protected void onPostExecute(Boolean isWhitelisted) {
			final MainActivity stickerPackDetailsActivity = stickerPackDetailsActivityWeakReference.get();
			if (stickerPackDetailsActivity != null) {
				updateAddUI(isWhitelisted);
			}
		}
	}

	private void updateAddUI(Boolean isWhitelisted) {
		if (isWhitelisted) {
			addButton.setVisibility(View.GONE);
			alreadyAddedText.setVisibility(View.VISIBLE);
		} else {
			addButton.setVisibility(View.VISIBLE);
			alreadyAddedText.setVisibility(View.GONE);
		}
	}

}
