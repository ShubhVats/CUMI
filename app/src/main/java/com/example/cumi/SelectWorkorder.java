package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        String processKey = getIntent().getStringExtra("processKey");

        //Spinner
        Integer[] arr = {1, 2, 3, 4, 5};
        WorkOrderSpinner.setAdapter(new ArrayAdapter<>(SelectWorkorder.this, android.R.layout.simple_spinner_dropdown_item, arr));

        //Scanning
        ScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectWorkorder.this, barcodeScanning.class);
                startActivity(i);
            }
        });

        //Get Intent(Barcode Value)
        String barcodeVal = getIntent().getStringExtra("BarcodeValue");
        BarcodeValue.setText(barcodeVal);

        //Navigation
        NavBtn.setOnClickListener(view -> {
            if (processKey.equals("P07	Flange-Edge Preparation")) {
                Intent i = new Intent(SelectWorkorder.this, QAForm037.class);
                startActivity(i);
            }
        });
    }
}