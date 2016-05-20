package com.artivisi.android.kyurifood.headoffice.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.artivisi.android.kyurifood.headoffice.R;

/**
 * Created by sandyfajar on 20/05/16.
 */
public class HargaRegional extends AppCompatActivity {

    Button btnHargaRegional;
    Dialog addHargaRegional;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        btnHargaRegional = (Button) findViewById(R.id.btnHarga);
        btnHargaRegional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }

        });
    }

    private void showAddDialog() {
        addHargaRegional = new Dialog(HargaRegional.this);
        addHargaRegional.setContentView(R.layout.harga_regional);
        addHargaRegional.setTitle("Harga Regional");
        addHargaRegional.setCancelable(false);
        addHargaRegional.show();

        //memanggil button but yang ada pada dialog
        Button but = (Button) addHargaRegional.findViewById(R.id.kembali);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHargaRegional.dismiss(); //keluar dialog
            }
        });
    }
}
