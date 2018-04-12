package com.example.android.ezcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEvent extends AppCompatActivity {

    TextView username;
    ImageButton settings;
    EditText nomEvenement;
    DatePicker debutEvenementDate;
    TimePicker debutEvenementHeure;
    DatePicker finEvenementDate;
    TimePicker finEvenementHeure;
    com.skydoves.colorpickerview.ColorPickerView colorPickerView;
    Button addEvent;
    private DatabaseReference mDatabase;
    private static int eventID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        username = (TextView) findViewById(R.id.username);
        settings = (ImageButton) findViewById(R.id.settings);
        nomEvenement = (EditText) findViewById(R.id.eventName);
        debutEvenementDate = (DatePicker) findViewById(R.id.dateDebut);
        debutEvenementHeure = (TimePicker) findViewById(R.id.heureDebut);
        finEvenementDate = (DatePicker) findViewById(R.id.dateFin);
        finEvenementHeure = (TimePicker) findViewById(R.id.heureFin);
        colorPickerView = (com.skydoves.colorpickerview.ColorPickerView) findViewById(R.id.colorPickerView);
        addEvent = (Button) findViewById(R.id.addEvent);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = nomEvenement.getText().toString().trim();
                int startYear = debutEvenementDate.getYear();
                int startMonth = debutEvenementDate.getMonth();
                int startDayOfMonth = debutEvenementDate.getDayOfMonth();
                int startHr = debutEvenementHeure.getHour();
                int startMin = debutEvenementHeure.getMinute();
                int endYear = finEvenementDate.getYear();
                int endMonth = finEvenementDate.getMonth();
                int endDayOfMonth = finEvenementDate.getDayOfMonth();
                int endHr = finEvenementHeure.getHour();
                int endMin = finEvenementHeure.getMinute();
                String color = colorPickerView.getColorHtml();
                mDatabase.child("Event/"+eventID+"/eventName").setValue(eventName);
                mDatabase.child("Event/"+eventID+"/start_year").setValue(startYear);
                mDatabase.child("Event/"+eventID+"/start_month").setValue(startMonth);
                mDatabase.child("Event/"+eventID+"/start_dayOfMonth").setValue(startDayOfMonth);
                mDatabase.child("Event/"+eventID+"/start_hour").setValue(startHr);
                mDatabase.child("Event/"+eventID+"/start_minute").setValue(startMin);
                mDatabase.child("Event/"+eventID+"/end_year").setValue(endYear);
                mDatabase.child("Event/"+eventID+"/end_month").setValue(endMonth);
                mDatabase.child("Event/"+eventID+"/end_dayOfMonth").setValue(endDayOfMonth);
                mDatabase.child("Event/"+eventID+"/end_hour").setValue(endHr);
                mDatabase.child("Event/"+eventID+"/end_minute").setValue(endMin);
                mDatabase.child("Event/"+eventID+"/color").setValue(color);
                eventID++;


            }
        });
    }
}
