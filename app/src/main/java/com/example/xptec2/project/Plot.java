package com.example.xptec2.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Plot extends Activity {
    Button slot1, slot2;
    Intent getIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);
        slot1 = (Button) findViewById(R.id.button12);
        slot2 = (Button) findViewById(R.id.button13);

        final Intent getIntent = this.getIntent();
        getIntent2 = this.getIntent();

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plot =getIntent2.getExtras().getString("plot");
                slotText(slot1.getText().toString(),plot);

            }
        });
        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plot =getIntent2.getExtras().getString("plot");
                slotText(slot2.getText().toString(),plot);
            }
        });


    }

     void slotText(String textSlot,String textplot) {
        Intent i = new Intent(Plot.this, Slot.class);
        String plot = getIntent2.getExtras().getString("plot1");

        if (textSlot == "slot1"&&textplot=="plot1") {
            i.putExtra("plot", plot);
            i.putExtra("slot", textSlot);
            startActivity(i);

        } else {
            i.putExtra("plot", plot);
            i.putExtra("slot", textSlot);
            startActivity(i);
        }

    }

}