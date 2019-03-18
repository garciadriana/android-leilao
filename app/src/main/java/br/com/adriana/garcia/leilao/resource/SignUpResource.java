package br.com.adriana.garcia.leilao.resource;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.model.User;

public class SignUpResource {

    private final TextView name;
    private final TextView email;
    private final TextView password;
    private final TextView type;
    private final Button buttonSubmit;

    public SignUpResource(Activity context) {
        name = context.findViewById(R.id.sign_up_name);
        email = context.findViewById(R.id.sign_up_email);
        password = context.findViewById(R.id.sign_up_password);
        type = context.findViewById(R.id.sign_up_type);
        buttonSubmit = context.findViewById(R.id.sign_up_submit);
    }

    public TextView getName() {
        return name;
    }

    public TextView getEmail() {
        return email;
    }

    public TextView getPassword() {
        return password;
    }

    public TextView getType() {
        return type;
    }

    public Button getButtonSubmit() {
        return buttonSubmit;
    }

    public User getUser() {
        final User user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        user.setType(type.getText().toString());
        return user;
    }
}
