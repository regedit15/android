package com.seccion02.seccion02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context contex;
    private int layout;
    private List<String> nombres;
    private ViewHolder viewHolder;

    public MyAdapter(Context contex, int layout, List<String> nombres) {
        this.contex = contex;
        this.layout = layout;
        this.nombres = nombres;
    }

    // devuelve la cantidad de items que va a tener el adaptados
    @Override
    public int getCount() {
        return nombres.size();
    }

    @Override
    public String getItem(int position) {
        return nombres.get(position);
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
            convertView = layoutInflater.inflate(R.layout.item_lista, null);

            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(getItem(position));

        return convertView;
    }

    static class ViewHolder {
        private TextView textView;
    }
}


