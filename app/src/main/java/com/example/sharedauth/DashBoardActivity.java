package com.example.sharedauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);




        TextView fullName = findViewById(R.id.fullNameTV);
        TextView track = findViewById(R.id.TrackTV);
        TextView email = findViewById(R.id.EmailTV);
        TextView phone = findViewById(R.id.phoneTV);
        Button logout = findViewById(R.id.LogoutBUT);



        SharedPreferences preferences = getSharedPreferences(MainActivity.MY_PREF_NAME, MODE_PRIVATE);
        String name = preferences.getString(MainActivity.TEXT, "");
        String emailDis = preferences.getString(MainActivity.TEXT3, "");
        String phoneDis = preferences.getString(MainActivity.TEXT2, "");
        String trackDis = preferences.getString(MainActivity.TEXT4, "");


        fullName.setText(name);
        track.setText(trackDis);
        email.setText(emailDis);
        phone.setText(phoneDis);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
