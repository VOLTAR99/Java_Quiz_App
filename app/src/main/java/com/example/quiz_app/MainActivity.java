package com.example.quiz_app;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Btn1;
    Button Btn2;

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Btn1 = findViewById(R.id.btn_start);
         Btn2=findViewById(R.id.btn_about);
         name=findViewById(R.id.name_txt);


        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Lets go...."+ name.getText(), Toast.LENGTH_LONG).show();
                questionActivity();
            }
        });

         Btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 nextactivity();
             }
         });

    }

    private void nextactivity() {
        Intent intent=new Intent(this, About.class);
        startActivity(intent);
    }

    private void questionActivity() {
        Intent intent=new Intent(this, Questions.class);
        startActivity(intent);
    }
}