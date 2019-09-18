package com.example.sharedauth;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText emailLog, passwordLog;
    private Button loginBut;
    private TextView registerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLog = findViewById(R.id.loginEmailET);
        passwordLog = findViewById(R.id.loginPasswordET);
        loginBut = findViewById(R.id.loginBUT);
        registerTV = findViewById(R.id.registerTV);





        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = emailLog.getText().toString();
                String pass = passwordLog.getText().toString();

                SharedPreferences preferences = getSharedPreferences(MainActivity.MY_PREF_NAME, MODE_PRIVATE);
                String passDis = preferences.getString(MainActivity.TEXT5, "");
                String emailDis = preferences.getString(MainActivity.TEXT3, "");

                if (!(user.isEmpty() || pass.isEmpty())) {

                    if (user.equals(emailDis) && pass.equals(passDis)) {
                        Toast.makeText(LoginActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                        startActivity(intent);


                    } else {

                        Toast.makeText(LoginActivity.this, "Wrong Info, Retry", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, "Fill The Boxes", Toast.LENGTH_SHORT).show();
                }







            }
        });
    }
}

