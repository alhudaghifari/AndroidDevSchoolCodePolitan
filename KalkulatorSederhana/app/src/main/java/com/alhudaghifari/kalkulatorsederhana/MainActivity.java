package com.alhudaghifari.kalkulatorsederhana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etAngka1;
    EditText etAngka2;
    TextView tvHasilku;

    String hasilHitungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka1 = findViewById(R.id.etAngka1);
        etAngka2 = findViewById(R.id.etAngka2);
        tvHasilku = findViewById(R.id.tvHasil);
    }

    public void tambah(View view) {
        String inputPertama = etAngka1.getText().toString();
        String inputKedua = etAngka2.getText().toString();

        if (inputPertama.isEmpty() || inputKedua.isEmpty()) {
            Toast.makeText(MainActivity.this, "mohon isi angka",
                    Toast.LENGTH_SHORT).show();
        } else {
            // kode hitung
            double input1 = Double.valueOf(inputPertama);
            double input2 = Double.valueOf(inputKedua);
            double hasil = input1 + input2;

            hasilHitungan = hasil + "";
            tvHasilku.setText(hasil + "");
        }

    }

    public void kurang(View view) {
        String inputPertama = etAngka1.getText().toString();
        String inputKedua = etAngka2.getText().toString();

        if (inputPertama.isEmpty() || inputKedua.isEmpty()) {
            Toast.makeText(MainActivity.this, "mohon isi angka",
                    Toast.LENGTH_SHORT).show();
        } else {
            // kode hitung
            double input1 = Double.valueOf(inputPertama);
            double input2 = Double.valueOf(inputKedua);
            double hasil = input1 - input2;

            hasilHitungan = hasil + "";
            tvHasilku.setText(hasil + "");
        }
    }

    public void bagi(View view) {
        String inputPertama = etAngka1.getText().toString();
        String inputKedua = etAngka2.getText().toString();

        if (inputPertama.isEmpty() || inputKedua.isEmpty()) {
            Toast.makeText(MainActivity.this, "mohon isi angka",
                    Toast.LENGTH_SHORT).show();
        } else {
            // kode hitung
            double input1 = Double.valueOf(inputPertama);
            double input2 = Double.valueOf(inputKedua);
            double hasil = input1 / input2;

            hasilHitungan = hasil + "";
            tvHasilku.setText(hasil + "");
        }
    }

    public void kali(View view) {
        String inputPertama = etAngka1.getText().toString();
        String inputKedua = etAngka2.getText().toString();

        if (inputPertama.isEmpty() || inputKedua.isEmpty()) {
            Toast.makeText(MainActivity.this, "mohon isi angka",
                    Toast.LENGTH_SHORT).show();
        } else {
            // kode hitung
            double input1 = Double.valueOf(inputPertama);
            double input2 = Double.valueOf(inputKedua);
            double hasil = input1 * input2;

            hasilHitungan = hasil + "";
            tvHasilku.setText(hasil + "");
        }
    }

    public void gotoHalamanDua(View view) {
        Intent intent = new Intent(MainActivity.this, HalamanDua.class);
        intent.putExtra("HASILHITUNGAN", hasilHitungan);
        intent.putExtra("cobain", 25);
        startActivity(intent);
    }
}
