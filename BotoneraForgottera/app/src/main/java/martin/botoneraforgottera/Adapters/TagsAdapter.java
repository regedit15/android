package martin.botoneraforgottera.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Interfaces.OnTagClickListener;
import martin.botoneraforgottera.Models.Tag;
import martin.botoneraforgottera.R;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {

	private Context context;
	private List<Tag> lista;
	private int layout;
	private OnTagClickListener onTagClickListener;

	public TagsAdapter(List<Tag> lista, int layout, OnTagClickListener onTagClickListener) {
		this.lista = lista;
		this.layout = layout;
		this.onTagClickListener = onTagClickListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
		context = parent.getContext();
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.bind(lista.get(position), onTagClickListener);
	}

	@Override
	public int getItemCount() {
		return lista.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public Button btnClickTag;

		public ViewHolder(View itemView) {
			super(itemView);
			btnClickTag = itemView.findViewById(R.id.btTag);
		}

		public void bind(final Tag tag, final OnTagClickListener onTagClickListener) {
			btnClickTag.setText(tag.getNombre());

			btnClickTag.setText(tag.getNombre());

			btnClickTag.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onTagClickListener.onTagClick(tag);

				}
			});
		}
	}
}
