package com.example.study1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DestroyTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LifeCycleTest.class);
        finish();
        startActivity(intent);
    }
}