package com.example.seccion09_fragment_tarea.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.seccion09_fragment_tarea.R;
import com.example.seccion09_fragment_tarea.models.Mail;
import com.example.seccion09_fragment_tarea.services.UtilService;

import java.util.List;

public class MyAdapter extends BaseAdapter {

	private Context contex;
	private int layout;
	private List<Mail> mails;
	private ViewHolder viewHolder;
	private UtilService utilService = new UtilService();

	public MyAdapter(Context contex, int layout, List<Mail> mails) {
		this.contex = contex;
		this.layout = layout;
		this.mails = mails;
	}

	@Override
	public int getCount() {
		return mails.size();
	}

	@Override
	public Mail getItem(int position) {
		return mails.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(contex).inflate(layout, null);

			viewHolder.titulo = convertView.findViewById(R.id.tv_mail_titulo);
			viewHolder.descripcion = convertView.findViewById(R.id.tv_mail_descripcion);
			viewHolder.inicial = convertView.findViewById(R.id.tv_inicial);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.titulo.setText(getItem(position).getTitulo());
		viewHolder.descripcion.setText(getItem(position).getMensaje());
		viewHolder.inicial.setText(String.valueOf(getItem(position).getMail().charAt(0)));

		viewHolder.inicial.getBackground().setColorFilter(utilService.getColorRandom(), PorterDuff.Mode.SRC);

		return convertView;
	}

	static class ViewHolder {
		private TextView titulo;
		private TextView descripcion;
		private TextView inicial;
	}
}
