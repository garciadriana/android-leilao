package br.com.adriana.garcia.leilao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import br.com.adriana.garcia.leilao.R;
import br.com.adriana.garcia.leilao.config.DatabaseFactory;
import br.com.adriana.garcia.leilao.repository.UserRepository;
import br.com.adriana.garcia.leilao.resource.SignUpResource;

public class SignUpActivity extends AppCompatActivity {
    private SignUpActivity context;
    private SignUpResource loginResource;
    private UserRepository userRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_sign_up);
        init();

        loginResource.getButtonSubmit().setOnClickListener(this::saveUser);

    }

    private void init() {
        context = SignUpActivity.this;
        loginResource = new SignUpResource(context);
        userRepository = new DatabaseFactory().getDatabase(context).getUserRepository();
    }

    private void saveUser(View view) {
        userRepository.insert(loginResource.getUser());
        onBackPressed();
    }


}
