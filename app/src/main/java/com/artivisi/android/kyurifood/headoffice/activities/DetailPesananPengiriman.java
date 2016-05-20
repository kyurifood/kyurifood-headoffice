package com.artivisi.android.kyurifood.headoffice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.artivisi.android.kyurifood.headoffice.R;

/**
 * Created by dotachin on 20/05/16.
 */
public class DetailPesananPengiriman extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pesanan_pengiriman);

        TabHost host = (TabHost)findViewById(R.id.tab_host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Detail Pesanan");
        spec.setContent(R.id.tab_one_container);
        spec.setIndicator("Detail Pesanan");
        host.addTab(spec);

        spec = host.newTabSpec("Detail Pengiriman");
        spec.setContent(R.id.tab_two_container);
        spec.setIndicator("Detail Pengiriman");
        host.addTab(spec);
    }

}

