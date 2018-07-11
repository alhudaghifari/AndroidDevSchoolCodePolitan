package com.alhudaghifari.latihanfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilKontakTeman extends AppCompatActivity {

    TextView tvTeman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_kontak_teman);

        tvTeman = findViewById(R.id.tvTeman);

        String nama = getIntent().getStringExtra("namateman");

        tvTeman.setText(nama);
    }
}
