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

public class URM_MaterialReceipt_1 extends AppCompatActivity {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    EditText MaterialReceipt_MaterialID, MaterialReceipt_MaterialType, MaterialReceipt_MaterialMake, MaterialReceipt_BatchLotNo, MaterialReceipt_MaterialLot, MaterialReceipt_TotalQty, MaterialReceipt_ExpiryDate, MaterialReceipt_ReceivedDate;
    Button MaterialReceipt_Submit, MaterialID_Scan, MaterialID_Gallery;
    ImageView MaterialID_IMG;
    String currentPhotoPath;
    String ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urm_material_receipt1);


        MaterialReceipt_MaterialID = findViewById(R.id.MaterialReceipt_MaterialID);
        MaterialReceipt_MaterialType = findViewById(R.id.MaterialReceipt_MaterialType);
        MaterialReceipt_MaterialMake = findViewById(R.id.MaterialReceipt_MaterialMake);
        MaterialReceipt_BatchLotNo = findViewById(R.id.MaterialReceipt_BatchLotNo);
        MaterialReceipt_MaterialLot = findViewById(R.id.MaterialReceipt_MaterialLot);
        MaterialReceipt_TotalQty = findViewById(R.id.MaterialReceipt_TotalQty);
        MaterialReceipt_ExpiryDate = findViewById(R.id.MaterialReceipt_ExpiryDate);
        MaterialReceipt_ReceivedDate = findViewById(R.id.MaterialReceipt_ReceivedDate);
        MaterialReceipt_Submit = findViewById(R.id.MaterialReceipt_Submit);
        MaterialID_Gallery = findViewById(R.id.MaterialID_Gallery);
        MaterialID_Scan = findViewById(R.id.MaterialID_Scan);
        MaterialID_IMG = findViewById(R.id.MaterialID_IMG);

        MaterialReceipt_Submit.setOnClickListener(view -> {
            Boolean Res = DatabaseCall.getData().Submit("Insert into MaterialRecepit values ('" + MaterialReceipt_MaterialID.getText().toString() + "','" + MaterialReceipt_MaterialType.getText().toString() + "','" + MaterialReceipt_MaterialMake.getText().toString() + "','" + MaterialReceipt_BatchLotNo.getText().toString() + "','" + MaterialReceipt_MaterialLot.getText().toString() + "','" + MaterialReceipt_TotalQty.getText().toString() + "','" + MaterialReceipt_ExpiryDate.getText().toString() + "','" + MaterialReceipt_ReceivedDate.getText().toString() + "','" + ImageUri + "')");
            if (Res) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });

        MaterialID_Scan.setOnClickListener(view -> {
            askCameraPermissions();
        });

        MaterialID_Gallery.setOnClickListener(view -> {
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
                MaterialID_IMG.setImageURI(Uri.fromFile(f));
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
                MaterialID_IMG.setImageURI(contentUri);
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