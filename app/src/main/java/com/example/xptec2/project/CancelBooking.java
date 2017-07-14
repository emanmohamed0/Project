package com.example.xptec2.project;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CancelBooking extends ActionBarActivity {
    DBController dbController;
    EditText editid;
    Button search, cancel;
    TextView plot, slot, idd, date;
    Data dbData;
    int ddd;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);

        dbData = new Data(CancelBooking.this);
        search = (Button) findViewById(R.id.search1);
        cancel = (Button) findViewById(R.id.cancel1);

        editid = (EditText) findViewById(R.id.id);
        plot = (TextView) findViewById(R.id.tplot);
        slot = (TextView) findViewById(R.id.tslot);
        idd = (TextView) findViewById(R.id.tid);
        date = (TextView) findViewById(R.id.tdate);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbData.open_db();
                try {
                    cursor = dbData.get_dataselect();
                    ddd = Integer.parseInt(editid.getText().toString());
                    if (cursor.moveToFirst()) {
                        do {
                            int userId = cursor.getInt(7);
                            if (MainActivity.user_id == userId) {
                                if (ddd == cursor.getInt(0)) {
                                    //id_user OR // id_Booking
                                    //idd.setText(cursor.getString(0));
                                    idd.setText(MainActivity.user_id + "");
                                    plot.setText(cursor.getString(4));
                                    slot.setText(cursor.getString(5));
                                    date.setText(cursor.getString(1));
                                }
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cursor.moveToFirst();
                    do {
                        if (ddd == cursor.getInt(0)) {
                         //   Toast.makeText(CancelBooking.this, "Valid ID", Toast.LENGTH_SHORT).show();

                            dbData.delete_db(ddd);
                        }
//                        } else
//                            Toast.makeText(CancelBooking.this, " InValid ID", Toast.LENGTH_SHORT).show();

                    }while (cursor.moveToNext());
                } catch (Exception e) {

                }

        }
        });
    }


}
