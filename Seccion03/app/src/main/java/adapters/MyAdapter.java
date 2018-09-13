package adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seccion02.seccion03.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> nombres = new ArrayList<String>();
    private int layout;
    private OnItemClickListener onItemClickListener;


    public MyAdapter(List<String> nombres, int layout, OnItemClickListener onItemClickListener) {
        this.nombres = nombres;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    // metodo que se ejecuta cuando se crea el RecyclerView. Realiza el volcado de datos
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(nombres.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombre;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewNombre = itemView.findViewById(R.id.textViewNombre);
        }

        public void bind(final String nombre, final OnItemClickListener onItemClickListener) {

            // -- Se se setean todos los elementos del layout
            textViewNombre.setText(nombre);
            // ----------------------------------------------

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // se le pasa el nombre y la posicion
                    onItemClickListener.onItemClick(nombre, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String nombre, int position);
    }
}
