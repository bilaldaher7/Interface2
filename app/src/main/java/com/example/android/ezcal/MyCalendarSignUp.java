package com.example.android.ezcal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


public class MyCalendarSignUp extends AppCompatActivity implements View.OnClickListener {

    private Button create_account;
    private EditText emailText;
    private EditText passwordText;
    private FirebaseAuth mAuth;
    private FirebaseAnalytics mFirebaseAnalytics;
    private ProgressDialog progressDialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_calendar_sign_up);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle test = new Bundle();
        test.putString(FirebaseAnalytics.Param.METHOD,"email");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, test);

        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(), Calendrier.class));
        }




        progressDialog = new ProgressDialog(this);
        create_account = (Button) findViewById(R.id.create_account_btn);
        emailText = (EditText) findViewById(R.id.editText6);
        passwordText = (EditText) findViewById(R.id.editText7);
        create_account.setOnClickListener(this);
        emailText.setOnClickListener(this);
        passwordText.setOnClickListener(this);


    }




    private void registerUser(){
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        progressDialog.setMessage("Please Wait!");
        progressDialog.show();

        if (TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter a valid email adress", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }





        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    //user successfully registered
                    finish();
                    startActivity(new Intent(getApplicationContext(), Calendrier.class));
                    Toast.makeText(MyCalendarSignUp.this, "Success! You are now Registered!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MyCalendarSignUp.this, "Oh no! We could not register you...Please try again!", Toast.LENGTH_SHORT).show();

                    try {
                        throw task.getException();
                    } catch(Exception e) {
                        Log.e("EXCEPTION PAS FINE", e.getMessage());
                    }

                }
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void onClick(View view){
        if(view == create_account){
            registerUser();


        }

    }






}
