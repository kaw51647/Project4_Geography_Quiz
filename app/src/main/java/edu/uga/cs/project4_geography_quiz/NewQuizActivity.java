package edu.uga.cs.project4_geography_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewQuizActivity extends AppCompatActivity {

    private String countryXString, option1String, option2String, option3String;
    private TextView textView1;
    private RadioButton radio1, radio2, radio3;
    public Date quizDate;
    public Float quizResult;
    public List<Question> quizQuestions;
    public List<Country> quizCountries;

    //public GeoQuizData data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz);


        //view binding
        textView1 = findViewById( R.id.question_country );
        radio1 = findViewById( R.id.radioButton1 );
        radio2 = findViewById( R.id.radioButton2 );
        radio3 = findViewById( R.id.radioButton3 );


        quizDate = new Date();                        //save the date for the current quiz

        quizQuestions = new ArrayList<>();            //create array of Question objects for quiz
        quizCountries = new ArrayList<>(6);



        /*--------------------------- TROUBLE WITH DATABASE DATA--------------------------------- */
        GeoQuizData data;
        /* TROUBLE WITH DATABASE DATA */
        //data.open();
        //quizCountries = data.retrieveCountries();
        //data.close();*/
        /*-----------------------------------------------------------------------------------------*/



        

        //load in String values

        //quizQuestions.add(new Question("1", "2", "3", quizCountries.get(i)));

       /* for(int i=0; i<6; i++) {
            quizQuestions.add(new Question("1", "2", "3", quizCountries.get(i)));
        }

        */

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



        Country c1 = new Country("France", "Europe");

        Question q1 = new Question("Europe", "GEorgia", "fff", c1);
       // q1.countryX.setCountryName("France");
        //q1.countryX.setContinent("Europe");


         textView1.setText(q1.countryX.getCountryName());
         radio1.setText(q1.countryX.getContinent());


        //quizQuestions.get(0).countryX.setCountryName("France");
/*
        for(int i=0; i<6; i++) {
            quizQuestions.get(i).countryX.setCountryName("France");
            quizQuestions.get(i).countryX.setContinent("Europe");
        }

        //populate question values into views on screen
        textView1.setText(quizQuestions.get(0).countryX.getCountryName());
        radio1.setText(quizQuestions.get(0).countryX.getContinent());
*/


    }

    /*public void populateCountries() {
        //GeoQuizData data
        data.open();
        data.retrieveCountries();

    }*/


}
