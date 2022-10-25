package com.example.pg5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button b2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUI();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData();
            }
        });

    }

    private void fetchData() {
        SharedPreferences sharedPref=getSharedPreferences("My_Pref",MODE_PRIVATE);
        tv1.setText("First Name : "+sharedPref.getString("FName","")+"\nLast Name : "+sharedPref.getString("LName","")+"\nGender : "+sharedPref.getString("Gender",""));

    }

    private void initUI() {
        b2=findViewById(R.id.button2);
        tv1=findViewById(R.id.textView2);
    }
}