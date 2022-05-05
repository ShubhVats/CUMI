package com.example.cumi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cumi.Helpers.DatabaseCall;

public class III_BarcodeGeneration_1 extends AppCompatActivity {

    EditText BarcodeGeneration_MaterialName, BarcodeGeneration_BarcodeData;
    Button BarcodeGeneration_Generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iii_barcode_generation1);

        BarcodeGeneration_MaterialName = findViewById(R.id.BarcodeGeneration_MaterialName);
        BarcodeGeneration_BarcodeData = findViewById(R.id.BarcodeGeneration_BarcodeData);
        BarcodeGeneration_Generate = findViewById(R.id.BarcodeGeneration_Generate);

        BarcodeGeneration_Generate.setOnClickListener(view -> {
            Boolean Res = DatabaseCall.getData().Submit("Insert into BarcodeGeneration values ('" + BarcodeGeneration_MaterialName.getText().toString() + "','" + BarcodeGeneration_BarcodeData.getText().toString() + "')");
            if (Res) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}