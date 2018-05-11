package com.example.dev.the_food_house;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Admin on 5/10/2018.
 */

public class Them_mon_an extends AppCompatActivity {
    EditText tieude;
    EditText huongdan;
    Button button;
    Intent intent;
    Mon_an mon_an;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mon_an);
        addControl();
        addEvent();
    }

    private void addEvent() {
        intent=getIntent();
        mon_an=new Mon_an();
        int ID= (int)intent.getIntExtra("ID",-1);
        mon_an.setIdMonAn(ID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mon_an.setTenMonAn(tieude.getText().toString());
                mon_an.setHuongDanNauAn(huongdan.getText().toString());
                intent.putExtra("Note_cl",mon_an);
                setResult(22,intent);
                finish();
            }
        });
    }

    private void addControl() {
        tieude=(EditText)findViewById(R.id.editTieude);
        huongdan=(EditText)findViewById(R.id.editHD);
        button=(Button)findViewById(R.id.buttonADD);
    }
}
