package com.example.canberk.calendar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = " meetings ";
    private static final String COL1 = " ID ";
    private static final String COL2 = " NAME ";
    private static final String COL3 = " DATE ";
    private static final String COL4 = " TIME ";

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1 ){
        database.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(database);
    }

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String createTable;
        createTable = (" CREATE TABLE " + TABLE_NAME + " " + COL2 + " AS " + COL3 + " AS " + COL4);
        String a=(" CREATE TABLE TABLE_NAME "+" (ID integer PRIMARY KEY, NAME TEXT, DATE TEXT, TIME TEXT) ");
        //database.execSQL(a);
    }
    public boolean addData(String event){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(COL2,event);

        Log.d(TAG, "addData: Adding event to" + TABLE_NAME);
        long result = database.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "select * from "+ TABLE_NAME;
        Cursor data = database.rawQuery(query,null);
        return data;

    }
}
