package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    private TextView txt1,txt2,txt3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        txt1 = findViewById(R.id.crt_ans);
        txt2 = findViewById(R.id.wrg_ans);
        txt3 = findViewById(R.id.final_score);
        btn= findViewById(R.id.btn_restart);

        int correctAnswers = getIntent().getIntExtra("CorrectAnswer",0);
        int wrongAnswer = getIntent().getIntExtra("WrongAnswer",0);
        int finalScore = getIntent().getIntExtra("TotalScore",0);

        txt1.setText("Correct Answer :"+" "+correctAnswers);
        txt2.setText("Wrong Answer :"+" "+wrongAnswer);
        txt3.setText("Final Score :"+" "+finalScore);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextactivity();
            }
        });
    }
    private void nextactivity() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}