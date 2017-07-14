package com.example.xptec2.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by XP Tec2 on 04/05/2016.
 */

    public class Data {
        MyDetail myDetail=new MyDetail();
        DBHelper dbHelperData;
        SQLiteDatabase databas;

        public Data(Context c){
            dbHelperData=new DBHelper(c);
        }
        public void open_db(){
            databas=dbHelperData.getWritableDatabase();
        }

        public void close_db(){
            dbHelperData.close();
        }
        public void insert_db(String date,String time,String duration,String plot,String slot,String area){
            open_db();
            ContentValues values=new ContentValues();
            values.put(DBHelper.DATE,date);
            values.put(DBHelper.TIME,time);
            values.put(DBHelper.DURATION,duration);
            values.put(DBHelper.PLOT,plot);
            values.put(DBHelper.SLOT,slot);
            values.put(DBHelper.AREA,area);
            values.put(DBHelper.USER_ID,MainActivity.user_id);

            databas.insert(DBHelper.TABLE_TIME,null,values);
            close_db();
        }
        public void delete_db(int id) throws Exception{
            open_db();
            databas.delete(DBHelper.TABLE_TIME, DBHelper.ID_TIME + "=" + id, null);
            close_db();
        }
        public void update(int id,String date,String time,String duration,String area){
            open_db();

            ContentValues values=new ContentValues();
            values.put(DBHelper.DATE,date);
            values.put(DBHelper.TIME,time);
            values.put(DBHelper.DURATION,duration);
            values.put(DBHelper.AREA,area);

            databas.update(DBHelper.TABLE_TIME, values, DBHelper.ID_TIME + "=" + id, null);
            close_db();
        }


        public Cursor get_dataselect() throws Exception{

            open_db();
            String [] column ={DBHelper.ID_TIME,DBHelper.DATE,DBHelper.TIME,DBHelper.DURATION,DBHelper.PLOT,DBHelper.SLOT,DBHelper.AREA ,DBHelper.USER_ID};
            Cursor c= databas.query(DBHelper.TABLE_TIME,column,null,null,null,null,null,null);

            if(c !=null){
                c.moveToFirst();
            }
            return  c;
        }


    }


