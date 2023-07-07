package com.example.samplelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class widgetTester extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText editTextEmail;
    EditText editTextPwd;
    Switch aSwitch;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_tester);
        textView = findViewById(R.id.textView_test);
        button = findViewById(R.id.button_test);
        editTextEmail = findViewById(R.id.editText_test);
        editTextPwd = findViewById(R.id.editPassword_test);
        aSwitch = findViewById(R.id.switch_test);
        imageView = findViewById(R.id.imageView_test);

        textView.setText("교수님 나빠요!");
        /*SharedPreferences pref = getSharedPreferences("pref", 0);
        String myText = pref.getString("email", "");
        editTextEmail.setText(myText);*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saveMyText();
                Toast.makeText(getApplicationContext(),"이메일일 저장되었음",Toast.LENGTH_SHORT).show();
            }
        });

        /*
            아래 줄이 warning이 발생하는 이유 -> 이미지뷰에서 터치 이벤트를 적용하는게 좋지 않은 코드임
            ClickableImageView extends ImageView 이런식으로 커스텀 이미지뷰를 직접 만드는 작업을 하는것이 옳바른 코드
        */
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        String id = editTextEmail.getText().toString();
                        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        // 드래그 중일 때 실행되는 코드
                        float x = event.getX(); // X 좌표 가져오기
                        float y = event.getY(); // Y 좌표 가져오기
                        String message = "X: " + x + ", Y: " + y;
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        return true;
                    case MotionEvent.ACTION_UP:
                        String pwd = editTextPwd.getText().toString();
                        Toast.makeText(getApplicationContext(), pwd, Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }

    /*public void saveMyText() {
        SharedPreferences pref = getSharedPreferences("pref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("email", editTextEmail.getText().toString());
        editor.commit();
    }*/
}