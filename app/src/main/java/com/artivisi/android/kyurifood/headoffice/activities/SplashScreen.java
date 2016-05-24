package com.artivisi.android.kyurifood.headoffice.activities;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

import com.artivisi.android.kyurifood.headoffice.R;

/**
 * Created by dotachin on 23/05/16.
 */
public class SplashScreen extends Activity {
    private static final int SPLASH_TIME = 1000;
    //set waktu 3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME);
    }
}
