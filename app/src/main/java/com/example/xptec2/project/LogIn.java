package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LogIn extends Activity {
Button book,viewbook,cancel,detail,logout;
    TextView welcom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        welcom=(TextView)findViewById(R.id.welcome);
        book=(Button)findViewById(R.id.button4);
        viewbook=(Button)findViewById(R.id.button5);
        cancel=(Button)findViewById(R.id.button8);
        detail=(Button)findViewById(R.id.button6);
        logout=(Button)findViewById(R.id.button9);

        welcom.setText("Welcome "+MainActivity.nameuser);

        final Intent info =this.getIntent();
        viewbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String view=  viewbook.getText().toString();
                Intent i= new Intent(LogIn.this,ViewBook.class);
                startActivity(i);

            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LogIn.this,NewBook.class);
                startActivity(i);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cancl=  cancel.getText().toString();
                Intent i= new Intent(LogIn.this,CancelBooking.class);
                startActivity(i);

            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = info.getExtras().getString("name");
                Intent i= new Intent(LogIn.this,MyDetail.class);
                i.putExtra("getname",name);
                startActivity(i);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LogIn.this,MainActivity.class);
                startActivity(i);
            }
        });
    }


}
