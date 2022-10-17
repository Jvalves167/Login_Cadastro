package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.helper.DBHelper;

public class CadastrarActivity extends AppCompatActivity {

    DBHelper mydb;
    TextView edtUser, edtEmail, edtSenha;
    Button btncadastra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        mydb = new DBHelper(CadastrarActivity.this);

        getSupportActionBar().hide();

        edtUser = findViewById(R.id.edt_user);
        edtEmail = findViewById(R.id.edt_senha);
        edtSenha = findViewById(R.id.edt_email);
        btncadastra = findViewById(R.id.btn_cadastrar);

        btncadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtUser.getText().toString().isEmpty()) {
                    edtUser.setError("Campo Obrigatório!");
                }
                if (edtEmail.getText().toString().isEmpty()) {
                    edtEmail.setError("Campo Obrigatório!");
                }
                if (edtSenha.getText().toString().isEmpty()) {
                    edtSenha.setError("Campo Obrigatório!");
                }

                boolean isCadastrado = mydb.usuarioExistente(edtEmail.getText().toString());

                if (isCadastrado) {
                    Toast.makeText(CadastrarActivity.this, "Já existe usuário cadastrado com este email", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insert = mydb.cadastrarUsuario(edtUser.getText().toString(), edtEmail.getText().toString(),
                            edtSenha.getText().toString());


                    if (insert) {
                        Intent it = new Intent(CadastrarActivity.this, MainActivity.class);
                        it.putExtra("user", edtUser.getText().toString());
                        startActivity(it);
                    } else {
                        Toast.makeText(CadastrarActivity.this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}