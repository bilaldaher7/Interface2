package com.example.bilaldaher.mycalendar2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class sign_up_screen extends AppCompatActivity {

    Button Sign_up_app_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        app_sign_up();
    }

    public void app_sign_up(){
        Sign_up_app_btn = findViewById(R.id.sign_up_app_button);
        Sign_up_app_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAppSignUPage = new Intent(sign_up_screen.this, MyCalendarSignUp.class );
                startActivity(goToAppSignUPage);
            }
        });
    }
}
