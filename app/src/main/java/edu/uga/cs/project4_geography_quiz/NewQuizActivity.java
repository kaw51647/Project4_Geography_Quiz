package edu.uga.cs.project4_geography_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.Date;

public class NewQuizActivity extends AppCompatActivity {

    private String countryXString, option1String, option2String, option3String;
    private TextView textView1;
    private RadioButton radio1, radio2, radio3;
    public Date quizDate;
    public Question [] quizQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz);

        quizDate = new Date();                      //save the date for the current quiz
        quizQuestions = new Question[6];            //create array of Question objects for quiz


        //load in String values from database table

        //load in question values from database
        for(int i=0; i<6; i++) {
            quizQuestions[i].setOption1(option1String);
        }

    }


}
