package edu.uga.cs.project4_geography_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class NewQuizActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private String countryXString, option1String, option2String, option3String;
    private TextView textView1;
    private RadioButton radio1, radio2, radio3;
    private RadioGroup radios;
    public Date quizDate;
    public Double quizResult;
    public List<Question> quizQuestions;
    public List<Country> quizCountries;
    private GestureDetectorCompat detector;
    private ArrayList<String> sampleContinents = new ArrayList<>(Arrays.asList("Asia", "Europe", "North America", "South America", "Africa", "Oceana"));
    private ArrayList<String> userAnswers = new ArrayList<>(6);
    private int numberCorrect=0;
    private int count=0;
    private int [] listIndex = new int[6];
    private localLists l = new localLists();

    private Context appContext;
    public GeoQuizData data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz);

        //get context for database classes
        appContext = getApplicationContext();
        //data = new GeoQuizData(appContext);

        //binding
        textView1 = findViewById( R.id.question_country );
        radio1 = findViewById( R.id.radioButton1 );
        radio2 = findViewById( R.id.radioButton2 );
        radio3 = findViewById( R.id.radioButton3 );
        radios = findViewById( R.id.radioGroup);
        detector = new GestureDetectorCompat(this, this);

        quizDate = new Date();                        //save the date for the current quiz

        quizCountries = new ArrayList<>(6);
        quizQuestions = new ArrayList<>(6);            //create array of Question objects for quiz


        //fill Questions and Countries arrays with blank objects
        for(int i=0; i<6; i++) {
            quizQuestions.add(new Question());
            quizCountries.add(new Country());
        }

        //fill in quizCountries array randomly
        for(int i=0; i<6; i++) {
            String foundCountry, foundContinent;
            listIndex[i] =  new Random().nextInt(195);
            foundCountry = l.listOfCountries.get(listIndex[i]);
            foundContinent = l.listOfContinents.get(listIndex[i]);
            quizCountries.get(i).setCountryName(foundCountry);
            quizCountries.get(i).setContinent(foundContinent);
        }

        //set correct answer and country values for each question
        for(int i=0; i<6; i++) {
            quizQuestions.get(i).setCountryX(quizCountries.get(i));
            quizQuestions.get(i).setCorrectAnswer(quizCountries.get(i).getContinent());
        }

        //fill in answer choices randomly without repeats
        for(int i=0; i<6; i++) {
            int num = new Random().nextInt(3);

            Collections.shuffle(sampleContinents);
            quizQuestions.get(i).setOption1(sampleContinents.get(0));
            quizQuestions.get(i).setOption2(sampleContinents.get(1));
            quizQuestions.get(i).setOption3(sampleContinents.get(2));

            //correct answer for option 1
            if(num == 0) {
                //option 1 does not already match correct answer
                if (quizQuestions.get(i).getOption1().equals(quizQuestions.get(i).getCorrectAnswer()) != true) {
                    quizQuestions.get(i).setOption1(quizQuestions.get(i).getCorrectAnswer());
                    quizQuestions.get(i).setOption1(sampleContinents.get(3));
                }
            }

            //correct answer for option 2
            else if(num == 1) {
                //option 2 does not already match correct answer
                if (quizQuestions.get(i).getOption2().equals(quizQuestions.get(i).getCorrectAnswer()) != true) {
                    quizQuestions.get(i).setOption2(quizQuestions.get(i).getCorrectAnswer());
                    quizQuestions.get(i).setOption2(sampleContinents.get(4));
                }
            }

            //correct answer for option 3
            else if(num == 2) {
                //option 3 does not already match correct answer
                if (quizQuestions.get(i).getOption3().equals(quizQuestions.get(i).getCorrectAnswer()) != true) {
                    quizQuestions.get(i).setOption3(quizQuestions.get(i).getCorrectAnswer());
                    quizQuestions.get(i).setOption3(sampleContinents.get(5));
                }
            }
        }









        /*--------------------------- TROUBLE WITH LOADING IN DATABASE DATA--------------------------------- */
         // GeoQuizData data;
        /* TROUBLE WITH DATABASE DATA */
        //data.open();
        //data.retrieveCountries();
        /*quizCountries.add(data.dataList.get(0));
        quizCountries.add(data.dataList.get(1));
        quizCountries.add(data.dataList.get(2));
        quizCountries.add(data.dataList.get(3));
        quizCountries.add(data.dataList.get(4));
        quizCountries.add(data.dataList.get(5));*/
        // Collections.copy(quizCountries, data.retrieveCountries());
        //  data.close();
        /*-----------------------------------------------------------------------------------------*/

        /*
        //load in question values
        for(int i=0; i<6; i++) {
           quizQuestions.get(i).setCountryX(quizCountries.get(i));
           quizQuestions.get(i).countryX.setCountryName(quizCountries.get(i).getCountryName());
           quizQuestions.get(i).countryX.setContinent(quizCountries.get(i).getContinent());
        }

        //populate question values into views on screen
        textView1.setText(quizQuestions.get(0).countryX.getCountryName());
        radio1.setText(quizQuestions.get(0).countryX.getContinent());
        */





        //set intial views for first question
         populateViews(0);



    }



    /*public Boolean checkAnswer() {

    }*/

    //function to populate views of ith question
    public void populateViews(int i) {
        textView1.setText(quizQuestions.get(i).countryX.getCountryName());
        radio1.setText(quizQuestions.get(i).getOption1());
        radio2.setText(quizQuestions.get(i).getOption2());
        radio3.setText(quizQuestions.get(i).getOption3());
    }

    public Double getQuizResult() {
        return this.quizResult;
    }

    public Date getQuizDate() {
        return this.quizDate;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    //detect left swipe;
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() > e2.getX()) {
            //radio1.setText("Swiped");

            if(count < 5) {
                if(radio1.isChecked()) {
                    userAnswers.add(count, quizQuestions.get(count).getOption1());

                    //user answer is correct
                    if (userAnswers.get(count).equals(quizQuestions.get(count).getCorrectAnswer())) {
                        numberCorrect++;
                    }
                    radios.clearCheck();
                    count++;
                    populateViews(count);
                }
                else if(radio2.isChecked()) {
                    userAnswers.add(count, quizQuestions.get(count).getOption2());

                    //user answer is correct
                    if (userAnswers.get(count).equals(quizQuestions.get(count).getCorrectAnswer())) {
                        numberCorrect++;
                    }
                    radios.clearCheck();
                    count++;
                    populateViews(count);
                }
                else if(radio3.isChecked()) {
                    userAnswers.add(count, quizQuestions.get(count).getOption3());

                    //user answer is correct
                    if (userAnswers.get(count).equals(quizQuestions.get(count).getCorrectAnswer())) {
                        numberCorrect++;
                    }
                    radios.clearCheck();
                    count++;
                    populateViews(count);

                }

            }

            //swipe on last question
            else if (count == 5) {
                quizResult = ((numberCorrect/6.0) * 100);
                quizResult = (Math.round(quizResult * 100.0) / 100.0);

                appContext = getApplicationContext();
                Intent intent = new Intent(appContext , EndResults.class);
                intent.putExtra("finalQScore", String.valueOf(quizResult));
               // intent.putExtra("qDate", quizDate);
                appContext.startActivity( intent );
            }

        }
            return true;
    }
}
