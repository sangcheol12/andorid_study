package com.example.samplelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button constButton;
    Button linearButton;
    Button relativeButton;
    Button intentButton;
    Button widgetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constButton = findViewById(R.id.const_button);
        linearButton = findViewById(R.id.linear_button);
        relativeButton = findViewById(R.id.relative_button);
        intentButton = findViewById(R.id.intent_button);
        widgetButton = findViewById(R.id.widjetButton);

        constButton.setOnClickListener(this);
        linearButton.setOnClickListener(this);
        relativeButton.setOnClickListener(this);
        intentButton.setOnClickListener(this);
        widgetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v == constButton) {
            intent = new Intent(getApplicationContext(),Constraint.class);
        } else if (v == linearButton) {
            intent = new Intent(getApplicationContext(),Linear.class);
        } else if (v == relativeButton) {
            intent = new Intent(getApplicationContext(),Relative.class);
        } else if (v == intentButton) {
            intent = new Intent(getApplicationContext(),IntentTest.class);
            intent.putExtra("myKey","사인페 만점 받아와요");
        } else if (v == widgetButton) {
            intent = new Intent(getApplicationContext(),widgetTester.class);
        }
        startActivity(intent);
    }
}