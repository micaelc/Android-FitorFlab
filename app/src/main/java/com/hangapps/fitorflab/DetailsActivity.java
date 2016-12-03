package com.hangapps.fitorflab;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        LinearLayout mainBg = (LinearLayout)findViewById(R.id.mainBg);
        TextView exerciseText = (TextView)findViewById(R.id.exerciseTitle);
        ImageView exerciseImage = (ImageView)findViewById(R.id.exerciseImage);

        String exerciseTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);

        exerciseText.setText(exerciseTitle);

        if(exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_WEIGHTS)){
            mainBg.setBackgroundColor(Color.parseColor("#2ca5f5"));
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
        } else if(exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_YOGA)){
            mainBg.setBackgroundColor(Color.parseColor("#916bcd"));
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
        } else {
            mainBg.setBackgroundColor(Color.parseColor("#52ad56"));
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
        }


    }
}
