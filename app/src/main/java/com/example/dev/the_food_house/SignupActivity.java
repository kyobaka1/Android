package com.example.dev.the_food_house;


import com.example.dev.the_food_house.model.user;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignupActivity extends AppCompatActivity {

    user _user;
    EditText input_user_name, input_password, input_comfirm_password;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        _user = new user(false);
        input_user_name = (EditText)findViewById(R.id.input_user_name);
        input_password = (EditText)findViewById(R.id.input_password);
        input_comfirm_password = (EditText)findViewById(R.id.input_password_comfirm);
        btn_signup = (Button)findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _user.setUserName(input_user_name.getText().toString());
                _user.setPassword(input_user_name.getText().toString());
                _user.setPassword_comfim(input_comfirm_password.getText().toString());

            }
        });
    }
}
