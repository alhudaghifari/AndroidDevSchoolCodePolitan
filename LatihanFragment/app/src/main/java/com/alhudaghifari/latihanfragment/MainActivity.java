package com.alhudaghifari.latihanfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentHome()).commit();
    }

    public void gotoFragmentHome(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentHome()).commit();
    }

    public void gotoFragmentGalleri(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentGalleri()).commit();
    }

    public void gotoFragmentProfil(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentProfil()).commit();
    }
}
