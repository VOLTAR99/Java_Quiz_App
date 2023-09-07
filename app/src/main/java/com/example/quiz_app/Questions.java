package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questions extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;

    TextView currentScoreView;

    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;
    int score=0;
    int totalQuestion = QuestionsAnswers.question.length;

    int CurrentScore = 1;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        totalQuestionsTextView = findViewById(R.id.total_question);
        currentScoreView = findViewById(R.id.cnt_score);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);


        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionsAnswers.correctAnswers[currentQuestionIndex])){
                score++;
                currentScoreView.setText("Current Score: "+CurrentScore);
                CurrentScore++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{

            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }
    }
    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            int correctAnswers = score;
            int wrongAnswer = totalQuestion-score;
            int finalScore = score;
            Intent intent = new Intent(Questions.this, ResultScreen.class);
            intent.putExtra("CorrectAnswer",correctAnswers);
            intent.putExtra("WrongAnswer",wrongAnswer);
            intent.putExtra("TotalScore",finalScore);
            startActivity(intent);

    //    finishQuiz();
        return;
       }

        questionTextView.setText(QuestionsAnswers.question[currentQuestionIndex]);
        ansA.setText(QuestionsAnswers.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionsAnswers.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionsAnswers.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionsAnswers.choices[currentQuestionIndex][3]);

    }
    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}