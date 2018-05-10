package com.example.dev.the_food_house;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
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

import com.example.dev.the_food_house.model.DBAdapter;
import com.example.dev.the_food_house.model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        final DatabaseReference session = database.getReference("session");

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
//                user _user = new user(false);
//                String a[]= _user.LoginWithPhone(input_phone.getText().toString(),input_password.getText().toString());
//                Toast.makeText(phoneSignActivity.this,a[0],Toast.LENGTH_SHORT).show();
//                if (a[1]=="true"){
//                    Intent myIntent=new Intent(phoneSignActivity.this, MainActivity.class);
//                    startActivity(myIntent);
//                }
                final user _user = new user(false);
                _user.setPassword(input_password.getText().toString());
                _user.setPhone(input_phone.getText().toString());

                //tham chiu den phone
                DatabaseReference mostafa = myRef.child(_user.getPhone());

                mostafa.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //kiem tra user co ton tai hay khong

                        if (dataSnapshot.getValue()==null){
                            //user chua ton tai
                            //thong bao
                            Toast.makeText(phoneSignActivity.this,"Tài khoản không tồn tại!",Toast.LENGTH_SHORT).show();
                        }else {
                            //user ton tai
                            //kiem tra mat khau
                            user a = new user();
                            a = dataSnapshot.getValue(user.class);
                            String pass = a.getPassword();
                            String pass1 = _user.getPassword();
                            if(!pass.equals(pass1)){
                                Toast.makeText(phoneSignActivity.this,"Password sai",Toast.LENGTH_SHORT).show();
                            }else {
                                //mat khau dung
                                //luu lai thong tin nguo dung
                                DBAdapter db = new DBAdapter(phoneSignActivity.this);
                                db.open();
                                //them thong tin vao db
                                long id = db.insertContact(_user.getUserName(), _user.getPhone());
//                                Cursor c = db.getAllContacts();
//                                String sdt = db.getCurrentUser();
                                db.close();

                                //luu phien nguoi dung vao db
                                session.child(_user.getPhone()).setValue("true");

                                Intent myIntent=new Intent(phoneSignActivity.this, MainActivity.class);
                                startActivity(myIntent);
                            }

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
