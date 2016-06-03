package com.artivisi.android.kyurifood.headoffice.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.artivisi.android.kyurifood.headoffice.R;
import com.artivisi.android.kyurifood.headoffice.fragments.PengaturanFragment;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btnLogin;
    TextView daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daftar = (TextView) findViewById(R.id.link_signup);
        daftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(MainActivity.this,
                        SignUp.class);
                startActivity(myIntent);
            }
        });


        txtEmail = (EditText)findViewById(R.id.input_email);
        txtPassword = (EditText)findViewById(R.id.input_password);

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String txt_email = txtEmail.getText().toString().trim();



        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                if (txtEmail.getText().toString().length() == 0 || txtPassword.getText().toString().length() == 0){
                    txtPassword.setError("Tidak boleh kosong!");
                    txtEmail.setError("Tidak boleh kosong!");
                  Toast.makeText(MainActivity.this,"Password dan Email tidak boleh kosong!",Toast.LENGTH_SHORT).show();
                }
                else if (txt_email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                    Toast.makeText(MainActivity.this,"Email Error!",Toast.LENGTH_SHORT).show();
                }
                else if (txtPassword.getText().toString().length()<4 || txtPassword.getText().toString().length()>10){
                    txtPassword.setError("Password Error!");
                    Toast.makeText(MainActivity.this,"Password berisi 4 sampai 10 alfanumerik",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                    Toast.makeText(MainActivity.this, "Login Suksess!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
