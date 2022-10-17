package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.helper.DBHelper;

public class MainActivity extends AppCompatActivity {

    DBHelper mydb;
    TextView edtUser, edtSenha;
    Button btnLogin;
    TextView tvcadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mydb = new DBHelper(MainActivity.this);

        getSupportActionBar().hide();

        edtUser = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnEntrar);
        tvcadastrar = findViewById(R.id.tvcadastrar);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (edtUser.getText().toString().isEmpty()) {
                    edtUser.setError("Campo Obrigatório!");
                }
                if (edtSenha.getText().toString().isEmpty()) {
                    edtSenha.setError("Campo Obrigatório!");
                }


                Boolean login = mydb.validarLoginSenha(edtUser.getText().toString(), edtSenha.getText().toString());

                if (login) {
                    Toast.makeText(MainActivity.this, "Login com sucesso", Toast.LENGTH_LONG).show();

                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putString("USER", edtUser.getText().toString());
                    myEditor.commit();


                    Intent it = new Intent(MainActivity.this, CadastrarActivity.class);
                    it.putExtra("user", edtUser.getText().toString());
                    startActivity(it);
                } else {
                    Toast.makeText(MainActivity.this, "Login incorreto", Toast.LENGTH_LONG).show();
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

    private void isLogged() {

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user = myPreferences.getString("USER", "");

        if(user.equals("")){
            return;
        }else{
            Intent it = new Intent(getApplicationContext(), CadastrarActivity.class);
            it.putExtra("user", user);
            startActivity(it);
        }

    }


}
