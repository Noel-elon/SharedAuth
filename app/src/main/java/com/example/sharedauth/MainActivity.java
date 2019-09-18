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

public class MainActivity extends AppCompatActivity {
    private EditText name, email, track, phone, password;
    private Button register;
    private TextView loginTV;
    public static final String MY_PREF_NAME = "MYPREFS";
    public static final String TEXT = "textName";
    public static final String TEXT2 = "textPhone";
    public static final String TEXT3 = "textEmail";
    public static final String TEXT4 = "textTrack";
    public static final String TEXT5 = "textPass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.fullNameET);
        email = findViewById(R.id.emailET);
        track = findViewById(R.id.trackET);
        phone = findViewById(R.id.phoneET);
        password = findViewById(R.id.passwordET);


        register = findViewById(R.id.registerBUT);
        loginTV = findViewById(R.id.loginTV);



        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences preferences = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
                String newName = name.getText().toString();
                String newPass = password.getText().toString();
                String newEmail = email.getText().toString();
                String newTrack = track.getText().toString();
                String newPhone = phone.getText().toString();

                if (!(newName.isEmpty() || newPass.isEmpty() || newEmail.isEmpty() || newPhone.isEmpty() || newTrack.isEmpty())){

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(TEXT, newName);
                editor.putString(TEXT3, newEmail);
                editor.putString(TEXT4, newTrack);
                editor.putString(TEXT2, newPhone);
                editor.putString(TEXT5, newPass);
                editor.apply();


                    Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();



                    Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                startActivity(intent);

            }else {
                    Toast.makeText(MainActivity.this, "Input All Information Please!", Toast.LENGTH_SHORT).show();

                }}
        });

    }
}

