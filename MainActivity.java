package com.example.pg5;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fName, lName;
    RadioGroup genderGrp;
    RadioButton Male, Female;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAndNavigate();
            }
        });
    }

    private void registerAndNavigate() {
        SharedPreferences shardPref=getSharedPreferences("My_Pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=shardPref.edit();

        editor.putString("FName",fName.getText().toString());
        editor.putString("LName",lName.getText().toString());
        String radioValue="";

        switch (genderGrp.getCheckedRadioButtonId())
        {
            case R.id.radioButton1 : radioValue="Female";
                break;
            case R.id.radioButton2 : radioValue="Male";
                break;
            default : break;
        }

        editor.putString("Gender",radioValue);
        editor.apply();

        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);

    }

    private void initUI() {
        fName = findViewById(R.id.editText1);
        lName = findViewById(R.id.editText2);
        genderGrp = findViewById(R.id.radioGroup);
        Male = findViewById(R.id.radioButton1);
        Female = findViewById(R.id.radioButton2);
        b = findViewById(R.id.button);
    }
}