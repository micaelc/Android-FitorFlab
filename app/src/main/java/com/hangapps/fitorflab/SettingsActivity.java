package com.hangapps.fitorflab;

import android.app.Notification;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = "SettingsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final CheckBox nightModeCb = (CheckBox)findViewById(R.id.nightModeChk);
        nightModeCb.setChecked(getNightMode());

        nightModeCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb = (CheckBox) view;
                if(cb.isChecked()){
                    Log.i(TAG, "Night Mode Activated");
                    setNightMode(true);
                } else {
                    Log.i(TAG, "Night Mode Deactivated");
                    setNightMode(false);
                }
            }
        });

    }

    private Boolean getNightMode() {
        SharedPreferences prefs = getSharedPreferences(MainActivity.APP_PREFERENCES, MODE_PRIVATE);
        boolean nightMode = prefs.getBoolean("nightMode", false);
        return nightMode;
    }

    private void setNightMode(Boolean nightMode) {
        SharedPreferences prefs = getSharedPreferences(MainActivity.APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(MainActivity.PREF_NIGHT_MODE, nightMode);
        editor.commit();
    }
}
