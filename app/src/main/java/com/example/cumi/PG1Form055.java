package com.example.cumi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PG1Form055 extends AppCompatActivity {

    //Declare Variables
    Button SubmitBtn;
    TextView ItemCode_Holder, WO_No_Holder, ID_Requirement_Holder_1, ID_Requirement_Holder_2, OD_Requirement_Holder_1, OD_Requirement_Holder_2, Length_Holder_1, Length_Holder_2, Width_Holder_1, Width_Holder_2, Weight_Holder_1, Weight_Holder_2, Remarks_1, Remarks_2, ID_Actual_1, ID_Actual_2, OD_Actual_1, OD_Actual_2, Ovality_1, Ovalit_2;

    Connection connect;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg1_form055);

        //Connect variables to Screens
        ItemCode_Holder = findViewById(R.id.PGForm055_ItemCode);
        WO_No_Holder = findViewById(R.id.PGForm055_WO_No);
        ID_Requirement_Holder_1 = findViewById(R.id.PGForm055_ID_Requirement_1);
        ID_Requirement_Holder_2 = findViewById(R.id.PGForm055_ID_Requirement_2);
        OD_Requirement_Holder_1 = findViewById(R.id.PGForm055_OD_Requirement_1);
        OD_Requirement_Holder_2 = findViewById(R.id.PGForm055_OD_Requirement_2);
        Length_Holder_1 = findViewById(R.id.PGForm055_Length_S1);
        Length_Holder_2 = findViewById(R.id.PGForm055_Length_S2);
        Width_Holder_1 = findViewById(R.id.PGForm055_Width_S1);
        Width_Holder_2 = findViewById(R.id.PGForm055_Width_S2);
        Weight_Holder_1 = findViewById(R.id.PGForm055_Weight_1);
        Weight_Holder_2 = findViewById(R.id.PGForm055_Weight_2);
        Remarks_1 = findViewById(R.id.PGForm055_Remarks_1);
        Remarks_2 = findViewById(R.id.PGForm055_Remarks_2);
        ID_Actual_1 = findViewById(R.id.PGForm055_ID_Actual_1);
        ID_Actual_2 = findViewById(R.id.PGForm055_ID_Actual_2);
        OD_Actual_1 = findViewById(R.id.PGForm055_OD_Actual_1);
        OD_Actual_2 = findViewById(R.id.PGForm055_OD_Actual_2);
        Ovality_1 = findViewById(R.id.PGForm055_Ovality_1);
        Ovalit_2 = findViewById(R.id.PGForm055_Ovality_2);
        SubmitBtn = findViewById(R.id.PGForm055_SubmitBtn);

        //Fetch data from database
        String ItemCode_Value = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 5);
        String WO_No_Value = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 6);
        String ID_Requirement_Value_1 = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 1);
        String ID_Requirement_Value_2 = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 7);
        String OD_Requirement_Value_1 = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 2);
        String OD_Requirement_Value_2 = DatabaseCall.getData().FetchData("EXEC OrderToProcessMappingSP", 11);

        //Set Values
        ItemCode_Holder.setText(ItemCode_Value);
        WO_No_Holder.setText(WO_No_Value);
        WO_No_Holder.setText(WO_No_Value);
        ID_Requirement_Holder_1.setText(ID_Requirement_Value_1);
        ID_Requirement_Holder_2.setText(ID_Requirement_Value_2);
        OD_Requirement_Holder_1.setText(OD_Requirement_Value_1);
        OD_Requirement_Holder_2.setText(OD_Requirement_Value_2);

        //SUBMIT TO DATABASE
        SubmitBtn.setOnClickListener(view ->
                DatabaseCall.getData().Submit("Insert into [CUMI].[dbo].[Production_Form_QA_037] values  ('RowIdTODO','TimeStampTODO','"+WO_No_Holder.getText().toString()+"','" + ItemCode_Holder.getText().toString() + "','" + Length_Holder_1.getText().toString() + "','" + Width_Holder_1.getText().toString() + "','"+ID_Requirement_Holder_1.getText().toString()+"','"+ID_Actual_1.getText().toString()+"','"+OD_Requirement_Holder_1.getText().toString()+"','"+OD_Actual_1.getText().toString()+"','"+Ovality_1.getText().toString()+"','"+Weight_Holder_1.getText().toString()+"','StatusTODO','StartTimeTODO','EndTimeTODO','"+Remarks_1.getText().toString()+"')"));
    }
}