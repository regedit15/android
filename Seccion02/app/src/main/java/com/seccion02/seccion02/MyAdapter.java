package com.seccion02.seccion02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import models.Frutas;

public class MyAdapter extends BaseAdapter {

    private Context contex;
    private int layout;
    private List<Frutas> frutas;
    private ViewHolder viewHolder;

    public MyAdapter(Context contex, int layout, List<Frutas> frutas) {
        this.contex = contex;
        this.layout = layout;
        this.frutas = frutas;
    }

    // devuelve la cantidad de items que va a tener el adaptados
    @Override
    public int getCount() {
        return frutas.size();
    }

    @Override
    public Frutas getItem(int position) {
        return frutas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    // position : posicion
    // convertView: es como si fuera un item en la lista de Views
    // parent: vendria a ser la lista entera, osea, un grupo de views
    //
    // En este metodo tenemos que tomar el view que llega por parametro, personalizarlo y devolverlo
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(contex);
            convertView = layoutInflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.tituloFruta = convertView.findViewById(R.id.tituloFruta2);
            viewHolder.descripcionFruta = convertView.findViewById(R.id.descripcionFruta2);
            viewHolder.imagenFruta = convertView.findViewById(R.id.imagenFruta2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tituloFruta.setText(getItem(position).getNombre());
        viewHolder.descripcionFruta.setText(getItem(position).getDescripcion());
        viewHolder.imagenFruta.setImageResource(getItem(position).getImagen());

        return convertView;
    }

    static class ViewHolder {
        private TextView tituloFruta;
        private TextView descripcionFruta;
        private ImageView imagenFruta;
    }
}


