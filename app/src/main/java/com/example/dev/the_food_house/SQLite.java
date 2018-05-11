package com.example.dev.the_food_house;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 5/10/2018.
 */

public class SQLite extends SQLiteOpenHelper {
    private static final String Database = "Quan_li";
    private static final String Table = "Mon_An";
    private static final String Id = "id";
    private static final String Ten_mon = "Ten_mon";
    private static final String Huong_Dan = "Huong_dan";
    private Context context;
    private String sqlQuery = "CREATE TABLE " + Table + " (" +
            Id + " integer primary key, " +
            Ten_mon + " TEXT, " +
            Huong_Dan + " TEXT)";

    public SQLite(Context context) {
        super(context, Database, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add_Note(Mon_an noteadd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Id, noteadd.getIdMonAn());
        values.put(Ten_mon, noteadd.getTenMonAn());
        values.put(Huong_Dan, noteadd.getHuongDanNauAn());
        db.insert(Table, null, values);

        db.close();
    }

    public List<Mon_an> getNote() {
        List<Mon_an> list = new ArrayList<Mon_an>();
        String select = " SELECT * FROM " + Table;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(select,null);
        if (cursor.moveToFirst()) {
            do {
                Mon_an note_class_011 = new Mon_an();
                note_class_011.setIdMonAn(cursor.getInt(0));
                note_class_011.setTenMonAn(cursor.getString(1));
                note_class_011.setHuongDanNauAn(cursor.getString(2));
                list.add(note_class_011);

            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
    public int Delete(int ID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table,Id+"=?", new String[]{String.valueOf(ID)});
    }

}