package com.example.xptec2.project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by XP Tec2 on 25/11/2015.
 */
public class DBController  {
    DBHelper dbHelper;
    SQLiteDatabase database;

    public DBController(Context c){
        dbHelper=new DBHelper(c);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close_db(){
       dbHelper.close();
    }
    public void insert_db(String name,String phone,String email,String passward) throws SQLException {
       open();

        ContentValues values=new ContentValues();
        values.put(DBHelper.NAME,name);
        values.put(DBHelper.PHONE,phone);
        values.put(DBHelper.EMAIL,email);
        values.put(DBHelper.PASSWARD,passward);

        database.insert(DBHelper.TABLE_NAME,null,values);
        close_db();
    }



    public void delete_db(int id){
        //open_db();
        database.delete(DBHelper.TABLE_NAME, DBHelper.ID + "=" + id, null);
        close_db();
    }
    public void update(int id,String name ,String phone,String email,String address){
       // open_db();
        ContentValues values=new ContentValues();
        values.put(DBHelper.NAME,name);
        values.put(DBHelper.PHONE, phone);
        values.put(DBHelper.EMAIL,email);
        values.put(DBHelper.PASSWARD,address);

        database.update(DBHelper.TABLE_NAME, values, DBHelper.ID + "=" + id, null);
        close_db();
    }

    public long getLastId() throws SQLException {
       // open_db();
        Cursor cursor = get_dataselect();
        int id = 0;
        if(cursor.moveToFirst()) {
            do {
                id = cursor.getInt(0);
            } while (cursor.moveToNext());
        }

        return ++id ;
    }

    public Cursor get_dataselect() throws SQLException {

        open();
        String [] column ={DBHelper.ID,DBHelper.NAME,DBHelper.PHONE,DBHelper.EMAIL,DBHelper.PASSWARD};
        Cursor c= database.query(DBHelper.TABLE_NAME,column,null,null,null,null,null,null);

        if(c !=null){
            c.moveToFirst();
        }
        close_db();
        return  c;
    }

}
