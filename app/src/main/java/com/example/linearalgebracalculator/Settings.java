package com.example.linearalgebracalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Settings extends AppCompatActivity {

    private AdView mBannerAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // FOOTER NAV START
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Settings.class);
                startActivity(intent);
            }
        });
        Button infoButton = (Button) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Info.class);
                startActivity(intent);
            }
        });
        // FOOTER NAV END

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        // Load the add into Admob banner view.
        mBannerAd = (AdView) findViewById(R.id.banner_AdView);
        //Load BannerAd
        showBannerAd();
    }
    private void showBannerAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mBannerAd.loadAd(adRequest);

    }
}
