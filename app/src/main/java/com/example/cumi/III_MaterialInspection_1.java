package com.example.cumi;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.example.cumi.Helpers.DatabaseCall;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class III_MaterialInspection_1 extends AppCompatActivity {

    EditText MaterialInspection_TestRequestNo, MaterialInspection_MaterialType, MaterialInspection_MaterialID, MaterialInspection_MaterialMake, MaterialInspection_BatchLotNo, MaterialInspection_Grade, MaterialInspection_CastNo, MaterialInspection_Size, MaterialInspection_TotalQuantity, MaterialInspection_InspectedQuantity, MaterialInspection_Comment;
    CheckBox MaterialInspection_MechanicalProperties, MaterialInspection_ChemicalProperties, MaterialInspection_UltrasonicTest, MaterialInspection_Hardness, MaterialInspection_Visual, MaterialInspection_Dimensions;
    Button MaterialInspection_Scan, MaterialInspection_Gallery, MaterialInspection_Reject, MaterialInspection_Accept;
    ImageView MaterialInspection_IMG;

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;

    String currentPhotoPath;
    String ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iii_material_inspection1);

        MaterialInspection_TestRequestNo = findViewById(R.id.MaterialInspection_TestRequestNo);
        MaterialInspection_MaterialType = findViewById(R.id.MaterialInspection_MaterialType);
        MaterialInspection_MaterialID = findViewById(R.id.MaterialInspection_MaterialID);
        MaterialInspection_MaterialMake = findViewById(R.id.MaterialInspection_MaterialMake);
        MaterialInspection_BatchLotNo = findViewById(R.id.MaterialInspection_BatchLotNo);
        MaterialInspection_Grade = findViewById(R.id.MaterialInspection_Grade);
        MaterialInspection_CastNo = findViewById(R.id.MaterialInspection_CastNo);
        MaterialInspection_Size = findViewById(R.id.MaterialInspection_Size);
        MaterialInspection_TotalQuantity = findViewById(R.id.MaterialInspection_TotalQuantity);
        MaterialInspection_InspectedQuantity = findViewById(R.id.MaterialInspection_InspectedQuantity);
        MaterialInspection_Comment = findViewById(R.id.MaterialInspection_Comment);
        MaterialInspection_MechanicalProperties = findViewById(R.id.MaterialInspection_MechanicalProperties);
        MaterialInspection_ChemicalProperties = findViewById(R.id.MaterialInspection_ChemicalProperties);
        MaterialInspection_UltrasonicTest = findViewById(R.id.MaterialInspection_UltrasonicTest);
        MaterialInspection_Hardness = findViewById(R.id.MaterialInspection_Hardness);
        MaterialInspection_Visual = findViewById(R.id.MaterialInspection_Visual);
        MaterialInspection_Dimensions = findViewById(R.id.MaterialInspection_Dimensions);
        MaterialInspection_IMG = findViewById(R.id.MaterialInspection_IMG);
        MaterialInspection_Scan = findViewById(R.id.MaterialInspection_Scan);
        MaterialInspection_Gallery = findViewById(R.id.MaterialInspection_Gallery);
        MaterialInspection_Reject = findViewById(R.id.MaterialInspection_Reject);
        MaterialInspection_Accept = findViewById(R.id.MaterialInspection_Accept);


        MaterialInspection_Accept.setOnClickListener(view -> {
            Boolean Res = DatabaseCall.getData().Submit("Insert into MaterialInspection values ('" + MaterialInspection_TestRequestNo.getText().toString() + "','" + MaterialInspection_MaterialType.getText().toString() + "','" + MaterialInspection_MaterialID.getText().toString() + "','" + MaterialInspection_MaterialMake.getText().toString() + "','" + MaterialInspection_BatchLotNo.getText().toString() + "','" + MaterialInspection_Grade.getText().toString() + "','" + MaterialInspection_CastNo.getText().toString() + "','" + MaterialInspection_Size.getText().toString() + "','" + MaterialInspection_TotalQuantity.getText().toString() + "','" + MaterialInspection_InspectedQuantity.getText().toString() + "','" + MaterialInspection_Comment.getText().toString() + "','" + MaterialInspection_MechanicalProperties.isChecked() + "','" + MaterialInspection_ChemicalProperties.isChecked() + "','" + MaterialInspection_UltrasonicTest.isChecked() + "','" + MaterialInspection_Hardness.isChecked() + "','" + MaterialInspection_Visual.isChecked() + "','" + MaterialInspection_Dimensions.isChecked() + "','" + ImageUri + "','" + 1 + "')");
            if (Res) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });

        MaterialInspection_Reject.setOnClickListener(view -> {
            Boolean Res = DatabaseCall.getData().Submit("Insert into MaterialInspection values ('" + MaterialInspection_TestRequestNo.getText().toString() + "','" + MaterialInspection_MaterialType.getText().toString() + "','" + MaterialInspection_MaterialID.getText().toString() + "','" + MaterialInspection_MaterialMake.getText().toString() + "','" + MaterialInspection_BatchLotNo.getText().toString() + "','" + MaterialInspection_Grade.getText().toString() + "','" + MaterialInspection_CastNo.getText().toString() + "','" + MaterialInspection_Size.getText().toString() + "','" + MaterialInspection_TotalQuantity.getText().toString() + "','" + MaterialInspection_InspectedQuantity.getText().toString() + "','" + MaterialInspection_Comment.getText().toString() + "','" + MaterialInspection_MechanicalProperties.isChecked() + "','" + MaterialInspection_ChemicalProperties.isChecked() + "','" + MaterialInspection_UltrasonicTest.isChecked() + "','" + MaterialInspection_Hardness.isChecked() + "','" + MaterialInspection_Visual.isChecked() + "','" + MaterialInspection_Dimensions.isChecked() + "','" + ImageUri + "','" + 0 + "')");
            if (Res) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });

        MaterialInspection_Scan.setOnClickListener(view -> {
            askCameraPermissions();
        });

        MaterialInspection_Gallery.setOnClickListener(view -> {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallery, GALLERY_REQUEST_CODE);
        });

    }

    private void askCameraPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        } else {
            dispatchTakePictureIntent();
        }

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "net.smallacademy.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent();
            } else {
                Toast.makeText(this, "Camera Permission is Required to Use camera.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                MaterialInspection_IMG.setImageURI(Uri.fromFile(f));
                Log.d("tag", "Absolute Url of Image is " + Uri.fromFile(f));

                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(f);
                ImageUri = contentUri.toString();
                mediaScanIntent.setData(contentUri);
                this.sendBroadcast(mediaScanIntent);
            }
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri contentUri = data.getData();
                ImageUri = contentUri.toString();
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "JPEG_" + timeStamp + "." + getFileExt(contentUri);
                Log.d("tag", "onActivityResult: Gallery Image Uri:  " + imageFileName);
                MaterialInspection_IMG.setImageURI(contentUri);
            }
        }
    }

    private String getFileExt(Uri contentUri) {
        ContentResolver c = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(c.getType(contentUri));
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}