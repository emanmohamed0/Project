package com.example.xptec2.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by XP Tec2 on 25/11/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    //database_declare
    private static final String DATABASE_NAME="MYDB";
    private static final int DATABASE_VERSION=1;

    //tables
    public static final String TABLE_NAME="names";
    //columns
    public static final String ID="_id";
    public static final String NAME="name";
    public static final String PHONE="phone";
    public static final String EMAIL="email";
    public static final String PASSWARD="passward";

    /////////////////////Second table///////////////////////////////
    //tables
    public static final String TABLE_TIME="datas";
    //columns
    public static final String ID_TIME="_id";
    public static final String DATE="date";
    public static final String TIME="time";
    public static final String DURATION="duration";
    public static final String PLOT="plot";
    public static final String SLOT="slot";
    public static final String AREA="area";
    public static final String USER_ID="iduser";

    //constractors
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    //create TABLE
    String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+
            "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            NAME+" TEXT,"+PHONE+" TEXT,"+EMAIL+" TEXT,"+PASSWARD+" TEXT);";

    //create TABLE2
    String CREATE_TABLE2="CREATE TABLE "+TABLE_TIME+
            "("+ID_TIME+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            DATE+" TEXT,"+TIME+" TEXT,"+DURATION+" TEXT,"+PLOT+" TEXT,"+SLOT+" TEXT,"+AREA+" TEXT, " + USER_ID + " INTEGER " + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TIME);

        onCreate(db);

    }
}
