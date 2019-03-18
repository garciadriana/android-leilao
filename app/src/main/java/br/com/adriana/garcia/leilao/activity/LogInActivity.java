package br.com.adriana.garcia.leilao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.model.User;
import br.com.adriana.garcia.leilao.repository.UserRepository;
import br.com.adriana.garcia.leilao.resource.LoginResource;

public class LogInActivity extends AppCompatActivity {


    private LogInActivity context;
    private LoginResource loginResource;
    private UserRepository userRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
        init();
        loginResource.getButtonLogin().setOnClickListener(this::login);
        loginResource.getButtonRegistrer().setOnClickListener(this::singUp);
    }


    private void init() {
        context = LogInActivity.this;
        loginResource = new LoginResource(context);
        userRepository = new DatabaseFactory().getDatabase(context).getUserRepository();
    }

    private void login(View view) {
        final User userResource = loginResource.getUser();
        final User user = userRepository.login(userResource.getEmail(), userResource.getPassword());
        if (null == user) {
            Snackbar
                    .make(view, "Usuario ou senha invalidos", Snackbar.LENGTH_LONG)
                    .show();
        } else {
            Intent intent = getIntent(user);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }

    private Intent getIntent(User user) {
        if (User.LEILOEIRO.equalsIgnoreCase(user.getType())) {
            return new Intent(context, LeilaoActivity.class);
        }
        return new Intent(context, ParticipantActivity.class);
    }

    private void singUp(View view) {
        Intent intent = new Intent(context, SignUpActivity.class);
        startActivity(intent);
    }
}
