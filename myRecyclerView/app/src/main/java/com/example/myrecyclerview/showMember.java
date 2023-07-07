package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        Intent intent = getIntent();
        SingerItem item = (SingerItem) intent.getSerializableExtra("item");
        TextView textView1 = (TextView) findViewById(R.id.textView4);
        TextView textView2 = (TextView) findViewById(R.id.textView5);
        textView1.setText(item.getName());
        textView2.setText(item.getMobile());
    }
}