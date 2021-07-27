package com.nooryoku.uasmoopkasus1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView username;
    Spinner kendaraan, jenis;
    Button lihat;
    RodaEmpat rodaEmpat;
    RodaDua rodaDua;

    //array spinner pertama
    ArrayList<String> arrayListKendaraan;
    ArrayAdapter<String> arrayAdapterKendaraan;

    //array spinner kedua
    ArrayList<String> arrayListRoda2, arrayListRoda4;
    ArrayAdapter<String> arrayAdapterJenis;

    String jenis_mobil, jenis_motor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_username);
        lihat = findViewById(R.id.lihat);

        //spinner
        kendaraan = findViewById(R.id.spinner);
        jenis = findViewById(R.id.spinner2);

        username.setText(Preferences.getRegisteredUser(getBaseContext()));

        //======= spinner kendaraan ==========//
        arrayListKendaraan = new ArrayList<>();
        arrayListKendaraan.add("Roda Dua");
        arrayListKendaraan.add("Roda Empat");

        arrayAdapterKendaraan = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayListKendaraan);

        kendaraan.setAdapter(arrayAdapterKendaraan);

        //======= spinner jenis ==========//
        arrayListRoda2 = new ArrayList<>();
        arrayListRoda2.add("Sport Bike");
        arrayListRoda2.add("Moped");

        arrayListRoda4 = new ArrayList<>();
        arrayListRoda4.add("SUV");
        arrayListRoda4.add("Sedan");



        kendaraan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    arrayAdapterJenis = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, arrayListRoda2);

                }

                if(position==1){
                    arrayAdapterJenis = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, arrayListRoda4);
                }
                jenis.setAdapter(arrayAdapterJenis);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lihat.setOnClickListener(v -> {
            Intent i = new Intent(this, DetailActivity.class);
            rodaEmpat = new RodaEmpat();
            rodaDua = new RodaDua();
            if (kendaraan.getSelectedItemPosition()==0){
                if (jenis.getSelectedItemPosition()==0){
                    rodaDua.setJenis("Sport Bike");
                    i.putExtra("judul",rodaDua.getJenis());
                    i.putExtra("engine",rodaDua.getEngine());
                    i.putExtra("gear", rodaDua.getGear());
                }
                else {
                    rodaDua.setJenis("Moped");
                    i.putExtra("judul",rodaDua.getJenis());
                    i.putExtra("engine",rodaDua.getEngine());
                    i.putExtra("gear", rodaDua.getGear());
                }
            }

            else{
                if (jenis.getSelectedItemPosition()==0){
                    //jenis_mobil= "SUV";
                    rodaEmpat.setJenis("SUV");
                    i.putExtra("judul", rodaEmpat.getJenis());
                    i.putExtra("engine", rodaEmpat.getEngine());
                    i.putExtra("gear", rodaEmpat.getGear());
                }
                else{
                    //jenis_mobil= "Sedan";
                    rodaEmpat.setJenis("Sedan");
                    i.putExtra("judul", rodaEmpat.getJenis());
                    i.putExtra("engine", rodaEmpat.getEngine());
                    i.putExtra("gear", rodaEmpat.getGear());
                }
            }

            startActivity(i);
        });
    }
}