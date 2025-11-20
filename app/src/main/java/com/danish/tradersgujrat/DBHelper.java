package com.danish.tradersgujrat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) { super(context, "danishtradersgujrat.db", null, 1); }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE shops(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, address TEXT, balance REAL)");
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, role TEXT)");
        db.execSQL("CREATE TABLE transactions(id INTEGER PRIMARY KEY AUTOINCREMENT, shop_id INTEGER, type TEXT, amount REAL, latitude REAL, longitude REAL, ts TEXT)");
        ContentValues cv = new ContentValues();
        cv.put("name","Ali Store"); cv.put("phone","+923001234567"); cv.put("address","Gujrat Bazar"); cv.put("balance",0.0); db.insert("shops", null, cv);
        ContentValues u = new ContentValues(); u.put("username","admin"); u.put("password","admin123"); u.put("role","owner"); db.insert("users", null, u);
    }
    @Override public void onUpgrade(SQLiteDatabase db, int oldV, int newV) { db.execSQL("DROP TABLE IF EXISTS shops"); db.execSQL("DROP TABLE IF EXISTS users"); db.execSQL("DROP TABLE IF EXISTS transactions"); onCreate(db); }
    public Cursor getAllShops(){ return getReadableDatabase().rawQuery("SELECT * FROM shops", null); }
}
