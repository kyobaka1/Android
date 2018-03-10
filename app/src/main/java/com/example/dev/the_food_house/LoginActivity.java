package com.example.dev.the_food_house;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {
    private ImageButton btnLoginWithPhone;
    private ImageButton btnLoginWithMail;
    private ImageButton btnLoginWithFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLoginWithPhone = (ImageButton) findViewById(R.id.btnPhone);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnLoginWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenChildActivity();
            }
            public void doOpenChildActivity()
            {
                Intent myIntent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

    }


}
