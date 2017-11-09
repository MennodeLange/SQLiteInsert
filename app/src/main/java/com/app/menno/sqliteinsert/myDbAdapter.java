package com.app.menno.sqliteinsert;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Menno on 5-11-2017.
 */

public class myDbAdapter {
    myDbHelper helper;

    public myDbAdapter(Context context)
    {
        helper = new myDbHelper(context);
    }

    // De user name & password opslaan
    public long insertData(String name, String password)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.UserEntity.USER_NAME, name);
        contentValues.put(UserContract.UserEntity.USER_PWD, password);

        long id = db.insert(UserContract.UserEntity.TABLE_NAME, null , contentValues);

        return id;
    }

    // Database aanmaken
    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String CREATE_TABLE = "CREATE TABLE "+ UserContract.UserEntity.TABLE_NAME +
                "( "+ UserContract.UserEntity.UID +" INTEGER PRIMARY KEY AUTOINCREMENT ," + UserContract.UserEntity.USER_NAME + " VARCHAR(225), " + UserContract.UserEntity.USER_PWD+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ UserContract.UserEntity.TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, UserContract.DATABASE_NAME, null, UserContract.DATABASE_VERSION);
            this.context=context;
            Message.message(context,"Started...");
        }

        // Create table and shows it with a message: "TABLE CREATED, else it shows a exception"
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL(CREATE_TABLE);
                Message.message(context,"TABLE CREATED");
            } catch (Exception e)
            {
                Message.message(context,""+e);
            }
        }

        // Wanneer de database versies verschillen
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e)
            {
                Message.message(context,""+e);
            }
        }
    }
}
