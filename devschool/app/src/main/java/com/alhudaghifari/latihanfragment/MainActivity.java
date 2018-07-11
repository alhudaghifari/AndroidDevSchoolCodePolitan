package com.alhudaghifari.latihanfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new
                PertamaFragment()).commit();
    }

    public void tampilFragmentPertama(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, new
                PertamaFragment()).commit();
    }

    public void tampilFragmentKedua(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, new
                KeduaFragment()).commit();
    }

    public void tampilFragmentKetiga(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, new
                KetigaFragment()).commit();
    }
}
