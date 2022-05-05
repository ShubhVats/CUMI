package com.example.cumi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InwardInspectionInternal extends AppCompatActivity {

    Button III_MaterialInspection_Btn, III_BarcodeGeneration_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inward_inspection_internal);

        III_MaterialInspection_Btn = findViewById(R.id.III_MaterialInspection_Btn);
        III_BarcodeGeneration_Btn = findViewById(R.id.III_BarcodeGeneration_Btn);


        III_MaterialInspection_Btn.setOnClickListener(view -> {
            Intent i = new Intent(InwardInspectionInternal.this, SelectTestRequestNo.class);
            i.putExtra("Parent", "III_MaterialInspection");
            startActivity(i);
        });
        III_BarcodeGeneration_Btn.setOnClickListener(view -> {
            Intent i = new Intent(InwardInspectionInternal.this, SelectTestRequestNo.class);
            i.putExtra("Parent", "III_BarcodeGeneration");
            startActivity(i);
        });
    }
}