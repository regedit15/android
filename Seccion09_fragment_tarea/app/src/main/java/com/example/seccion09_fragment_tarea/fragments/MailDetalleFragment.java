package com.example.seccion09_fragment_tarea.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seccion09_fragment_tarea.R;
import com.example.seccion09_fragment_tarea.models.Mail;

import androidx.fragment.app.Fragment;

public class MailDetalleFragment extends Fragment {

	TextView tvSubject;
	TextView tvFrom;
	TextView tvMensaje;

	public MailDetalleFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		final View view = inflater.inflate(R.layout.fragment_mail_detalle, container, false);

		tvSubject = view.findViewById(R.id.tv_subject);
		tvFrom = view.findViewById(R.id.tv_from);
		tvMensaje = view.findViewById(R.id.tv_mensaje);

		return view;
	}

	public void setearTextos(Mail mail) {
		tvSubject.setText(mail.getTitulo());
		tvFrom.setText(mail.getMail());
		tvMensaje.setText(mail.getMensaje());
	}

}
