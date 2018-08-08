package com.example.canberk.calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kd.dynamic.calendar.generator.ImageGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Calendar;



public class Main extends AppCompatActivity{

    EditText mDateEditText;
    Calendar mCurrentDate;
    Bitmap mGeneratedDateIcon;
    ImageGenerator mImageGenerator;
    ImageView mDisplayGeneratedImage;



    private TextView mTextMessage;
    private int MD = 0;
    private int MM = 0;
    private int MY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageGenerator = new ImageGenerator(this);
        mDateEditText = (EditText) findViewById(R.id.txtDateEntered);
        mDisplayGeneratedImage = (ImageView) findViewById(R.id.imageGen);

        mImageGenerator.setIconSize(50,50);
        mImageGenerator.setDateSize(30);
        mImageGenerator.setMonthSize(10);

        mImageGenerator.setDatePosition(42);
        mImageGenerator.setMonthPosition(14);

        mImageGenerator.setDateColor(Color.parseColor("#3c6eaf"));
        mImageGenerator.setMonthColor(Color.WHITE);

        mImageGenerator.setStorageToSDCard(true);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_dashboard:
                        Intent intent1 = new Intent(Main.this,notify.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_notifications:
                        Intent intent2 = new Intent(Main.this,notify.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_home:
                        Intent intent3 = new Intent(Main.this,Main.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });

        mDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentDate = Calendar.getInstance();
                int year = mCurrentDate.get(Calendar.YEAR);
                int month = mCurrentDate.get(Calendar.MONTH);
                int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(Main.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        mDateEditText.setText(selectedDay+"-"+(selectedMonth+1)+"-"+selectedYear);
                        MD = selectedDay;
                        MM = selectedMonth+1;
                        MY = selectedYear;
                        mCurrentDate.set(selectedYear,selectedMonth,selectedDay);
                        mGeneratedDateIcon = mImageGenerator.generateDateImage(mCurrentDate,R.drawable.calendar_blank_vector);
                        mDisplayGeneratedImage.setImageBitmap(mGeneratedDateIcon);
                    }
                }, year, month, day);
                mDatePicker.show();

            }
        });




    }
    public void sendMessage(View view) {
        Intent intent = new Intent(Main.this, Main4Activity.class);
        if((MM==MD)&&(MD==MY)&&(MM==0)){
            //print message
        }
        else{
            intent.putExtra("Day",MD);
            intent.putExtra("Month",MM);
            intent.putExtra("Year",MY);
            startActivity(intent);
        }
    }


    //public void buttonOnClick(){
     //   Button button = (Button) v;
       // startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    //}

}
