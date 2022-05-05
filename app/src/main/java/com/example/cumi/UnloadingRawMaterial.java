package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnloadingRawMaterial extends AppCompatActivity {

    Button URM_MaterialReceipt_Btn, URM_ReleaseForInspection_Btn, URM_MaterialReturn_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unloading_raw_material);
        URM_MaterialReceipt_Btn = findViewById(R.id.URM_MaterialReceipt_Btn);
        URM_ReleaseForInspection_Btn = findViewById(R.id.URM_ReleaseForInspection_Btn);
        URM_MaterialReturn_Btn = findViewById(R.id.URM_MaterialReturn_Btn);


        URM_MaterialReceipt_Btn.setOnClickListener(view -> {
            Intent i = new Intent(UnloadingRawMaterial.this, SelectMaterialID.class);
            i.putExtra("Parent", "URM_MaterialReceipt");
            startActivity(i);
        });

        URM_ReleaseForInspection_Btn.setOnClickListener(view -> {
            Intent i = new Intent(UnloadingRawMaterial.this, SelectMaterialID.class);
            i.putExtra("Parent", "URM_ReleaseForInspection");
            startActivity(i);
        });

        URM_MaterialReturn_Btn.setOnClickListener(view -> {
            Intent i = new Intent(UnloadingRawMaterial.this, SelectMaterialID.class);
            i.putExtra("Parent", "URM_MaterialReturn");
            startActivity(i);
        });
    }
}