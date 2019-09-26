package com.seccion04.seccion04_ciudades.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.seccion04.seccion04_ciudades.R;
import com.seccion04.seccion04_ciudades.models.Ciudad;

import java.util.List;

public class TableroAdapter extends BaseAdapter {

    private Context context;
    private List<Ciudad> lista;
    private int layout;


    public TableroAdapter(Context context, List<Ciudad> tableros, int layout) {
        this.context = context;
        this.lista = tableros;
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Ciudad getItem(int posicion) {
        return lista.get(posicion);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.nombre = convertView.findViewById(R.id.tvCiudadNombre);
            viewHolder.descripcion = convertView.findViewById(R.id.tvCiudadDescripcion);
//            viewHolder.urlImagen = convertView.findViewById(R.id.tvCiudad);

            Picasso.with(context).load("http://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(imageView)

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Ciudad ciudad = lista.get(posicion);
        viewHolder.nombre.setText(ciudad.getNombre());
        viewHolder.descripcion.setText(ciudad.getDescripcion());
//        viewHolder.urlImagen.setText(ciudad.getUrlImagen());

        return convertView;
    }

    public class ViewHolder {
        TextView nombre;
        TextView descripcion;
        TextView urlImagen;
    }

}
