package com.example.canberk.calendar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Integer Day=0;
    private Integer Month=0;
    private Integer Year=0;
    private Integer Hour=0;
    private Integer Minute=0;
    private TextView mTextDate;
    private String format = "";
    private TextView mTextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        /////////////////////////////////////////////////////////////////////
        int day = intent.getIntExtra("Day",0);
        int month = intent.getIntExtra("Month",0);
        int year = intent.getIntExtra("Year",0);
        int hour = intent.getIntExtra("Hour",0);
        int minute = intent.getIntExtra("Minute",0);
        format = intent.getStringExtra("Format");
        Day = day;
        Month = month;
        Year = year;
        if (format.equalsIgnoreCase("am")){
            Hour = hour;
        }
        else{
            Hour = hour;
        }
        Minute = minute;

        mTextDate = (TextView) findViewById(R.id.textView4);
        mTextTime = (TextView) findViewById(R.id.textView5);
        mTextTime.setText(Hour+":"+Minute);
        mTextDate.setText(Day+"-"+Month+"-"+Year);
        /////////////////////////////////////////////////////////////////////
    /*
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_dashboard:
                        Intent intent1 = new Intent(Main3Activity.this,Main2Activity.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_notifications:
                        Intent intent2 = new Intent(Main3Activity.this,Main4Activity.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_home:
                        Intent intent3 = new Intent(Main3Activity.this,Main.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });*/

    }


}
