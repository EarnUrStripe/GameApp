package com.example.tonyt.gameapp;

        import android.app.Activity;
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;


public class HighScore extends Activity {

    public final static String COUNTER_VALUE = "com.example.sharedprefs.counterval";

    TextView recalledValue;
    TextView currentValue;

    int counterVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        SharedPreferences hiScore = getApplicationContext().getSharedPreferences("com.example.tonyt.gameapp",0 );
        recalledValue = (TextView) findViewById(R.id.preferenceTextView);
        currentValue = (TextView) findViewById(R.id.valueTextView);

    }
}