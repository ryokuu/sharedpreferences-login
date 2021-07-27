package com.nooryoku.uasmoopkasus1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView judul, engine, gear;
    RodaEmpat rodaEmpat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        rodaEmpat = new RodaEmpat();

        judul = findViewById(R.id.judul);
        engine = findViewById(R.id.tv_engine);
        gear = findViewById(R.id.tv_gear);

        Intent i = getIntent();
        String judul1 = i.getStringExtra("judul");
        String engine1 = i.getStringExtra("engine");
        String gear1 = i.getStringExtra("gear");

        judul.setText(judul1);
        engine.setText(engine1);
        gear.setText(gear1);
    }
}