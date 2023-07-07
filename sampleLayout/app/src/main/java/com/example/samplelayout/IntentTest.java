package com.example.samplelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentTest extends AppCompatActivity {
    Intent myIntent;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        myIntent = getIntent();
        String valueStr = myIntent.getStringExtra("myKey");
        textView = findViewById(R.id.intent_value);
        textView.setText(valueStr);
    }
}