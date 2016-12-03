package com.hangapps.fitorflab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXERCISE_WEIGHTS = "Weight Lifting";
    public static final String EXERCISE_YOGA = "Yoga";
    public static final String EXERCISE_CARDIO = "Cardio";

    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String APP_PREFERENCES = "app.preferences";
    public static final String PREF_NIGHT_MODE = "nightMode";

    public static final String TAG = "MainActivity";

    public Boolean nightMode = false;

    RelativeLayout weightBtn;
    RelativeLayout yogaBtn;
    RelativeLayout cardioBtn;
    ImageButton settingsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildLayout();
    }

    @Override
    protected void onResume(){
        super.onResume();
        buildLayout();
    }

    private void loadDetailActivity(String exerciseTitle) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, exerciseTitle);
        intent.putExtra(MainActivity.PREF_NIGHT_MODE, nightMode);
        startActivity(intent);
    }

    private Boolean getNightMode() {
        SharedPreferences prefs = getSharedPreferences(MainActivity.APP_PREFERENCES, MODE_PRIVATE);
        boolean nightMode = prefs.getBoolean(MainActivity.PREF_NIGHT_MODE, false);
        return nightMode;
    }

    private void buildLayout(){
        setContentView(R.layout.activity_main);
        nightMode = getNightMode();

        weightBtn = (RelativeLayout) findViewById(R.id.weightBtn);
        yogaBtn = (RelativeLayout) findViewById(R.id.yogaBtn);
        cardioBtn = (RelativeLayout) findViewById(R.id.cardioBtn);
        settingsBtn = (ImageButton)findViewById(R.id.settingsBtn);

        if (nightMode) {
            weightBtn.setBackgroundTintList(getResources().getColorStateList(R.color.colorDarkGrey, getApplicationContext().getTheme()));
            yogaBtn.setBackgroundTintList(getResources().getColorStateList(R.color.colorDarkGrey, getApplicationContext().getTheme()));
            cardioBtn.setBackgroundTintList(getResources().getColorStateList(R.color.colorDarkGrey, getApplicationContext().getTheme()));
        }
        weightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_WEIGHTS);
            }
        });
        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_YOGA);
            }
        });
        cardioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_CARDIO);
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
