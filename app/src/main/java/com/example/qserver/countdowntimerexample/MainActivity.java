package com.example.qserver.countdowntimerexample;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected EditText mTextField;

    //Declare a member variable of my class derived from the CountDownTimer super class
    protected CustomTimer myTimer;

    @Override
    protected void onCreate( Bundle bundle )
    {

        super.onCreate( bundle );
        setContentView( R.layout.activity_main );
        mTextField = ( EditText ) findViewById( R.id.my_activity_layout_text_field );

        //Initialize myTimer with its' overloaded constructor
        myTimer = new CustomTimer( 30000, 1000 );

        myTimer.start( );

    } //end of onCreate method

    //Declare a new inner child class of parent class CountDownTimer
    public class CustomTimer extends CountDownTimer
    {

        //Overloaded constructor
        public CustomTimer(long millisInFuture, long countDownInterval)
        {

            super( millisInFuture, countDownInterval );

        }

        //override onTick method
        @Override
        public void onTick(long millisUntilFinished)
        {

            mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);

        }

        //override onFinish method
        @Override
        public void onFinish()
        {

            mTextField.setText("done!");

        }

    } //end of CustomTimer class

}
