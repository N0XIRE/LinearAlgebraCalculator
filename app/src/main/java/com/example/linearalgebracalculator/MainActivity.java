package com.example.linearalgebracalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity{

    private EditText matrixWidth;
    private EditText matrixHeight;

    public final static String EXTRA_MESSAGE = "com.example.linearalgebracalculator.MESSAGE";

    public int valueWidth = 0;
    public int oldWidth = 1;
    public int valueHeight = 0;
    public int oldHeight = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrixWidth = (EditText) findViewById(R.id.matrixWidth);
        matrixHeight = (EditText) findViewById(R.id.matrixHeight);
        matrixWidth.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void afterTextChanged(Editable s) {
                try {
                    valueWidth = Integer.valueOf(String.valueOf(s));
                    if (valueWidth > 5){
                        valueWidth = 5;
                    }
                }
                catch (Exception e){

                }
                if(oldWidth > valueWidth){
                    for(int inner = 1; inner <= 5; inner++){
                        String x = "matrix";
                        x+= "" + "1" + "" + inner;
                        int id = getResources().getIdentifier(x, "id", getPackageName());
                        findViewById(id).setVisibility(View.GONE);
                    }
                }
                oldWidth = valueWidth;

                for(int inner = 1; inner <= valueWidth; inner++){
                    String x = "matrix";
                    x+= "" + "1" + "" + inner;
                    int id = getResources().getIdentifier(x, "id", getPackageName());
                    findViewById(id).setVisibility(View.VISIBLE);
                }
            }
        });
        matrixHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    valueHeight = Integer.valueOf(String.valueOf(s));
                    if (valueHeight > 5){
                        valueHeight = 5;
                    }
                }
                catch (Exception e){

                }
                if(oldHeight > valueHeight){
                    for(int outer = 1; outer <= 5; outer++ ){
                        for(int inner = 1; inner <= 5; inner++){
                            String x = "matrix";
                            x+= "" + outer + "" + inner;
                            int id = getResources().getIdentifier(x, "id", getPackageName());
                            findViewById(id).setVisibility(View.GONE);
                        }
                    }
                }
                oldHeight = valueHeight;

                for(int outer = 1; outer <= valueHeight; outer++ ){
                    for(int inner = 1; inner <= valueWidth; inner++){
                        String x = "matrix";
                        x+= "" + outer + "" + inner;
                        int id = getResources().getIdentifier(x, "id", getPackageName());
                        findViewById(id).setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        Button toCalculator = (Button) findViewById(R.id.toCalculate);
        toCalculator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, calculate_Screen.class);
                startActivity(intent);
            }
        });

        // FOOTER NAV START
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });
        Button donateButton = (Button) findViewById(R.id.donateButton);
        donateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Donate.class);
                startActivity(intent);
            }
        });
        Button infoButton = (Button) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
            }
        });
        // FOOTER NAV END
    }
}