package com.example.swath.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    TextView tv, tv1;

    ArrayAdapter<String>adapter;


ArrayList<String>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



       tv=(TextView)findViewById(R.id.textView);
       tv1=(TextView)findViewById(R.id.textView2);

       tv.setText("Contact:" +getIntent().getStringExtra("number"));
        tv1.setText("Message:"+getIntent().getStringExtra("text"));













    }
}
