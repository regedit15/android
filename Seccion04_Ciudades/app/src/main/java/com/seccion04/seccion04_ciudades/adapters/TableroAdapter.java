package com.seccion04.seccion04_ciudades.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.seccion04v2.R;
import com.example.seccion04v2.models.Tablero;

import java.text.SimpleDateFormat;
import java.util.List;

public class TableroAdapter extends BaseAdapter {

    private Context context;
    private List<Tablero> tableros;
    private int layout;


    public TableroAdapter(Context context, List<Tablero> tableros, int layout) {
        this.context = context;
        this.tableros = tableros;
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return tableros.size();
    }

    @Override
    public Tablero getItem(int posicion) {
        return tableros.get(posicion);
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

            viewHolder.titulo = convertView.findViewById(R.id.tvTableroTitulo);
            viewHolder.notas = convertView.findViewById(R.id.tvTableroNotas);
            viewHolder.fecha = convertView.findViewById(R.id.tvTableroFecha);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Tablero tablero = tableros.get(posicion);
        viewHolder.titulo.setText(tablero.getTitulo());

        String nota;

        if(tablero.getNotas().size() == 1){
            nota = " nota";
        }else{
            nota = " notas";
        }
        viewHolder.notas.setText(tablero.getNotas().size()  + nota);
        viewHolder.fecha.setText( new SimpleDateFormat("dd/MM/yy").format(tablero.getFechaCreacion()));

        return convertView;
    }

    public  class ViewHolder{
        TextView titulo;
        TextView notas;
        TextView fecha;

    }

}
