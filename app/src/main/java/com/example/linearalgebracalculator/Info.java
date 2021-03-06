package com.example.linearalgebracalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // FOOTER NAV START
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, Settings.class);
                startActivity(intent);
            }
        });
        Button donateButton = (Button) findViewById(R.id.donateButton);
        donateButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, Donate.class);
                startActivity(intent);
            }
        });
        Button infoButton = (Button) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, Info.class);
                startActivity(intent);
            }
        });
        // FOOTER NAV END
    }

}
