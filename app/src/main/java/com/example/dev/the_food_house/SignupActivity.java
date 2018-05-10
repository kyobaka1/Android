package com.example.dev.the_food_house;


import com.example.dev.the_food_house.model.DBAdapter;
import com.example.dev.the_food_house.model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {

    user _user;
    EditText input_user_name, input_password, input_comfirm_password, input_phone;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        final DatabaseReference session = database.getReference("session");


        _user = new user(false);
        input_user_name = (EditText)findViewById(R.id.input_user_name);
        input_phone = (EditText)findViewById(R.id.input_phone);
        input_password = (EditText)findViewById(R.id.input_password);
        input_comfirm_password = (EditText)findViewById(R.id.input_password_comfirm);
        btn_signup = (Button)findViewById(R.id.btn_signup);



        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _user.setUserName(input_user_name.getText().toString());
                _user.setPhone(input_phone.getText().toString());
                _user.setPassword(input_password.getText().toString());
                _user.setPassword_cof(input_comfirm_password.getText().toString());
//                Toast.makeText(SignupActivity.this,_user.SignupWithPhone(),Toast.LENGTH_SHORT).show();

                DatabaseReference mostafa = myRef.child(_user.getPhone());


                mostafa.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//                String phone = dataSnapshot.getValue(String.class);

                        //check == false thi key ton tai
                        //khong cho tao moi
                        boolean check = false;
                        String mess = "";
                        if (dataSnapshot.getValue()==null){
                            check = true;
                        }

                        if(_user.getPassword()!=_user.getPassword_cof()){
                            check = false;
                            mess +="Password xac nhan sai -";
//                            Toast.makeText(SignupActivity.this,"Password xac nhan sai",Toast.LENGTH_SHORT).show();
                        }

                        if(check){
                            //----------gan thong tin dang kys cho sqlite----------------------

                            myRef.child(_user.getPhone()).setValue(_user);
                            session.child(_user.getPhone()).setValue("true");
//                            finalA.message = "Dang ky thanh cong";

                            Intent myIntent=new Intent(SignupActivity.this, MainActivity.class);
                            //save thong tin dang nhap

                            //----------------------------------------------------------------------

                            DBAdapter db = new DBAdapter(SignupActivity.this);
                            db.open();
                            long id = db.insertContact(_user.getUserName(), _user.getPhone());
                            Cursor c = db.getAllContacts();
                            String sdt = db.getCurrentUser();
                            db.close();

                            //--------------------------------------------------
                            Toast.makeText(SignupActivity.this,"Dang ky thanh cong => "+id+" => "+sdt,Toast.LENGTH_SHORT).show();

                            startActivity(myIntent);
                        }else {
                            mess+="Dang ky that bai";
                            Toast.makeText(SignupActivity.this,mess,Toast.LENGTH_SHORT).show();
//                            finalA.message = "Dang ky that bai";
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
