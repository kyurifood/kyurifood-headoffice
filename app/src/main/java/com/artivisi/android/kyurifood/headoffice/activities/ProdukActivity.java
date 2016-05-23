package com.artivisi.android.kyurifood.headoffice.activities;

import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.artivisi.android.kyurifood.headoffice.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandyfajar on 20/05/16.
 */
public class ProdukActivity extends AppCompatActivity {

    private static final int SELECT_PHOTO = 100;
    private static int RESULT_LOAD_IMAGE = 1;
    Button btnHargaRegional;
    Dialog addHargaRegional;
    ListView lvItem;
    ListView lvtem;

    private String kode;
    private String nama;
    private String hargaawal;
    private String img;

    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;
    private Spinner spinnerregional;


    private String picturePath = "";

    ImageView imgview;

    EditText txtkode, txtnama, txtharga,txthargaawal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tambahproduk);

        imgview = (ImageView) findViewById(R.id.foto);
        Spinner mSpinner= (Spinner)findViewById(R.id.spinnerregional);

        lvItem = (ListView) findViewById(R.id.lv_item);
        lvtem = (ListView) findViewById(R.id.lv_daftar);
        ViewGroup.LayoutParams listViewParams = (ViewGroup.LayoutParams) lvItem.getLayoutParams();
        listViewParams.height = 380;
        lvItem.requestLayout();

        lvItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });

        ImageView iv_user_photo = (ImageView) findViewById(R.id.foto);
        iv_user_photo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });


        btnHargaRegional = (Button) findViewById(R.id.btnHarga);
        btnHargaRegional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            android.net.Uri selectedImage = data.getData();
            String[] filePathColumn = { android.provider.MediaStore.Images.Media.DATA };

            android.database.Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.foto);
            imageView.setImageBitmap(android.graphics.BitmapFactory.decodeFile(picturePath));

        }


    }



    private void showAddDialog() {
        addHargaRegional = new Dialog(ProdukActivity.this);
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

    public class OnSpinnerItemClicked implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        }
        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_produk, menu);
        return true;
    }

}








