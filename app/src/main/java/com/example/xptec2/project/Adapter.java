package com.example.xptec2.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by XP Tec2 on 28/04/2016.
 */
public class Adapter extends BaseAdapter {
    private ArrayList<String> list ;
    private Context context;
    public Adapter(ArrayList<String> list, Context context){
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater x=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View r=x.inflate(R.layout.custom,null);

        Button deleteBtn = (Button)r.findViewById(R.id.add);
        deleteBtn.setText(list.get(position));
        Button addBtn = (Button)r.findViewById(R.id.sub);
        addBtn.setText(list.get(position));

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              //  do something
                parent.findViewById(R.id.sub).setVisibility(View.VISIBLE);
               // list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                parent.findViewById(R.id.add).setVisibility(View.VISIBLE);
                notifyDataSetChanged();
            }
        });

        return r;

    }
}
