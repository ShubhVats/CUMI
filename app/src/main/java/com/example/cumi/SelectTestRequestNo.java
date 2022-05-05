package com.example.cumi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectTestRequestNo extends AppCompatActivity {

    Button TestRequestNo_Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test_request_no);

        String Parent = getIntent().getStringExtra("Parent");

        TestRequestNo_Submit = findViewById(R.id.TestRequestNo_Submit);

        TestRequestNo_Submit.setOnClickListener(view -> {
            Intent i = new Intent();
            switch (Parent) {
                case "III_MaterialInspection":
                    i = new Intent(SelectTestRequestNo.this, III_MaterialInspection_1.class);
                    break;
                case "III_BarcodeGeneration":
                    i = new Intent(SelectTestRequestNo.this, III_BarcodeGeneration_1.class);
                    break;
                default:
                    Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                    return;
            }
            startActivity(i);
        });
    }
}
