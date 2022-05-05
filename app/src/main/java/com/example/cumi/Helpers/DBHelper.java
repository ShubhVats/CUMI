package com.example.cumi.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "profileCutting.db", null, 1);
    }
//    Integer ProfileCutting_AutoAssetPOS, ProfileCutting_AutoSubAssetPOS, ProfileCutting_ManualAssetPOS, ProfileCutting_ManualSubAssetPOS, ProfileCutting_DataEntryStatusPOS;

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table profileCutting(ProfileCutting_Header TEXT primary key, ProfileCutting_ItemCode TEXT, ProfileCutting_DrawingNo TEXT, ProfileCutting_WorkOrderNo TEXT, ProfileCutting_PartID TEXT, ProfileCutting_Asset TEXT, ProfileCutting_SubAsset TEXT, ProfileCutting_Operator TEXT, ProfileCutting_Status TEXT, ProfileCutting_StartTime TEXT, ProfileCutting_EndTime INT,ProfileCutting_AutoAssetPOS INT, ProfileCutting_AutoSubAssetPOS INT, ProfileCutting_ManualAssetPOS INT, ProfileCutting_ManualSubAssetPOS INT, ProfileCutting_DataEntryStatusPOS INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists profileCutting");
    }

    public Boolean saveData(String ProfileCutting_Header, String ProfileCutting_ItemCode, String ProfileCutting_DrawingNo, String ProfileCutting_WorkOrderNo, String ProfileCutting_PartID, String ProfileCutting_Asset, String ProfileCutting_SubAsset, String ProfileCutting_Operator, String ProfileCutting_Status, String ProfileCutting_StartTime, String ProfileCutting_EndTime, Integer ProfileCutting_AutoAssetPOS, Integer ProfileCutting_AutoSubAssetPOS, Integer ProfileCutting_ManualAssetPOS, Integer ProfileCutting_ManualSubAssetPOS, Integer ProfileCutting_DataEntryStatusPOS) {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ProfileCutting_ItemCode", ProfileCutting_ItemCode);
        contentValues.put("ProfileCutting_DrawingNo", ProfileCutting_DrawingNo);
        contentValues.put("ProfileCutting_WorkOrderNo", ProfileCutting_WorkOrderNo);
        contentValues.put("ProfileCutting_PartID", ProfileCutting_PartID);
        contentValues.put("ProfileCutting_Asset", ProfileCutting_Asset);
        contentValues.put("ProfileCutting_SubAsset", ProfileCutting_SubAsset);
        contentValues.put("ProfileCutting_Operator", ProfileCutting_Operator);
        contentValues.put("ProfileCutting_Status", ProfileCutting_Status);
        contentValues.put("ProfileCutting_StartTime", ProfileCutting_StartTime);
        contentValues.put("ProfileCutting_EndTime", ProfileCutting_EndTime);
        contentValues.put("ProfileCutting_AutoAssetPOS", ProfileCutting_AutoAssetPOS);
        contentValues.put("ProfileCutting_AutoSubAssetPOS", ProfileCutting_AutoSubAssetPOS);
        contentValues.put("ProfileCutting_ManualAssetPOS", ProfileCutting_ManualAssetPOS);
        contentValues.put("ProfileCutting_ManualSubAssetPOS", ProfileCutting_ManualSubAssetPOS);
        contentValues.put("ProfileCutting_DataEntryStatusPOS", ProfileCutting_DataEntryStatusPOS);

        ContentValues contentValuesNew = new ContentValues();
        contentValuesNew.put("ProfileCutting_Header", ProfileCutting_Header);
        contentValuesNew.put("ProfileCutting_ItemCode", ProfileCutting_ItemCode);
        contentValuesNew.put("ProfileCutting_DrawingNo", ProfileCutting_DrawingNo);
        contentValuesNew.put("ProfileCutting_WorkOrderNo", ProfileCutting_WorkOrderNo);
        contentValuesNew.put("ProfileCutting_PartID", ProfileCutting_PartID);
        contentValuesNew.put("ProfileCutting_Asset", ProfileCutting_Asset);
        contentValuesNew.put("ProfileCutting_SubAsset", ProfileCutting_SubAsset);
        contentValuesNew.put("ProfileCutting_Operator", ProfileCutting_Operator);
        contentValuesNew.put("ProfileCutting_Status", ProfileCutting_Status);
        contentValuesNew.put("ProfileCutting_StartTime", ProfileCutting_StartTime);
        contentValuesNew.put("ProfileCutting_EndTime", ProfileCutting_EndTime);
        contentValuesNew.put("ProfileCutting_AutoAssetPOS", ProfileCutting_AutoAssetPOS);
        contentValuesNew.put("ProfileCutting_AutoSubAssetPOS", ProfileCutting_AutoSubAssetPOS);
        contentValuesNew.put("ProfileCutting_ManualAssetPOS", ProfileCutting_ManualAssetPOS);
        contentValuesNew.put("ProfileCutting_ManualSubAssetPOS", ProfileCutting_ManualSubAssetPOS);
        contentValuesNew.put("ProfileCutting_DataEntryStatusPOS", ProfileCutting_DataEntryStatusPOS);

        Cursor cursor = DB.rawQuery("Select * from profileCutting where ProfileCutting_Header = ?", new String[]{ProfileCutting_Header});
        if (cursor.getCount() > 0) {
            long result = DB.update("profileCutting", contentValues, "ProfileCutting_Header=?", new String[]{ProfileCutting_Header});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            long result = DB.insert("profileCutting", null, contentValuesNew);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
    }

    public Boolean insertuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata(String ProfileCutting_Header) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from profileCutting where ProfileCutting_Header = ?", new String[]{ProfileCutting_Header});
        if (cursor.getCount() > 0) {
            long result = DB.delete("profileCutting", "ProfileCutting_Header=?", new String[]{ProfileCutting_Header});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata(String ProfileCutting_Header) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from profileCutting where ProfileCutting_Header = ?", new String[]{ProfileCutting_Header});
        return cursor;
    }
}