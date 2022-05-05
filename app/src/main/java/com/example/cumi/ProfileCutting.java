package com.example.cumi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cumi.Helpers.DBHelper;
import com.example.cumi.Helpers.DatabaseCall;

public class ProfileCutting extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DBHelper DB;
    TextView ProfileCutting_Header;
    Button ProfileCutting_Save, ProfileCutting_Submit;
    EditText ProfileCutting_ItemCode, ProfileCutting_DrawingNo, ProfileCutting_WorkOrderNo, ProfileCutting_PartID, ProfileCutting_Asset, ProfileCutting_SubAsset, ProfileCutting_Operator, ProfileCutting_Status, ProfileCutting_StartTime, ProfileCutting_EndTime;
    Spinner ProfileCutting_AutoAsset, ProfileCutting_AutoSubAsset, ProfileCutting_ManualAsset, ProfileCutting_ManualSubAsset, ProfileCutting_DataEntryStatus;
    Integer ProfileCutting_AutoAssetPOS, ProfileCutting_AutoSubAssetPOS, ProfileCutting_ManualAssetPOS, ProfileCutting_ManualSubAssetPOS, ProfileCutting_DataEntryStatusPOS;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_cutting);

        ProfileCutting_Header = findViewById(R.id.ProfileCutting_Header);
        ProfileCutting_ItemCode = findViewById(R.id.ProfileCutting_ItemCode);
        ProfileCutting_DrawingNo = findViewById(R.id.ProfileCutting_DrawingNo);
        ProfileCutting_WorkOrderNo = findViewById(R.id.ProfileCutting_WorkOrderNo);
        ProfileCutting_PartID = findViewById(R.id.ProfileCutting_PartID);
        ProfileCutting_AutoAsset = findViewById(R.id.ProfileCutting_AutoAsset);
        ProfileCutting_AutoSubAsset = findViewById(R.id.ProfileCutting_AutoSubAsset);
        ProfileCutting_ManualAsset = findViewById(R.id.ProfileCutting_ManualAsset);
        ProfileCutting_ManualSubAsset = findViewById(R.id.ProfileCutting_ManualSubAsset);
        ProfileCutting_Asset = findViewById(R.id.ProfileCutting_Asset);
        ProfileCutting_SubAsset = findViewById(R.id.ProfileCutting_SubAsset);
        ProfileCutting_Operator = findViewById(R.id.ProfileCutting_Operator);
        ProfileCutting_Status = findViewById(R.id.ProfileCutting_Status);
        ProfileCutting_StartTime = findViewById(R.id.ProfileCutting_StartTime);
        ProfileCutting_EndTime = findViewById(R.id.ProfileCutting_EndTime);
        ProfileCutting_DataEntryStatus = findViewById(R.id.ProfileCutting_DataEntryStatus);
        ProfileCutting_Save = findViewById(R.id.ProfileCutting_Save);
        ProfileCutting_Submit = findViewById(R.id.ProfileCutting_Submit);


        DB = new DBHelper(this);

        String Parent = getIntent().getStringExtra("Parent");
        String processKey = getIntent().getStringExtra("processKey");
        ProfileCutting_Header.setText(processKey);

        //Get Local Data
        getPrevData();

        //Button
        ProfileCutting_Save.setOnClickListener(view -> {
            String ProfileCutting_HeaderTXT = ProfileCutting_Header.getText().toString();
            String ProfileCutting_ItemCodeTXT = ProfileCutting_ItemCode.getText().toString();
            String ProfileCutting_DrawingNoTXT = ProfileCutting_DrawingNo.getText().toString();
            String ProfileCutting_WorkOrderNoTXT = ProfileCutting_WorkOrderNo.getText().toString();
            String ProfileCutting_PartIDTXT = ProfileCutting_PartID.getText().toString();
            String ProfileCutting_AssetTXT = ProfileCutting_Asset.getText().toString();
            String ProfileCutting_SubAssetTXT = ProfileCutting_SubAsset.getText().toString();
            String ProfileCutting_OperatorTXT = ProfileCutting_Operator.getText().toString();
            String ProfileCutting_StatusTXT = ProfileCutting_Status.getText().toString();
            String ProfileCutting_StartTimeTXT = ProfileCutting_StartTime.getText().toString();
            String ProfileCutting_EndTimeTXT = ProfileCutting_EndTime.getText().toString();


            Boolean checkinsertdata = DB.saveData(ProfileCutting_HeaderTXT, ProfileCutting_ItemCodeTXT, ProfileCutting_DrawingNoTXT, ProfileCutting_WorkOrderNoTXT, ProfileCutting_PartIDTXT, ProfileCutting_AssetTXT, ProfileCutting_SubAssetTXT, ProfileCutting_OperatorTXT, ProfileCutting_StatusTXT, ProfileCutting_StartTimeTXT, ProfileCutting_EndTimeTXT, ProfileCutting_AutoAssetPOS, ProfileCutting_AutoSubAssetPOS, ProfileCutting_ManualAssetPOS, ProfileCutting_ManualSubAssetPOS, ProfileCutting_DataEntryStatusPOS);
            if (checkinsertdata == true)
                Toast.makeText(ProfileCutting.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(ProfileCutting.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

        });

        //Button
        ProfileCutting_Submit.setOnClickListener(view -> {

            if (i > 0) {
                Boolean result = DatabaseCall.getData().Submit("Insert into [CUMI].[dbo].[ProfileCutting2] values  ('" + Parent.toString() + "','" + ProfileCutting_Header.getText().toString() + "','" + ProfileCutting_ItemCode.getText().toString() + "','" + ProfileCutting_DrawingNo.getText().toString() + "','" + ProfileCutting_WorkOrderNo.getText().toString() + "','" + ProfileCutting_PartID.getText().toString() + "','" + ProfileCutting_AutoAsset.getSelectedItem().toString() + "','" + ProfileCutting_AutoSubAsset.getSelectedItem().toString() + "','" + ProfileCutting_ManualAsset.getSelectedItem().toString() + "','" + ProfileCutting_ManualSubAsset.getSelectedItem().toString() + "','" + ProfileCutting_Asset.getText().toString() + "','" + ProfileCutting_SubAsset.getText().toString() + "','" + ProfileCutting_Operator.getText().toString() + "','" + ProfileCutting_Status.getText().toString() + "','" + ProfileCutting_StartTime.getText().toString() + "','" + ProfileCutting_EndTime.getText().toString() + "','" + ProfileCutting_DataEntryStatus.getSelectedItem().toString() + "')");

                Toast.makeText(ProfileCutting.this, "Submitted " + result, Toast.LENGTH_SHORT).show();

                if (result) {
                    String ProfileCutting_HeaderTXT = ProfileCutting_Header.getText().toString();
                    Boolean checkudeletedata = DB.deletedata(ProfileCutting_HeaderTXT);
                    if (checkudeletedata == true)
                        Toast.makeText(ProfileCutting.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(ProfileCutting.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(ProfileCutting.this, Dashboard1.class);
                startActivity(i);

            } else {
                i++;
                Toast.makeText(ProfileCutting.this, "Sure to submit?", Toast.LENGTH_SHORT).show();
            }


        });

        Spinner ProfileCutting_AutoAssetPOSdropdown = findViewById(R.id.ProfileCutting_AutoAsset);
        String[] ProfileCutting_AutoAssetPOSitems = new String[]{"A", "B", "C", "D", "N", "G"};
        ArrayAdapter<String> ProfileCutting_AutoAssetPOSitemsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProfileCutting_AutoAssetPOSitems);
        ProfileCutting_AutoAssetPOSdropdown.setAdapter(ProfileCutting_AutoAssetPOSitemsadapter);
        ProfileCutting_AutoAssetPOSdropdown.setOnItemSelectedListener(this);

        Spinner ProfileCutting_AutoSubAssetPOSdropdown = findViewById(R.id.ProfileCutting_AutoSubAsset);
        String[] ProfileCutting_AutoSubAssetPOSitems = new String[]{"A", "B", "C", "D", "N", "G"};
        ArrayAdapter<String> ProfileCutting_AutoSubAssetPOSitemsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProfileCutting_AutoSubAssetPOSitems);
        ProfileCutting_AutoSubAssetPOSdropdown.setAdapter(ProfileCutting_AutoSubAssetPOSitemsadapter);
        ProfileCutting_AutoSubAssetPOSdropdown.setOnItemSelectedListener(this);

        Spinner ProfileCutting_ManualAssetPOSdropdown = findViewById(R.id.ProfileCutting_ManualAsset);
        String[] ProfileCutting_ManualAssetPOSitems = new String[]{"A", "B", "C", "D", "N", "G"};
        ArrayAdapter<String> ProfileCutting_ManualAssetPOSitemsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProfileCutting_ManualAssetPOSitems);
        ProfileCutting_ManualAssetPOSdropdown.setAdapter(ProfileCutting_ManualAssetPOSitemsadapter);
        ProfileCutting_ManualAssetPOSdropdown.setOnItemSelectedListener(this);

        Spinner ProfileCutting_ManualSubAssetPOSdropdown = findViewById(R.id.ProfileCutting_ManualSubAsset);
        String[] ProfileCutting_ManualSubAssetPOSitems = new String[]{"A", "B", "C", "D", "N", "G"};
        ArrayAdapter<String> ProfileCutting_ManualSubAssetPOSitemsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProfileCutting_ManualSubAssetPOSitems);
        ProfileCutting_ManualSubAssetPOSdropdown.setAdapter(ProfileCutting_ManualSubAssetPOSitemsadapter);
        ProfileCutting_ManualSubAssetPOSdropdown.setOnItemSelectedListener(this);

        Spinner ProfileCutting_DataEntryStatusPOSdropdown = findViewById(R.id.ProfileCutting_DataEntryStatus);
        String[] ProfileCutting_DataEntryStatusPOSitems = new String[]{"A", "B", "C", "D", "N", "G"};
        ArrayAdapter<String> ProfileCutting_DataEntryStatusPOSitemsadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ProfileCutting_DataEntryStatusPOSitems);
        ProfileCutting_DataEntryStatusPOSdropdown.setAdapter(ProfileCutting_DataEntryStatusPOSitemsadapter);
        ProfileCutting_DataEntryStatusPOSdropdown.setOnItemSelectedListener(this);

    }

    private void getPrevData() {
        String ProfileCutting_HeaderTXT = ProfileCutting_Header.getText().toString();
        if (ProfileCutting_HeaderTXT.equals("")) {
            return;
        }
        Cursor res = DB.getdata(ProfileCutting_HeaderTXT);
        if (res.getCount() == 0) {
            Toast.makeText(ProfileCutting.this, "New", Toast.LENGTH_SHORT).show();
            return;
        }
        while (res.moveToNext()) {
            ProfileCutting_ItemCode.setText(res.getString(1));
            ProfileCutting_DrawingNo.setText(res.getString(2));
            ProfileCutting_WorkOrderNo.setText(res.getString(3));
            ProfileCutting_PartID.setText(res.getString(4));
            ProfileCutting_Asset.setText(res.getString(5));
            ProfileCutting_SubAsset.setText(res.getString(6));
            ProfileCutting_Operator.setText(res.getString(7));
            ProfileCutting_Status.setText(res.getString(8));
            ProfileCutting_StartTime.setText(res.getString(9));
            ProfileCutting_EndTime.setText(res.getString(10));
            ProfileCutting_AutoAsset.setSelection(res.getInt(11), false);
            ProfileCutting_AutoSubAsset.setSelection(res.getInt(12));
            ProfileCutting_ManualAsset.setSelection(res.getInt(13));
            ProfileCutting_ManualSubAsset.setSelection(res.getInt(14));
            ProfileCutting_DataEntryStatus.setSelection(res.getInt(15));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (parent.getId() == R.id.ProfileCutting_AutoAsset) {
            this.ProfileCutting_AutoAssetPOS = pos;
        }
        if (parent.getId() == R.id.ProfileCutting_AutoSubAsset) {
            this.ProfileCutting_AutoSubAssetPOS = pos;
        }
        if (parent.getId() == R.id.ProfileCutting_ManualAsset) {
            this.ProfileCutting_ManualAssetPOS = pos;
        }
        if (parent.getId() == R.id.ProfileCutting_ManualSubAsset) {
            this.ProfileCutting_ManualSubAssetPOS = pos;
        }
        if (parent.getId() == R.id.ProfileCutting_DataEntryStatus) {
            this.ProfileCutting_DataEntryStatusPOS = pos;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Get Local Data
        getPrevData();
    }
}