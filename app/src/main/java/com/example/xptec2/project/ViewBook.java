package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ViewBook extends Activity {

    DBController dbController;
    EditText editid;
    Button search, cancel;
    TextView plot, slot, idd, date;
    Data dbData;
    int ddd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        dbController = new DBController(this);
        dbData = new Data(ViewBook.this);

        search = (Button) findViewById(R.id.search);

        editid = (EditText) findViewById(R.id.id);
        plot = (TextView) findViewById(R.id.tplot);
        slot = (TextView) findViewById(R.id.tslot);
        idd = (TextView) findViewById(R.id.tid);
        date = (TextView) findViewById(R.id.tdate);
        final Intent info=this.getIntent();


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbData.open_db();
                try {
                    Cursor cursor = dbData.get_dataselect();
                    if (cursor.moveToFirst()) {
                        do {
                            ddd = Integer.parseInt(editid.getText().toString());
                            int userId = cursor.getInt(7);
                            if (MainActivity.user_id == userId) {
                                if (ddd == cursor.getInt(0)) {
                                    //id_user OR // id_Booking
                                    //idd.setText(cursor.getString(0));
                                    idd.setText(MainActivity.user_id+"");
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
    }
}
