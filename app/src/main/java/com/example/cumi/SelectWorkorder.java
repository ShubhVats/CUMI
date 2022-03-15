package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectWorkorder extends AppCompatActivity {

    Spinner WorkOrderSpinner;
    Button NavBtn, ScanBtn;
    TextView BarcodeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workorder);

        NavBtn = findViewById(R.id.workOrder_btn);
        ScanBtn = findViewById(R.id.workOrder_scan_btn);
        WorkOrderSpinner = findViewById(R.id.workOrder_spinner);
        BarcodeValue = findViewById(R.id.workOrder_barcodeValue_txt);

        //Get Intent
        String processKeyMaster = getIntent().getStringExtra("processKey");

        //Spinner
        Integer[] arr = {1, 2, 3, 4, 5};
        WorkOrderSpinner.setAdapter(new ArrayAdapter<>(SelectWorkorder.this, android.R.layout.simple_spinner_dropdown_item, arr));

        //Get Intent(Barcode Value)
        String barcodeVal = getIntent().getStringExtra("BarcodeValue");
        BarcodeValue.setText(barcodeVal);

        //Scanning
        ScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectWorkorder.this, barcodeScanning.class);
                i.putExtra("processKey",processKeyMaster);
                startActivity(i);
            }
        });

        String processKey = getIntent().getStringExtra("processKey");

        //Navigation
        try {
            NavBtn.setOnClickListener(view -> {
                if (processKey.equals("P04	Casing-Edge Preparation")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm037.class);
                    i.putExtra("barcodeVal", barcodeVal);
                    startActivity(i);
                }
                if (processKey.equals("P05	Casing-Rolling")) {
                    Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                    startActivity(i);
                }
                if (processKey.equals("P06	Casing-L Seam welding")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                    startActivity(i);
                }
                if (processKey.equals("P07	Flange-Edge Preparation")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm037.class);
                    startActivity(i);
                }
                if (processKey.equals("P08	Flange-Welding")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                    startActivity(i);
                }
                if (processKey.equals("P12	Fit-Up")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm037.class);
                    startActivity(i);
                }
                if (processKey.equals("P15	NDT")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm020.class);
                    startActivity(i);
                }
                if (processKey.equals("P16	Leak Test")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm034.class);
                    startActivity(i);
                }
                if (processKey.equals("P20	Bonding material mixing")) {
                    Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                    startActivity(i);
                }
                if (processKey.equals("P25	Paint mixing data")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P26	Painting")) {
                    //THIS PROCESS WILL HAVE TWO RESULTING SCREENS
                    //MAKE NEW SCREEN ADDING THESE SCREENS
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P27	type-1 Base coating")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("AP01	Owen drying")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P28	inspection")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("AP02	Intermediate coating")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("AP03	Owen drying")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("AP04	inspection")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P29	Final paint coating")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("AP05	Owen drying")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P30	Inspection")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("AP06	Assembly inspection")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P32	Customer inspection")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P33	Final inspection clearances by customer")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
                if (processKey.equals("P34	Pack and dispatch")) {
                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                    startActivity(i);
                }
            });
        } catch (Exception e) {
            Log.e("Here", e.toString());
        }
        ;
    }
}