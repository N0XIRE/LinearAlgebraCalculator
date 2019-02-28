package com.example.linearalgebracalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{

    private EditText matrixWidth;
    private EditText matrixHeight;

    public int valueWidth = 0;
    public int valueHeight = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matrixWidth = (EditText) findViewById(R.id.matrixWidth);
        matrixWidth.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void afterTextChanged(Editable s) {
                try {
                    valueWidth = Integer.valueOf(String.valueOf(s));
                }
                catch (Exception e){

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
                }
                catch (Exception e){

                }
            }
        });
        findViewById(R.id.matrix1).setVisibility(View.VISIBLE);
    }
    public void sendMessage(View view) {
        Button btn = (Button)findViewById(R.id.toCalculate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, calculate_Screen.class));
            }
        });
    }
}