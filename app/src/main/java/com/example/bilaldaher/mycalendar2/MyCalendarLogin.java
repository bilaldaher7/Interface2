package com.example.bilaldaher.mycalendar2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MyCalendarLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText Email;
    private EditText Password;
    private Button SignIn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){

        }


        Email = (EditText) findViewById(R.id.editText6);
        Password = (EditText) findViewById(R.id.editText7);
        progressDialog = new ProgressDialog(this);
        SignIn = (Button) findViewById(R.id.button7);
        SignIn.setOnClickListener(this);



    }

    private void userLogin(){
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
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

        progressDialog.setMessage("Please Wait!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(), Calendrier.class));
                } else {
                    Toast.makeText(MyCalendarLogin.this, "Please enter a valid username or password", Toast.LENGTH_LONG).show();

                }




            }
        });

    }



    @Override
    public void onClick(View view) {
        if(view == SignIn){
            userLogin();
        }

    }
}
