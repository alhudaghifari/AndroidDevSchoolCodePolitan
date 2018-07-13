package com.alhudaghifari.belajardatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AddEditActivity extends AppCompatActivity {

    TextView textViewName, textViewPriority;
    MyDatabase database;

    boolean edit = false;

    Item itemIntent;

    int id;
    String nameIntent;
    int priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tambah Database");
        setSupportActionBar(toolbar);

        textViewName = findViewById(R.id.enter_name);
        textViewPriority = findViewById(R.id.enter_priority);

        if (getIntent().getStringExtra("name") != null) {
            id = getIntent().getIntExtra("id", 0);
            nameIntent = getIntent().getStringExtra("name");
            priority = getIntent().getIntExtra("priority", 0);

            textViewName.setText(nameIntent);
            textViewPriority.setText(priority + "");

            edit = true;
        }

        database = new MyDatabase(AddEditActivity.this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = textViewName.getText().toString();
                int prio = Integer.parseInt(textViewPriority.getText().toString());

                if (edit) {
                    Log.d("AddEditActivity", "edit : true" +
                                "nameIntent : " + nameIntent);
                    Item item = new Item(id, name, prio);
                    database.updateItem(item);
                } else {
                    Log.d("AddEditActivity", "edit : false");
                    Item item = new Item(name, prio);
                    database.addItem(item);
                }


                Intent intent = new Intent(AddEditActivity.this
                        , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
