package com.example.study1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button smsBtn;
    private Button lifeCycleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsBtn=(Button) findViewById(R.id.smsBtn);
        lifeCycleBtn=(Button) findViewById(R.id.lifeCycleBtn);

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SmsActivity.class);
                finish();
                startActivity(intent);
            }
        });
        lifeCycleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LifeCycleTest.class);
                finish();
                startActivity(intent);

            }
        });
    }
}