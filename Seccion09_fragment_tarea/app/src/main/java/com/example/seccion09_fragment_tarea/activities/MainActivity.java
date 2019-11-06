package com.example.seccion09_fragment_tarea.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.seccion09_fragment_tarea.R;
import com.example.seccion09_fragment_tarea.fragments.MailDetalleFragment;
import com.example.seccion09_fragment_tarea.fragments.MailListadoFragment;
import com.example.seccion09_fragment_tarea.models.Mail;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MailListadoFragment.DataListener {

	private boolean estanEnLandscape;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);

		estanEnLandscape = getSupportFragmentManager().findFragmentById(R.id.fg_mail_detalle) != null;
	}

	@Override
	public void clickMail(Mail mail) {
		if (estanEnLandscape) {
			MailDetalleFragment detalleFragment = (MailDetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fg_mail_detalle);
			detalleFragment.setearTextos(mail);
		} else {
			Intent intent = new Intent(this, MailDetalle.class);
			intent.putExtra("mail", mail);
			startActivity(intent);
		}
	}
}
