package com.example.canberk.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Main4Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    private String format = "";
    private Integer Day;
    private Integer Month;
    private Integer Year;
    private TextView mTextDate;
   //private Integer HH=0;
    //private Integer MM=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent=getIntent();
        /////////////////////////////////////////////////////////////////////
        int day = intent.getIntExtra("Day",0);
        int month = intent.getIntExtra("Month",0);
        int year = intent.getIntExtra("Year",0);
        Day = day;
        Month = month;
        Year = year;
        mTextDate = (TextView) findViewById(R.id.textView2);
        /////////////////////////////////////////////////////////////////////
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_dashboard:
                        Intent intent1 = new Intent(Main4Activity.this,Main2Activity.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_notifications:
                        Intent intent2 = new Intent(Main4Activity.this,Main4Activity.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_home:
                        Intent intent3 = new Intent(Main4Activity.this,Main.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });

    }

    public void setTime(View view) {
        int hour = timePicker1.getCurrentHour();
        int min = timePicker1.getCurrentMinute();
        //showTime(hour, min);
        Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
        intent.putExtra("Day",Day);
        intent.putExtra("Month",Month);
        intent.putExtra("Year",Year);
        intent.putExtra("Hour",hour);
        intent.putExtra("Minute",min);
        intent.putExtra("Format",format);
        startActivity(intent);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        time.setText(new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format));
        showDate(Day, Month, Year);
    }
    public void showDate(int d,int m,int y){
        mTextDate.setText(d+"-"+m+"-"+y);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /*public void sendMessage(View view) {
        Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
        intent.putExtra("Day",Day);
        intent.putExtra("Month",Month);
        intent.putExtra("Year",Year);
        intent.putExtra("Hour",HH);
        intent.putExtra("Minute",MM);
        intent.putExtra("Format",format);
        startActivity(intent);
    }*/
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
