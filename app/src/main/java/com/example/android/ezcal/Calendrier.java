package com.example.android.ezcal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calendrier extends Activity {

    private Button Add_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);
        add_event();


    }


    public void add_event(){
        Add_event = findViewById(R.id.ajouterEvenement);
        Add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddEventPage = new Intent(Calendrier.this, Evenements.class );
                startActivity(goToAddEventPage);
            }
        });
    }
}
