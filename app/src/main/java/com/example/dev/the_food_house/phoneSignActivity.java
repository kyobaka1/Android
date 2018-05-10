package com.example.dev.the_food_house;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dev.the_food_house.model.user;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class phoneSignActivity extends AppCompatActivity {

    Button Signin;
    Button Signup;
    EditText input_phone,input_password;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_sign);
        Signin = (Button)findViewById(R.id.btn_signin);
        Signup = (Button)findViewById(R.id.btn_signup);
        input_phone = (EditText)findViewById(R.id.input_phone);
        input_password = (EditText)findViewById(R.id.input_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(phoneSignActivity.this, SignupActivity.class);
                startActivity(myIntent);
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check user
                user _user = new user(false);
                String a[]= _user.LoginWithPhone(input_phone.getText().toString(),input_password.getText().toString());
                Toast.makeText(phoneSignActivity.this,a[0],Toast.LENGTH_SHORT).show();
                if (a[1]=="true"){
                    Intent myIntent=new Intent(phoneSignActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
            }
        });


    }
}
