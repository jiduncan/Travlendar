package com.example.seniorproject.travlendar.SQL_Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import com.example.seniorproject.travlendar.modal.User;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User table column names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    // Create table
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

   public DatabaseHelper(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(DROP_USER_TABLE);
       onCreate(db);
   }

   public void addUser(User user) {
       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues();
       values.put(COLUMN_USER_NAME, user.getName());
       values.put(COLUMN_USER_EMAIL, user.getEmail());
       values.put(COLUMN_USER_PASSWORD, user.getPassword());

       db.insert(TABLE_USER, null, values);
       db.close();
   }
}
