package com.example.cumi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cumi.Helpers.DatabaseCall;

public class URM_MaterialReturn_1 extends AppCompatActivity {


    EditText MaterialReturn_MaterialID, MaterialReturn_MaterialName, MaterialReturn_MaterialMake, MaterialReturn_BatchLotNo, MaterialReturn_TotalQty, MaterialReturn_ExpiryDate, MaterialReturn_ReceivedDate, MaterialReturn_Reason;
    Button MaterialReturn_Scan, MaterialReturn_Gallery, MaterialReturn_Submit;
    ImageView MaterialReturn_IMG;

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;

    String currentPhotoPath;
    String ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urm_material_return1);

        MaterialReturn_MaterialID = findViewById(R.id.MaterialReturn_MaterialID);
        MaterialReturn_MaterialName = findViewById(R.id.MaterialReturn_MaterialName);
        MaterialReturn_MaterialMake = findViewById(R.id.MaterialReturn_MaterialMake);
        MaterialReturn_BatchLotNo = findViewById(R.id.MaterialReturn_BatchLotNo);
        MaterialReturn_TotalQty = findViewById(R.id.MaterialReturn_TotalQty);
        MaterialReturn_ExpiryDate = findViewById(R.id.MaterialReturn_ExpiryDate);
        MaterialReturn_ReceivedDate = findViewById(R.id.MaterialReturn_ReceivedDate);
        MaterialReturn_Reason = findViewById(R.id.MaterialReturn_Reason);
        MaterialReturn_Submit = findViewById(R.id.MaterialReturn_Submit);

        MaterialReturn_Submit.setOnClickListener(view -> {
            Boolean Res = DatabaseCall.getData().Submit("Insert into MaterialReturn values ('" + MaterialReturn_MaterialID.getText().toString() + "','" + MaterialReturn_MaterialName.getText().toString() + "','" + MaterialReturn_MaterialMake.getText().toString() + "','" + MaterialReturn_BatchLotNo.getText().toString() + "','" + MaterialReturn_TotalQty.getText().toString() + "','" + MaterialReturn_ExpiryDate.getText().toString() + "','" + MaterialReturn_ReceivedDate.getText().toString() + "','" + MaterialReturn_Reason.getText().toString() + "')");
            if (Res) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}