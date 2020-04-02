package edu.uga.cs.project4_geography_quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

/* This activity is for the splash screen that displays at launch. It sets listeners for the two buttons. */
public class MainActivity extends AppCompatActivity {

    private Button start_btn;
    private Button results_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = findViewById( R.id.splash_start_button );
        results_btn = findViewById( R.id.splash_results_button );

        start_btn.setOnClickListener( new StartButtonClickListener() );
        results_btn.setOnClickListener( new ResultsButtonClickListener() );
    }

    private class StartButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), NewQuizActivity.class);
            view.getContext().startActivity( intent );
        }
    }

    private class ResultsButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ViewResultsActivity.class);
            view.getContext().startActivity(intent);
        }
    }
}
