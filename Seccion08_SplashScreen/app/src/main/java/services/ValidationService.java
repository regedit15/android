package services;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;
import exceptions.EmailException;
import exceptions.PasswordException;

public class ValidationService extends AppCompatActivity {

	public ValidationService() {

	}

	public void validarLogin(String email, String password) throws EmailException, PasswordException {
		validarEmail(email);
		validarPassword(password);
	}

	public void validarEmail(String email) throws EmailException {
		if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
			throw new EmailException();
		}
	}

	public void validarPassword(String password) throws PasswordException {
		if (password.length() < 4) {
			throw new PasswordException();
		}
	}
}
