package com.alhudaghifari.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etLinkWebsite;
    EditText etAlamat;
    EditText etTextBebas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLinkWebsite = findViewById(R.id.etLink);
        etAlamat = findViewById(R.id.etAlamat);
        etTextBebas = findViewById(R.id.etTextBebas);
    }

    //  http://google.com
    public void openBrowser(View view) {
        String link = etLinkWebsite.getText().toString().trim();

        Uri webpage = Uri.parse(link);
        Intent intentBukaBrowser = new Intent(Intent.ACTION_VIEW, webpage);

        // untuk menemukan activity to menghandle intent dan memulai aktivitas
        if (intentBukaBrowser.resolveActivity(getPackageManager()) != null) {
            startActivity(intentBukaBrowser);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
            Toast.makeText(MainActivity.this, "gagal membuka browser",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void openMaps(View view) {
        String location = etAlamat.getText().toString().trim();

        Uri alamatUri = Uri.parse("geo:0,0?q=" + location);
        Intent intentBukaMaps = new Intent(Intent.ACTION_VIEW, alamatUri);

        // untuk menemukan activity to menghandle intent dan memulai aktivitas
        if (intentBukaMaps.resolveActivity(getPackageManager()) != null) {
            startActivity(intentBukaMaps);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
            Toast.makeText(MainActivity.this, "gagal membuka maps",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void shareText(View view) {
        String txt = etTextBebas.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
}
