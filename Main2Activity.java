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

    private static final String TAG = "ListDataActivity";
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    ConnectionHelper connectionHelper;
    EditText edtuserid,edtpass;
    Button btnlogin;
    ProgressBar pbbar;

    private void populateListView(){
        //mDatabaseHelper.

        Log.d(TAG,"populateListView: Displaying Data");
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));

        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);
    }
    public class DoLogin extends AsyncTask<String,String,String>
    {
        String z = "";
        Boolean isSuccess = false;


        String userid = "vinerra";
        String password = "2121145";


        @Override
        protected void onPreExecute() {
            //pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            //pbbar.setVisibility(View.GONE);
            Toast.makeText(Main2Activity.this,r,Toast.LENGTH_SHORT).show();

            if(isSuccess) {
                Toast.makeText(Main2Activity.this,r,Toast.LENGTH_SHORT).show();
                populateListView();
            }


        }

        @Override
        protected String doInBackground(String... params) {
            if(userid.trim().equals("")|| password.trim().equals(""))
                z = "Please enter User Id and Password";
            else
            {
                try {
                    Connection con = connectionHelper.CONN();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {
                        String query = "select * from meetings ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        ResultSetMetaData rsmd = rs.getMetaData();


                        if(rs.next())
                        {

                            z = "Login successfull";
                            isSuccess=true;
                        }
                        else
                        {
                            z = "Invalid Credentials";
                            isSuccess = false;
                        }

                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "Exceptions";
                    Log.e("Exception",ex.getMessage());
                    ex.getMessage();
                }
            }
            return z;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      /*  btnlogin.findViewById(R.id.btn_Login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoLogin  doLogin = new DoLogin();
                doLogin.execute("");

            }
        });*/


        //DoLogin  doLogin = new DoLogin();
        //doLogin.execute("");

        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);





        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_dashboard:
                        Intent intent1 = new Intent(Main2Activity.this,Main2Activity.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_notifications:
                        Intent intent2 = new Intent(Main2Activity.this,Main2Activity.class);
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
    public void sendMessage(View view) {
        DoLogin  doLogin = new DoLogin();
        doLogin.execute("");
    }
}
