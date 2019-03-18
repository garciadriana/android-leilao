package br.com.adriana.garcia.leilao.resource;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.model.User;

public class LoginResource {
    private final TextView email;
    private final TextView password;
    private final Button buttonLogin;
    private final TextView buttonRegistrer;

    public LoginResource(Activity context) {
        email = context.findViewById(R.id.login_email);
        password = context.findViewById(R.id.login_password);
        buttonLogin = context.findViewById(R.id.login_button_login);
        buttonRegistrer = context.findViewById(R.id.login_button_register);
    }

    public TextView getEmail() {
        return email;
    }

    public TextView getPassword() {
        return password;
    }

    public Button getButtonLogin() {
        return buttonLogin;
    }

    public TextView getButtonRegistrer() {
        return buttonRegistrer;
    }

    public User getUser() {
        final User user = new User();
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        return user;
    }
}
