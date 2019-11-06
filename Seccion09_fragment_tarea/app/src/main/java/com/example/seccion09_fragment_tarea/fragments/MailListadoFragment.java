package com.example.seccion09_fragment_tarea.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.seccion09_fragment_tarea.R;
import com.example.seccion09_fragment_tarea.adapters.MyAdapter;
import com.example.seccion09_fragment_tarea.models.Mail;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class MailListadoFragment extends Fragment {

	private DataListener dataListener;
	private ListView listView;
	private List<Mail> mails = new ArrayList<Mail>();
	private MyAdapter myAdapter;

	public MailListadoFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


		final View view = inflater.inflate(R.layout.fragment_mail_listado, container, false);

		mails.add(new Mail("Titulo 1", "Soy una mensaje 1", "aaa@gmail.com"));
		mails.add(new Mail("Titulo 2", "Soy una mensaje 2", "bbb@gmail.com"));
		mails.add(new Mail("Titulo 3", "Soy una mensaje 3", "ccc@gmail.com"));
		mails.add(new Mail("Titulo 4", "Soy una mensaje 4", "ddd@gmail.com"));
		mails.add(new Mail("Titulo 5", "Soy una mensaje 5", "eee@gmail.com"));
		mails.add(new Mail("Titulo 6", "Soy una mensaje 6", "fff@gmail.com"));
		mails.add(new Mail("Titulo 7", "Soy una mensaje 7", "ggg@gmail.com"));
		mails.add(new Mail("Titulo 8", "Soy una mensaje 8", "hhh@gmail.com"));
		mails.add(new Mail("Titulo 9", "Soy una mensaje 9", "iii@gmail.com"));
		mails.add(new Mail("Titulo 10", "Soy una mensaje 10", "jjj@gmail.com"));

		listView = view.findViewById(R.id.lv_mails);

		myAdapter = new MyAdapter(getContext(), R.layout.item_mail, mails);
		listView.setAdapter(myAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				dataListener.clickMail(mails.get(position));
			}
		});

		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		try {
			dataListener = (DataListener) context;
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " debe implementar DataListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		dataListener = null;
	}

	public interface DataListener {
		void clickMail(Mail mail);
	}

}
