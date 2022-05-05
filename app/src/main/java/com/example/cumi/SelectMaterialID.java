package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectMaterialID extends AppCompatActivity {

    Button MaterialID_Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_material_id);

        MaterialID_Submit = findViewById(R.id.MaterialID_Submit);

        String Parent = getIntent().getStringExtra("Parent");
        MaterialID_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                switch (Parent) {
                    case "URM_MaterialReceipt":
                        i = new Intent(SelectMaterialID.this, URM_MaterialReceipt_1.class);

                        break;
                    case "URM_ReleaseForInspection":
                        i = new Intent(SelectMaterialID.this, URM_ReleaseforInspection_1.class);

                        break;
                    default:
                        i = new Intent(SelectMaterialID.this, URM_MaterialReturn_1.class);
                        break;
                }
                startActivity(i);

            }
        });
    }
}