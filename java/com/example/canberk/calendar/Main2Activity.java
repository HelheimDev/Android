package com.example.canberk.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main2Activity extends Activity {

    private Integer Day=0;
    private Integer Month=0;
    private Integer Year=0;
    private Integer Hour=0;
    private Integer Minute=0;
    private TextView mTextDate;
    private String format = "";
    private TextView mTextTime;
    private TextView mTextName;
    private TextView mTextSubject;
    private String NAME="";
    private String SUBJECT="";

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
        String name = intent.getStringExtra("Name");
        String subj = intent.getStringExtra("Subject");

        Day = day;
        Month = month;
        Year = year;
        Hour = hour;
        Minute = minute;
        NAME = name;
        SUBJECT = subj;

        mTextName = (TextView) findViewById(R.id.textView);
        mTextSubject = (TextView) findViewById(R.id.textView3);
        mTextDate = (TextView) findViewById(R.id.textView6);
        mTextTime = (TextView) findViewById(R.id.textView7);
        //mTextName.setText("Name: "+ name);
        //mTextSubject.setText("Subject: "+subj);
        mTextTime.setText(Hour+":"+Minute);
        mTextDate.setText(Day+"-"+Month+"-"+Year);
        /////////////////////////////////////////////////////////////////////

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_dashboard:
                        Intent intent1 = new Intent(Main2Activity.this,notify.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_notifications:
                        Intent intent2 = new Intent(Main2Activity.this,notify.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_home:
                        Intent intent3 = new Intent(Main2Activity.this,Main.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });

    }
}
