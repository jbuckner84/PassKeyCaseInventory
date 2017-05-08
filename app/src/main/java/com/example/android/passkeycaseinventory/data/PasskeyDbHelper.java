package com.example.android.passkeycaseinventory.data;

/**
 * Created by Justin on 5/7/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.passkeycaseinventory.data.PasskeyContract.StockEntry;

public class PasskeyDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    public PasskeyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the stock table
        String SQL_CREATE_PASSKEY_TABLE =  "CREATE TABLE " + StockEntry.TABLE_NAME + " ("
                + StockEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StockEntry.COLUMN_SUPPLIER + " TEXT, "
                + StockEntry.COLUMN_PICTURE + " TEXT, "
                + StockEntry.COLUMN_QTY + " INTEGER, "
                + StockEntry.COLUMN_PRICE + " REAL NOT NULL DEFAULT 0.00, "
                + StockEntry.COLUMN_NAME + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PASSKEY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Still at version 1, no upgrade required
    }
}
