package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;


public class MyDetail extends Activity {
    TextView n ,e,ph,vb;
    static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detail);

        n = (TextView) findViewById(R.id.textView14);
        ph = (TextView) findViewById(R.id.textView15);
        e = (TextView) findViewById(R.id.email);
        vb = (TextView) findViewById(R.id.vb);

        Intent back = getIntent();
        String name =back.getExtras().getString("getname");

        DBController dbController = new DBController(this);
        try {
            dbController.open();
            Cursor cursor = dbController.get_dataselect();

            if (cursor.moveToFirst()) {
                do {
                    if ((name.equals(cursor.getString(1)))) {

                        id= cursor.getInt(0);
                        n.setText(name);
                        ph.setText(cursor.getString(2));
                        e.setText(cursor.getString(3));
                        break;
                    }

                } while (cursor.moveToNext());
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
            Toast.makeText(getBaseContext(),"Method on exception",Toast.LENGTH_SHORT).show();
        }

        //////////////////////////////////////////////////////

        Data dbdata = new Data(this);

            dbdata.open_db();
        try {
            Cursor cursor = dbdata.get_dataselect();
            if (cursor.moveToFirst()) {
                do {
                    int userId = cursor.getInt(7);
                    if (id == userId) {
                        vb.append(cursor.getInt(0)+"  ");
                    }

                } while (cursor.moveToNext());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }


}
