package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectProcess extends AppCompatActivity {

    Spinner processIDSpinner;
    Button NavBtn;
    String processKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_process);


        Intent i = getIntent();
        String Parent = i.getStringExtra("Parent");

        NavBtn = findViewById(R.id.processID_btn);
        processIDSpinner = findViewById(R.id.processID_spinner);

        //Spinner
        String[] arr = {
                "P01	Unloading Raw material"
                , "P02	Inward inspection - Internal"
                , "EP01	External lab testing"
                , "EP02	Raw material Customer inspection"
                , "P03	Profile cutting"
                , "P04	Casing-Edge Preparation"
                , "P05	Casing-Rolling"
                , "P06	Casing-L Seam welding"
                , "P07	Flange-Edge Preparation"
                , "P08	Flange-Welding"
                , "P08	Flange-Welding"
                , "P09	Flange-NDT"
                , "P10	Machining"
                , "P10	Machining"
                , "P10	Machining"
                , "P10	Machining"
                , "P11	Flange-Dimension check"
                , "P12	Fit-Up"
                , "P13	Final welding"
                , "P13	Final welding"
                , "P14	Final Dimesion Check (Steel Part)"
                , "P14	Final Dimesion Check (Steel Part)"
                , "P15	NDT"
                , "EP03	Customer inspection"
                , "P16	Leak Test"
                , "EP04	Customer inspection"
                , "P17	Blasting"
                , "P18	Primary coat Lining surface"
                , "P19	Visual test"
                , "P20	Bonding material mixing"
                , "P21	Lining Process"
                , "P21	Lining Process"
                , "P21	Lining Process"
                , "P22	Lining Process"
                , "P22	Flush grinding"
                , "P23	Line visual + Dimensional inspection"
                , "P24	Blasting - OD"
                , "P25	Paint mixing data"
                , "P26	Painting"
                , "P27	type-1 Base coating"
                , "AP01	Owen drying"
                , "P28	inspection"
                , "AP02	Intermediate coating"
                , "AP03	Owen drying"
                , "AP04	inspection"
                , "P29	Final paint coating"
                , "AP05	Owen drying"
                , "P30	Inspection"
                , "AP06	Assembly inspection"
                , "P32	Customer inspection"
                , "P33	Final inspection clearances by customer"
                , "P34	Pack and dispatch"};
        //Spinner
        String[] arr3 = {
                "Unloading Raw material",
                "Inward inspection - Internal",
                "External lab testing",
                "Raw material Cust inspect"};

        //Spinner
        String[] arr2 = {
                "P01	Unloading Raw material"
                , "P02	Inward inspection - Internal"
                , "EP01	External lab testing"
                , "EP02	Raw material Customer inspection"
                , "P03	Profile cutting"
                , "P04	Casing-Edge Preparation"
                , "P05	Casing-Rolling"
                , "P06	Casing-L Seam welding"
                , "P07	Flange-Edge Preparation"
                , "P08	Flange-Welding"
                , "P09	Flange-NDT"
                , "P10	Machining"
                , "P11	Flange-Dimension check"
                , "P12	Fit-Up"
                , "P13	Final welding"
                , "P14	Final Dimesion Check (Steel Part)"
                , "P15	NDT"
                , "EP03	Customer inspection"
                , "P16	Leak Test"
                , "EP04	Customer inspection"
                , "P17	Blasting"
                , "P18	Primary coat Lining surface"
                , "P19	Visual test"
                , "P20	Bonding material mixing"
                , "P21	Lining Process"
                , "P22	Lining Process"
                , "P23	Line visual + Dimensional inspection"
                , "P24	Blasting - OD"
                , "P25	Paint mixing data"
                , "P26	Painting"
                , "P27	type-1 Base coating"
                , "AP01	Owen drying"
                , "P28	inspection"
                , "AP02	Intermediate coating"
                , "AP03	Owen drying"
                , "AP04	inspection"
                , "P29	Final paint coating"
                , "AP05	Owen drying"
                , "P30	Inspection"
                , "AP06	Assembly inspection"
                , "P32	Customer inspection"
                , "P33	Final inspection clearances by customer"
                , "P34	Pack and dispatch"};

        Log.e("Here", Parent);
        switch (Parent) {
            case "Production":
                processIDSpinner.setAdapter(new ArrayAdapter<>(SelectProcess.this, android.R.layout.simple_spinner_dropdown_item, arr));

                //
                NavBtn.setOnClickListener(view -> {
                    Intent intent = new Intent(SelectProcess.this, SelectWorkorder.class);
                    intent.putExtra("processKey", processKey);
                    startActivity(intent);
                });
                break;
            case "Quality":
                processIDSpinner.setAdapter(new ArrayAdapter<>(SelectProcess.this, android.R.layout.simple_spinner_dropdown_item, arr2));

                //
                NavBtn.setOnClickListener(view -> {
                    Intent intent = new Intent(SelectProcess.this, SelectWorkorder.class);
                    intent.putExtra("processKey", processKey);
                    startActivity(intent);
                });
                break;
            case "Material_Store":
                processIDSpinner.setAdapter(new ArrayAdapter<>(SelectProcess.this, android.R.layout.simple_spinner_dropdown_item, arr3));

                //
                NavBtn.setOnClickListener(view -> {
                    Intent intent = new Intent(SelectProcess.this, UnloadingRawMaterial.class);
                    intent.putExtra("processKey", processKey);
                    startActivity(intent);
                });
                break;
        }

        processIDSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                processKey = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), processKey, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}