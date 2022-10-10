package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CadastrarActivity extends AppCompatActivity {

    TextView edtUser, edtEmail, edtSenha;

    Button btncadastra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        getSupportActionBar().hide();

        edtUser = findViewById(R.id.edt_user);
        edtEmail = findViewById(R.id.edt_senha);
        edtSenha = findViewById(R.id.edt_email);
        btncadastra = findViewById(R.id.btn_cadastrar);

        btncadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtUser.getText().toString().isEmpty()){
                    edtUser.setError("Campo Obrigatório!");
                }
                if(edtEmail.getText().toString().isEmpty()){
                    edtEmail.setError("Campo Obrigatório!");
                }
                if(edtSenha.getText().toString().isEmpty()){
                    edtSenha.setError("Campo Obrigatório!");
                }
            }
        });




    }
}