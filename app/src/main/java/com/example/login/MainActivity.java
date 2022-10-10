package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView edtUser, edtSenha;

    Button btnLogin;

    TextView tvcadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getSupportActionBar().hide();

        edtUser = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnEntrar);
        tvcadastrar = findViewById(R.id.tvcadastrar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtUser.getText().toString().isEmpty()){
                    edtUser.setError("Campo Obrigatório!");
                }
                if(edtSenha.getText().toString().isEmpty()){
                    edtSenha.setError("Campo Obrigatório!");
                }
            }
        });

        tvcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(it);


            }
        });






    }
}
