package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PG1Form055 extends AppCompatActivity {

    //Variables
    TextView ItemCode_Holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg1_form055);

        ItemCode_Holder = findViewById(R.id.PGForm055_ItemCode);
        String val = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 5);
        ItemCode_Holder.setText(val);


    }
}