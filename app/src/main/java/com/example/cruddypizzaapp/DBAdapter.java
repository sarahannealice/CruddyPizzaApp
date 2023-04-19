package com.example.cruddypizzaapp;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;

public class DBAdapter {
    //column keys
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_SIZE = "size";
    public static final String KEY_TOP1 = "top1";
    public static final String KEY_TOP2 = "top2";
    public static final String KEY_TOP3 = "top3";
    public static final String TAG = "DBAdapter";

    //database info
    private static final String DATABASE_NAME = "data_source";
    private static final String DATABASE_TABLE = "orders";
    private static final int DATABASE_VERSION = 1;

    //query to create database and table
    private static final String DATABASE_CREATE =
            "CREATE TABLE orders (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "phone TEXT NOT NULL," +
                    "size INTEGER NOT NULL," +
                    "top1 INTEGER NOT NULL," +
                    "top2 INTEGER NOT NULL," +
                    "top3 INTEGER NOT NULL" +
                    ");";


    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private Context context = null;

    public DBAdapter(Context context) {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//end onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "upgrade database from version " + oldVersion + " to " + newVersion +
                    " which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS orders");
            onCreate(db);
        }//end onUpgrade
    }//end helper

    //open database
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //closes database
    public void close() {
        DBHelper.close();
    }

    //insert new order
    public long submitOrder(String name, String phone, int size, int top1, int top2, int top3) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_PHONE, phone);
        initialValues.put(KEY_SIZE, size);
        initialValues.put(KEY_TOP1, top1);
        initialValues.put(KEY_TOP2, top2);
        initialValues.put(KEY_TOP3, top3);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }//end insert

    //delete single order
    public boolean deleteOrder(long orderNum) {
        return db.delete(DATABASE_TABLE, KEY_ROWID + " = " + orderNum, null) > 0;
    }//end delete

    //update single order
    public boolean updateOrder(long orderNum, String name, String phone, int size, int top1, int top2, int top3) {
        ContentValues cval = new ContentValues();
        cval.put(KEY_NAME, name);
        cval.put(KEY_PHONE, phone);
        cval.put(KEY_SIZE, size);
        cval.put(KEY_TOP1, top1);
        cval.put(KEY_TOP2, top2);
        cval.put(KEY_TOP3, top3);

        return db.update(DATABASE_TABLE, cval, KEY_ROWID + " = " + orderNum, null) > 0;
    }//end update

    //retrieve all orders
    public Cursor getAllOrders() {
        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID + " DESC", KEY_NAME, KEY_PHONE, KEY_SIZE, KEY_TOP1, KEY_TOP2, KEY_TOP3},
                null, null, null, null, null);
    }
}//end DBAdapter class
