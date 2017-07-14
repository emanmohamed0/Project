package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;


public class MainActivity extends Activity {
    int flag =0;
    Button user ,log;
    EditText username,pass;
    DBController controller;
    int s=0;
    static int user_id;
    static String nameuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);

        log=(Button)findViewById(R.id.log);
        user=(Button)findViewById(R.id.newuser);

        controller=new DBController(this);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long lastId = 0;
                try {
                    lastId = controller.getLastId();

             //   Toast.makeText(getBaseContext(),""+lastId,Toast.LENGTH_LONG).show();
                Intent i =new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("lastid", lastId+"");
                startActivity(i);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name =  username.getText().toString();
               String passward = pass.getText().toString();

                DBController dbController =new DBController(MainActivity.this);
                try {
                    dbController.open();

                    Cursor cursor = dbController.get_dataselect();
                    ArrayList<String> n = new ArrayList<String>();
                    ArrayList<String> p = new ArrayList<String>();
                    ArrayList<Integer> id = new ArrayList<Integer>();
                    if (cursor.moveToFirst()) {
                        do {
                            id.add(cursor.getInt(0));
                            n.add(cursor.getString(1));
                            p.add(cursor.getString(4));
                        } while (cursor.moveToNext());
                    }

                    boolean flag = false;
                    for (int i = 0; i < n.size(); i++) {
                        if ((name.equals(n.get(i))) && (passward.equals(p.get(i)))) {
                            user_id = id.get(i);
                           nameuser= n.get(i);
                            flag = true;
                            break;
                        }
                    }
                    if (flag == true) {

                        Toast.makeText(MainActivity.this, "Succeful LogIn", Toast.LENGTH_SHORT).show();
                        Intent ii = new Intent(MainActivity.this, LogIn.class);
                        ii.putExtra("name", username.getText().toString());
                        startActivity(ii);

                    } else {
                        Toast.makeText(MainActivity.this, "UserName Or Passward  My be incorrect", Toast.LENGTH_SHORT).show();
                    }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        });
    }
//    @Override
//    protected void onResume(){
//        try {
//            Cursor c=controller.get_dataselect();
//            super.onResume();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//    }

}
