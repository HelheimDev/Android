package com.example.canberk.calendar;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionHelper {

    ///////////if not on heroku use these//////////////////
    //String ip = "178.233.175.126";                     //
    //String classs = "net.sourceforge.jtds.jdbc.Driver";//
    //String db = "calendar_development";                //
    //String un = "vinerra";                             //
    //String password = "2121145";                       //
    ///////////////////////////////////////////////////////

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName("org.postgresql.Driver");

            ///////////////////////////////////////////////////////////////////////////////////////////////
            //ConnURL = "jdbc:postgres://" + "178.233.175.126" + "/"                                     //
             //      + /*"databaseName=" +*/ "calendar_development" + "?user=" + "vinerra" + "&password="//
             //      + "2121145";                                                                        //
            //conn = DriverManager.getConnection(ConnURL);                                               //
            ///////////////////////////////////////////////////////////////////////////////////////////////

            String url = "jdbc:postgresql://ec2-54-204-18-53.compute-1.amazonaws.com:5432/ddc4387hudcktk?sslmode=require&user=nffvtepvvfocpm&password=947bfbf162b87ef05def372399b0cda8312f065510bd0c0683db97b3e11f0c54";

            //////////////////////////////////////////////////////////////////////////////////////////////////
            //String url="jdbc:postgresql://[178:233:175:126]:5432/calendar_development?user=vinerra&password=2121145";//
            //////////////////////////////////////////////////////////////////////////////////////////////////

            conn = DriverManager.getConnection(url);

        } catch (SQLException se) {
            Log.e("ERRO1", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO2", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO3", e.getMessage());
        }

        return conn;
    }
}
