package com.example.user.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup1,radioGroup2;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;

    boolean[] jawaban = new boolean[]{
            false,
            false,
            false
    };

    int jawabanBenar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup2 = (RadioGroup)findViewById(R.id.radio_group2);
        checkBox1 = (CheckBox)findViewById(R.id.check1);
        checkBox2 = (CheckBox)findViewById(R.id.check2);
        checkBox3 = (CheckBox)findViewById(R.id.check3);
        checkBox4 = (CheckBox)findViewById(R.id.check4);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.benar1){
                    jawaban[0] = true;
                }else{
                    jawaban[0] = false;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Toast.makeText(MainActivity.this, "indeks ke "+i, Toast.LENGTH_SHORT).show();
                if (i == R.id.benar2){
                    jawaban[1] = true;
                }else{
                    jawaban[1] = false;
                }
            }
        });






    }

    public void onButtonClicked(View view) {
        if ((checkBox1.isChecked()) && (checkBox2.isChecked()) && (checkBox4.isChecked()) && (!checkBox3.isChecked())){
            jawaban[2] = true;
        }else{
            jawaban[2] = false;
        }

        for (int i = 0; i<3; i++){
            Log.d("cekJawaban", "onButtonClicked: "+jawaban[i]);
            if (jawaban[i]){
                jawabanBenar = jawabanBenar +1;
            }
        }

        float hasil =0;
        hasil = jawabanBenar*100/3;

        Toast.makeText(this, String.valueOf(hasil), Toast.LENGTH_SHORT).show();
        jawabanBenar = 0;
    }
}
