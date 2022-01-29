package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectWorkorder extends AppCompatActivity {

    Spinner WorkOrderSpinner;
    Button NavBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workorder);

        NavBtn = findViewById(R.id.workOrder_btn);
        WorkOrderSpinner = findViewById(R.id.workOrder_spinner);

        //Spinner
        Integer[] arr = {1,2,3,4,5};
        WorkOrderSpinner.setAdapter(new ArrayAdapter<>(SelectWorkorder.this, android.R.layout.simple_spinner_dropdown_item, arr));

        //
        NavBtn.setOnClickListener(view -> {
            Intent i = new Intent(SelectWorkorder.this,QualityDataEntry.class);
            startActivity(i);
        });
    }
}