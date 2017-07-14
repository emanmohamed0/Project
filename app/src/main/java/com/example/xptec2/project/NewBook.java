package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewBook extends Activity {
Button plot1,plot2;
    Data dbData;
TextView welcom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        welcom=(TextView)findViewById(R.id.welcome1);
        welcom.setText("Welcome "+MainActivity.nameuser);

        dbData=new Data(this);
        plot1=(Button)findViewById(R.id.button10);
        plot2=(Button)findViewById(R.id.button11);
        plot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plotText(plot1.getText().toString());

            }
        });
        plot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plotText(plot2.getText().toString());

            }
        });
    }
    void plotText(String plot){
        Intent i = new Intent(NewBook.this, Plot.class);

        if (plot == "plot1") {
            i.putExtra("plot1", plot);
            startActivity(i);

        } else {
            i.putExtra("plot1", plot);
            startActivity(i);
        }
    }


}
