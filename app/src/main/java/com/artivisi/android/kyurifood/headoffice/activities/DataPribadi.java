package com.artivisi.android.kyurifood.headoffice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.artivisi.android.kyurifood.headoffice.R;

/**
 * Created by sandyfajar on 30/05/16.
 */
public class DataPribadi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_datapribadi);

        getSupportActionBar().setTitle("Detail DataPribadi");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // getSupportActionBar().setLogo(R.drawable.bar_ic_placeholder);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
