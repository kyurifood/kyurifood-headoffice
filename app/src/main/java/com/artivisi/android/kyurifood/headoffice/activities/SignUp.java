package com.artivisi.android.kyurifood.headoffice.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.artivisi.android.kyurifood.headoffice.R;

/**
 * Created by sandyfajar on 26/05/16.
 */
public class SignUp extends AppCompatActivity {


    EditText txtnama, txtemail, txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


    }

    public boolean validate() {
        boolean valid = true;

        txtnama = (EditText) findViewById(R.id.input_name);
        txtemail = (EditText) findViewById(R.id.input_email);
        txtpassword = (EditText) findViewById(R.id.input_password);

        String name = txtnama.getText().toString();
        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            txtnama.setError("minimal 3 karakter");
            valid = false;
        } else {
            txtnama.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtemail.setError("email tidak valid");
            valid = false;
        } else {
            txtemail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            txtpassword.setError("masukan antara 4 dan 10 karakter alfanumerik");
            valid = false;
        } else {
            txtpassword.setError(null);
        }

        return valid;
    }
}

