package com.snonosystems.sakeny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView txtSignup;
    ViewDialog dialog;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtSignup = findViewById(R.id.txt_signup);
        btn_login = findViewById(R.id.btn_login);
        dialog = new ViewDialog();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        dialog.showDialog(LoginActivity.this,"Error To Login .. Please Check Your Internet");
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), StartActivity.class));

            }
        });


    }

}
