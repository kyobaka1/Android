package com.example.dev.the_food_house.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.dev.the_food_house.SignupActivity;

/**
 * Created by dev on 5/10/2018.
 */

public class DBAdapter {
    public static final String stSoTT = "id";//số thứ tự
    public static final String stTen = "name";//tên
    public static final String stEmail = "email";//địa chỉ email
    public static final String stbg = "bg";//background
    public static final String avatar = "av";//avatar

    private static final String stClass = "DBAdapter";
    private static final String stCSDL = "MyDB";
    private static final String stBang = "contacts";
    private static final int iPhienBan = 1;

    private static final String DATABASE_CREATE = "create table contacts (id integer, "+ "name text not null, email text not null,bg text, av text);";
    private final Context context;

    private static DatabaseHelper DBHelper;
    private static SQLiteDatabase db;
    private static SQLiteDatabase dbw;
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) // hàm khởi tạo
        {
            super(context, stCSDL, null, iPhienBan);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {
                db.execSQL(DATABASE_CREATE);//tạo 1 cơ sở dữ liệu có 1 bảng contacts
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(stClass, "Upgrading database from version "+ oldVersion + " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getReadableDatabase();
        dbw = DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    public long insertContact(String name, String email)
    {
        ContentValues iv = new ContentValues();
        iv.put(stSoTT,1);
        iv.put(stTen, name);
        iv.put(stEmail, email);
        return dbw.insert(stBang, null, iv);
    }

    public boolean deleteContact(long lCotID)
    {
        return db.delete(stBang, stSoTT + "=" + lCotID, null) > 0;
    }

    public boolean updateContact(long rowId, String name, String email)
    {
        ContentValues args = new ContentValues();
        args.put(stTen, name);
        args.put(stTen, email);
        args.put(stTen, email);
        return db.update(stBang, args, stSoTT + "=" + rowId, null) > 0;
    }

    public Cursor getAllContacts()
    {
        return db.query(stBang, new String[] {stSoTT ,  stTen, stEmail }, null, null, null, null, null);
    }

    public String getCurrentUser(){
        Cursor c = db.query(stBang, new String[] {stSoTT ,  stTen, stEmail }, null, null, null, null, null);
        c.moveToLast();
        return c.getString(2);//sdt
    }

    public boolean setbgUser(String bg){
        String sdtuser = getCurrentUser();
        ContentValues args = new ContentValues();
        args.put(stbg, bg);
        return  db.update(stBang,args,stEmail + "LIKE"+sdtuser,null)>0;
    }

    public String getbguser(){
        Cursor c = db.query(stBang,new String[] {stbg},null,null,null,null,null);
        c.moveToFirst();
        return c.getString(0);
    }

    public boolean setavUser(String bg){
        String sdtuser = getCurrentUser();
        ContentValues args = new ContentValues();
        args.put(avatar, bg);
        return  db.update(stBang,args,stEmail + "LIKE"+sdtuser,null)>0;
    }

    public String getavuser(){
        Cursor c = db.query(stBang,new String[] {avatar},null,null,null,null,null);
        c.moveToFirst();
        return c.getString(0);
    }





}
