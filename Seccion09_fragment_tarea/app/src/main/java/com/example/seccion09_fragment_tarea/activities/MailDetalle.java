package com.example.seccion09_fragment_tarea.activities;

import android.os.Bundle;

import com.example.seccion09_fragment_tarea.R;
import com.example.seccion09_fragment_tarea.fragments.MailDetalleFragment;
import com.example.seccion09_fragment_tarea.models.Mail;

import androidx.appcompat.app.AppCompatActivity;

public class MailDetalle extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail_detalle);

		Bundle bundle = getIntent().getExtras();

		if (bundle != null) {
			MailDetalleFragment detalleFragment = (MailDetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fg_mail_detalle);
			Mail mail = (Mail) getIntent().getSerializableExtra("mail");
			detalleFragment.setearTextos(mail);
		}

	}
}
