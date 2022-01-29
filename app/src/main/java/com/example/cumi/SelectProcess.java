package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectProcess extends AppCompatActivity {

    Spinner processIDSpinner;
    Button NavBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_process);


        NavBtn = findViewById(R.id.processID_btn);
        processIDSpinner = findViewById(R.id.processID_spinner);

        //Spinner
        Integer[] arr = {1,2,3,4,5};
        processIDSpinner.setAdapter(new ArrayAdapter<>(SelectProcess.this, android.R.layout.simple_spinner_dropdown_item, arr));

        //
        NavBtn.setOnClickListener(view -> {
            Intent i = new Intent(SelectProcess.this,SelectWorkorder.class);
            startActivity(i);
        });
    }
}