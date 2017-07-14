package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Slot extends Activity {
    EditText date;
    Button search, area1, area2, area3, area4, area5, area6, area7, area8;
    Spinner spinner1, spinner2;
    Data dbData;
    ArrayAdapter<String> adapter, adapter1;
    Intent info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

        //////////////////////////
        info = this.getIntent();

        date = (EditText) findViewById(R.id.editText6);
        search = (Button) findViewById(R.id.search);
        area1 = (Button) findViewById(R.id.area1);
        area2 = (Button) findViewById(R.id.area2);
        area3 = (Button) findViewById(R.id.area3);
        area4 = (Button) findViewById(R.id.area4);
        area5 = (Button) findViewById(R.id.area5);
        area6 = (Button) findViewById(R.id.area6);
        area7 = (Button) findViewById(R.id.area7);
        area8 = (Button) findViewById(R.id.area8);

        final ArrayList<String> data = new ArrayList<>();
        data.add("1:00");
        data.add("2:00");
        data.add("3:00");
        data.add("4:00");
        data.add("5:00");
        data.add("6:00");
        data.add("7:00");
        data.add("8:00");
        data.add("9:00");
        data.add("10:00");
        data.add("11:00");
        data.add("12:00");
        data.add("13:00");
        data.add("14:00");
        data.add("15:00");
        final ArrayList<String> data1 = new ArrayList<>();
        data1.add("1 Hrs");
        data1.add("2 Hrs");
        data1.add("3 Hrs");
        data1.add("4 Hrs");
        data1.add("5 Hrs");
        data1.add("6 Hrs");
        data1.add("7 Hrs");
        data1.add("8 Hrs");
        data1.add("9 Hrs");
        data1.add("10 Hrs");
        data1.add("11 Hrs");
        data1.add("12 Hrs");

        dbData = new Data(this);
        //////////////////////////////////////////////
        spinner1 = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);
        spinner1.setAdapter(adapter);
        /////////////////////
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data1);
        spinner2.setAdapter(adapter1);
        ////////////////////////////////////////////////////////////
        String plot = info.getExtras().getString("plot");
        String slot = info.getExtras().getString("slot");

        String plot2 = info.getExtras().getString("plot22");
        String slot2 = info.getExtras().getString("slot2");

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                area1.setEnabled(true);
                area2.setEnabled(true);
                area3.setEnabled(true);
                area4.setEnabled(true);
                area5.setEnabled(true);
                area6.setEnabled(true);
                area7.setEnabled(true);
                area8.setEnabled(true);

                String area = area1.getText().toString();
                String are2 = area2.getText().toString();
                String are3 = area3.getText().toString();
                String are4 = area4.getText().toString();
                String are5 = area5.getText().toString();
                String are6 = area6.getText().toString();
                String are7 = area7.getText().toString();
                String are8 = area8.getText().toString();

                String dat = date.getText().toString();
                String dur = spinner1.getSelectedItem().toString();
                String tim = spinner2.getSelectedItem().toString();
                dbData.open_db();

                try {
                    Cursor cursor = dbData.get_dataselect();
                    ArrayList<String> get_area = new ArrayList<String>();
                    ArrayList<String> get_date = new ArrayList<String>();
                    ArrayList<String> get_duration = new ArrayList<String>();
                    ArrayList<String> get_time = new ArrayList<String>();

                    if (cursor.moveToFirst()) {
                        do {
                            get_area.add(cursor.getString(6));
                            get_date.add(cursor.getString(1));
                            get_duration.add(cursor.getString(2));
                            get_time.add(cursor.getString(3));
                        } while (cursor.moveToNext());
                    }

                    boolean flag = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((area.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == true) {

                        Toast.makeText(Slot.this, "excute area1", Toast.LENGTH_SHORT).show();
                        area1.setBackgroundColor(Color.RED);

                    }

                    boolean flag2 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are2.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag2 = true;
                            break;
                        }
                    }
                    if (flag2 == true) {
                        Toast.makeText(Slot.this, "excute area2", Toast.LENGTH_SHORT).show();
                        area2.setBackgroundColor(Color.RED);

                    }

                    boolean flag3 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are3.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag3 = true;
                            break;
                        }
                    }
                    if (flag3 == true) {

                        Toast.makeText(Slot.this, "excute area3", Toast.LENGTH_SHORT).show();
                        area3.setBackgroundColor(Color.RED);

                    }

                    boolean flag4 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are4.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag4 = true;
                            break;
                        }
                    }
                    if (flag4 == true) {

                        Toast.makeText(Slot.this, "excute area4", Toast.LENGTH_SHORT).show();
                        area4.setBackgroundColor(Color.RED);

                    }

                    boolean flag5 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are5.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag5 = true;
                            break;
                        }
                    }
                    if (flag5 == true) {

                        Toast.makeText(Slot.this, "excute area5", Toast.LENGTH_SHORT).show();
                        area5.setBackgroundColor(Color.RED);

                    }

                    boolean flag6 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are6.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag6 = true;
                            break;
                        }
                    }
                    if (flag6 == true) {

                        Toast.makeText(Slot.this, "excute area6", Toast.LENGTH_SHORT).show();
                        area6.setBackgroundColor(Color.RED);

                    }

                    boolean flag7 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are7.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag7 = true;
                            break;
                        }
                    }
                    if (flag7 == true) {

                        Toast.makeText(Slot.this, "excute area7 ", Toast.LENGTH_SHORT).show();
                        area7.setBackgroundColor(Color.RED);

                    }
                    boolean flag8 = false;
                    for (int i = 0; i < get_area.size(); i++) {
                        if ((are8.equals(get_area.get(i))) && (dat.equals(get_date.get(i))) && (dur.equals(get_duration.get(i))) && (tim.equals(get_time.get(i)))) {
                            flag8 = true;
                            break;
                        }
                    }
                    if (flag8 == true) {
                        Toast.makeText(Slot.this, "excute area8", Toast.LENGTH_SHORT).show();

                        area8.setBackgroundColor(Color.RED);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area1.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);

                area1.setBackgroundColor(Color.GREEN);

            }
        });
        area2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area2.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);

                area2.setBackgroundColor(Color.GREEN);

            }
        });
        area3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area3.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);
                area3.setBackgroundColor(Color.GREEN);

            }
        });
        area4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area4.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);
                area4.setBackgroundColor(Color.GREEN);

            }
        });
        area5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area5.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);

                area5.setBackgroundColor(Color.GREEN);

            }
        });
        area6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area6.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);

                area6.setBackgroundColor(Color.GREEN);

            }
        });
        area7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area7.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);

                area7.setBackgroundColor(Color.GREEN);

            }
        });

        area8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = area8.getText().toString();
                String plot = info.getExtras().getString("plot");
                String slot = info.getExtras().getString("slot");
                areaText(area,slot,plot);

                area8.setBackgroundColor(Color.GREEN);

            }
        });

    }

    void areaText(String area,String slot,String plot) {
        String getdate = date.getText().toString();
        String gettime = spinner1.getSelectedItem().toString();
        String getduration = spinner2.getSelectedItem().toString();
        dbData.open_db();

        if (slot == "slot1"&&plot=="plot1") {

            dbData.insert_db(getdate, gettime, getduration, plot, slot, area);

        } else {
            dbData.insert_db(getdate, gettime, getduration, plot, slot, area);

        }
    }
}