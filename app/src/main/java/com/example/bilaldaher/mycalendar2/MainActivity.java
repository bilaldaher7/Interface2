package com.example.bilaldaher.mycalendar2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sign_in_button;
    private Button sign_up_button;
    //private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_in();
        sign_up();
    }

    public void sign_in(){
        sign_in_button = findViewById(R.id.button4);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignInPage = new Intent(MainActivity.this, sign_in_screen.class );
                startActivity(goToSignInPage);
            }
        });
    }

    public void sign_up(){
        sign_up_button = findViewById(R.id.button5);
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignUpPage = new Intent(MainActivity.this, sign_up_screen.class );
                startActivity(goToSignUpPage);
            }
        });
    }


}
