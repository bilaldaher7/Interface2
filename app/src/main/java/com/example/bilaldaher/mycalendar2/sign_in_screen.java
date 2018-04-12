package com.example.bilaldaher.mycalendar2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sign_in_screen extends AppCompatActivity {




    Button Sign_in_app_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        app_sign_in();
    }

    public void app_sign_in(){
        Sign_in_app_btn = findViewById(R.id.sign_in_app_btn);
        Sign_in_app_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAppSignInPage = new Intent(sign_in_screen.this, MyCalendarLogin.class );
                startActivity(goToAppSignInPage);
            }
        });
    }

}
