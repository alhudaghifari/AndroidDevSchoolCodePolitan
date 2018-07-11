
package com.alhudaghifari.kalkulatorsederhana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HalamanDua extends AppCompatActivity {

    TextView tvInfo;
    TextView tvAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_dua);

        tvInfo = findViewById(R.id.tvInfo);
        tvAngka = findViewById(R.id.tvAngka);

        String hasilDariMainActivity;
        int hasilAngkaDariMainActivity;

        hasilAngkaDariMainActivity = getIntent()
                .getIntExtra("cobain", -99);
        hasilDariMainActivity = getIntent()
                .getStringExtra("HASILHITUNGAN");

        Log.d("HalamanDua", "hasil : " + hasilDariMainActivity);
        tvInfo.setText(hasilDariMainActivity);
        tvAngka.setText(hasilAngkaDariMainActivity + "");
    }
}
