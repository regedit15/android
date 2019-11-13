package com.example.seccion10_tabs_tarea.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seccion10_tabs_tarea.Models.Persona;
import com.example.seccion10_tabs_tarea.R;
import com.example.seccion10_tabs_tarea.Services.UtilService;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaPersonasAdapter extends BaseAdapter {

	private Context contex;
	private int layout;
	private List<Persona> Personas;
	private ViewHolder viewHolder;
	private UtilService utilService;

	public ListaPersonasAdapter(Context contex, int layout, List<Persona> Personas) {
		this.contex = contex;
		this.layout = layout;
		this.Personas = Personas;
		this.utilService = new UtilService();
	}

	// devuelve la cantidad de items que va a tener el adaptados
	@Override
	public int getCount() {
		return Personas.size();
	}

	@Override
	public Persona getItem(int position) {
		return Personas.get(position);
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
			viewHolder.tituloPersona = convertView.findViewById(R.id.tvPersonaNombre);
			viewHolder.descripcionPersona = convertView.findViewById(R.id.tvPersonaPais);
			viewHolder.imagenBandera = convertView.findViewById(R.id.ivPersonaPais);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.tituloPersona.setText(getItem(position).getNombre());
		viewHolder.descripcionPersona.setText(getItem(position).getPais().getNombre());
		Picasso.get().load(utilService.getBandera(getItem(position).getPais().getCodigo())).into(viewHolder.imagenBandera);

		return convertView;
	}

	static class ViewHolder {
		private TextView tituloPersona;
		private TextView descripcionPersona;
		private ImageView imagenBandera;
	}
}
