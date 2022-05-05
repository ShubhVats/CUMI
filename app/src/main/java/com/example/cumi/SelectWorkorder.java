package com.example.cumi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectWorkorder extends AppCompatActivity {

    Spinner WorkOrderSpinner;
    Button NavBtn, ScanBtn;
    TextView BarcodeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workorder);

        NavBtn = findViewById(R.id.workOrder_btn);
        ScanBtn = findViewById(R.id.workOrder_scan_btn);
        WorkOrderSpinner = findViewById(R.id.workOrder_spinner);
        BarcodeValue = findViewById(R.id.workOrder_barcodeValue_txt);

        //Get Intent
        String processKeyMaster = getIntent().getStringExtra("processKey");

        //Spinner
        Integer[] arr = {1, 2, 3, 4, 5};
        WorkOrderSpinner.setAdapter(new ArrayAdapter<>(SelectWorkorder.this, android.R.layout.simple_spinner_dropdown_item, arr));

        //Get Intent(Barcode Value)
        String barcodeVal = getIntent().getStringExtra("BarcodeValue");
        BarcodeValue.setText(barcodeVal);

        //Scanning
        ScanBtn.setOnClickListener(view -> {
            Intent i = new Intent(SelectWorkorder.this, barcodeScanning.class);
            i.putExtra("processKey", processKeyMaster);
            startActivity(i);
        });

        String processKey = getIntent().getStringExtra("processKey");
        String Parent = getIntent().getStringExtra("Parent");

        NavBtn.setOnClickListener(view -> {
            if (Parent.equals("Production")) {
                switch (processKey) {

                    case "P03	Profile cutting": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P04	Casing-Edge Preparation": {
                        Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P05	Casing-Rolling": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P06	Casing-L Seam welding": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P07	Flange-Edge Preparation": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P08_1	Root run welding": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P08_2	Cap run welding": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "PO9	Flange-NDT": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P10_1	OD Machining": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P10_2	ID Machinig": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P10_3	Thickness Grinding": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P10_4	Drilling": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P11	Flange-Dimension check": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P12	Fit-Up": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P13_1	Root run welding": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P13_2	Cap run welding": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P14_1	Layout Inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P14_2	Weld Visual inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P15	NDT": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "EP03	Customer inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P16	Leak Test": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "EP04	Customer inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P17	Blasting": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P18	Primary coat Lining surface": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P19	Inspection": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
//                    break;
                    }
                    case "P20	Bonding material mixing": {
                        Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P21_1	Normal Lining": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P21_2	Segment Lining": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P21_3	Segment Welding": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P21_4	Segment Quality": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P22	Flush grinding": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P23	Line visual + Dimensional inspection": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P24	Blasting - OD": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);
//                        i.putExtra("processKey", processKey);
//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P25	Paint mixing data": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P26	Painting": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P27	type-1 Base coating": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "AP01	Owen drying": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P28	inspection": {
                        Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP02	Intermediate coating": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        startActivity(i);
                        break;
                    }
                    case "AP03	Owen drying": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        startActivity(i);
                        break;
                    }
                    case "AP04	inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P29	Final paint coating": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm037.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP05	Owen drying": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm020.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P30	Inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm034.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP06	Assembly inspection": {
                        Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P32	Customer inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P33	Final inspection clearances by customer": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P34	Pack and dispatch": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    default:
                        Toast.makeText(SelectWorkorder.this, "How?", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else if (Parent.equals("Quality")) {
                switch (processKey) {
                    case "P03	Profile cutting": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("processKey", processKey);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P04	Casing-Edge Preparation": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P05	Casing-Rolling": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P06	Casing-L Seam welding": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P07	Flange-Edge Preparation": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P08_1	Root run welding": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P08_2	Cap run welding": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "PO9	Flange-NDT": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm020.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P10_1	OD Machining": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P10_2	ID Machinig": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P10_3	Thickness Grinding": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P10_4	Drilling": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P11	Flange-Dimension check": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P12	Fit-Up": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm037.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P13_1	Root run welding": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P13_2	Cap run welding": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm038.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P14_1	Layout Inspection": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P14_2	Weld Visual inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm039.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P15	NDT": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm020.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "EP03	Customer inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P16	Leak Test": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm034.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "EP04	Customer inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P17	Blasting": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P18	Primary coat Lining surface": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P19	Inspection": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
//                    break;
                    }
                    case "P20	Bonding material mixing": {
                        Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P21_1	Normal Lining": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P21_2	Segment Lining": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P21_3	Segment Welding": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P21_4	Segment Quality": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P22	Flush grinding": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P23	Line visual + Dimensional inspection": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P24	Blasting - OD": {
//                    Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);                         i.putExtra("Parent",Parent);i.putExtra("processKey", processKey);

//                    i.putExtra("barcodeVal", barcodeVal);
//                    startActivity(i);
                        break;
                    }
                    case "P25	Paint mixing data": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P26	Painting": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P27	type-1 Base coating": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "AP01	Owen drying": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("barcodeVal", barcodeVal);
                        startActivity(i);
                        break;
                    }
                    case "P28	inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP02	Intermediate coating": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP03	Owen drying": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP04	inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P29	Final paint coating": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP05	Owen drying": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "P30	Inspection": {
                        Intent i = new Intent(SelectWorkorder.this, QAForm050.class);
                        i.putExtra("Parent", Parent);
                        startActivity(i);
                        break;
                    }
                    case "AP06	Assembly inspection": {
//                    Intent i = new Intent(SelectWorkorder.this, PG1Form055.class);                         i.putExtra("Parent",Parent);
//                    startActivity(i);
//                    break;
                    }
                    case "P32	Customer inspection": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        startActivity(i);
                        break;
                    }
                    case "P33	Final inspection clearances by customer": {
                        Intent i = new Intent(SelectWorkorder.this, ProfileCutting.class);
                        i.putExtra("Parent", Parent);
                        i.putExtra("processKey", processKey);
                        startActivity(i);
                        break;
                    }
                    case "P34	Pack and dispatch": {
//                    Intent i = new Intent(SelectWorkorder.this, QAForm050.class);                         i.putExtra("Parent",Parent);
//                    startActivity(i);
//                    break;
                    }
                    default:
                        Toast.makeText(SelectWorkorder.this, "How?", Toast.LENGTH_SHORT).show();
                        break;
                }

            } else {
                Toast.makeText(SelectWorkorder.this, "How have you do this?????", Toast.LENGTH_SHORT).show();
            }
        });
    }
}