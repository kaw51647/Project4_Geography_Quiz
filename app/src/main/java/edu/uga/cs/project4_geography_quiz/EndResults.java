package edu.uga.cs.project4_geography_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndResults extends AppCompatActivity {

    private String finalScore, finalDate;
    private Button homeBtn;
    private TextView resultsDisplay, dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_results);

        resultsDisplay = findViewById( R.id.resultsView );
        //dateDisplay = findViewById( R.id.dateView );
        homeBtn = findViewById( R.id.returnHomeBtn);
        homeBtn.setOnClickListener( new HomeBtnClickListener() );

        finalScore = getIntent().getStringExtra("finalQScore");
        //finalDate = getIntent().getStringExtra("qDate");
        resultsDisplay.setText(finalScore);
        //dateDisplay.setText(finalDate);

    }

    private class HomeBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            view.getContext().startActivity( intent );
        }
    }
}
