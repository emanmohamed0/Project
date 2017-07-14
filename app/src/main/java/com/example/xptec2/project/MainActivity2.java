package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity2 extends Activity {

    EditText id,name,phone,email,pass;
    Button submit;
    DBController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        submit=(Button)findViewById(R.id.submit);
        id=(EditText)findViewById(R.id.id);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);

        Intent back = getIntent();
        id.setText(back.getStringExtra("lastid"));

        controller=new DBController(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please Enter name", Toast.LENGTH_SHORT).show();
                }
               if(phone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please Enter phone_num", Toast.LENGTH_SHORT).show();
                }
                if(email.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please Enter email", Toast.LENGTH_SHORT).show();
                }
               if(pass.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please Enter pass", Toast.LENGTH_SHORT).show();
                }
                else  {
                   try {
                       controller.insert_db(name.getText().toString(),
                       phone.getText().toString(), email.getText().toString(), pass.getText().toString());

                       Toast.makeText(MainActivity2.this, "Succeful Complete Register", Toast.LENGTH_SHORT).show();
                       Intent i = new Intent(MainActivity2.this, MainActivity.class);
                       startActivity(i);
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }

                }
            }
        });

    }

}
