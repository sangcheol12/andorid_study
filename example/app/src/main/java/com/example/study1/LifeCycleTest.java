package com.example.study1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleTest extends AppCompatActivity {
    private Button destroyButton;
    private Button resumeButton;
    private Button restartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_test);
        Log.e("superdroid","onCreate()");
        destroyButton = (Button) findViewById(R.id.destroyButton);
        resumeButton = (Button) findViewById(R.id.resumeButton);
        restartButton = (Button) findViewById(R.id.restartButton);
        destroyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DestroyTest.class);
                finish();
                startActivity(intent);
            }
        });
        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResumeTest.class);
                startActivity(intent);
            }
        });
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RestartTest.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v("superdroid","onRestart()");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v("superdroid","onstart()");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("superdroid","onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("superdroid","onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("superdroid","onStop()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("superdroid","onDestroy()");
    }
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(intent);
    }
}