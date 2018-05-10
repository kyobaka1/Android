package com.example.dev.the_food_house;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dev.the_food_house.model.DBAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private ImageButton btnLoginWithPhone;
    private Button btnSkip;
    private ImageButton btnLoginWithFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLoginWithPhone = (ImageButton) findViewById(R.id.btnPhone);
        btnSkip = (Button)findViewById(R.id.btnSkip);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");
        final DatabaseReference session = database.getReference("session");
//        btnLoginWithFacebook = (ImageButton) findViewById(R.id.btnFacebook);
//        btnLoginWithMail = (ImageButton) findViewById(R.id.btnMail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //check login
        DBAdapter db = new DBAdapter(LoginActivity.this);
        db.open();
        final String sdt = db.getCurrentUser();
        db.close();

        DatabaseReference mostafa = session.child(sdt);

        mostafa.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String sdtcom = dataSnapshot.getValue(String.class);
                if (sdtcom.equals("true")){
                    Intent myIntent=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        btnSkip.setOnClickListener(new View.OnClickListener() {
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

        btnLoginWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(LoginActivity.this, phoneSignActivity.class);
                startActivity(myIntent);
            }
        });



    }


}
