package com.example.seccion04v2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.seccion04v2.R;
import com.example.seccion04v2.models.Nota;
import com.example.seccion04v2.models.Tablero;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotaAdapter extends BaseAdapter {

    private Context context;
    private List<Nota> notas;
    private int layout;


    public NotaAdapter(Context context, List<Nota> notas, int layout) {
        this.context = context;
        this.notas = notas;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return notas.size();
    }

    @Override
    public Nota getItem(int posicion) {
        return notas.get(posicion);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.descripcion = convertView.findViewById(R.id.tvNotaDescripcion);
            viewHolder.fecha = convertView.findViewById(R.id.tvNotaFecha);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Nota nota = notas.get(posicion);

        viewHolder.descripcion.setText(nota.getDescripcion());
        viewHolder.fecha.setText( new SimpleDateFormat("dd/MM/yy").format(nota.getFechaCreacion()));

        return convertView;
    }

    public  class ViewHolder{
        TextView descripcion;
        TextView fecha;
    }

}
