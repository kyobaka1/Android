package com.example.dev.the_food_house;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Admin on 5/10/2018.
 */

public class HocNauAnActivity extends AppCompatActivity {
    Mon_an_Adapter adapter;
    List<Mon_an> mon_ans;
    ExpandableListView listView;
    Button button;
    Button video;
    SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hocnauan);
        addControl();
        addEvent();

    }
    private void addEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HocNauAnActivity.this,Them_mon_an.class);
                intent.putExtra("ID", mon_ans.size());
                startActivityForResult(intent,88);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HocNauAnActivity.this,YoutubeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControl() {
        listView=(ExpandableListView)findViewById(R.id.listViewMA);
        button=(Button)findViewById(R.id.buttonThem);
        video=(Button)findViewById(R.id.buttonVideo);
        sqLite=new SQLite(this);
        mon_ans=sqLite.getNote();
        adapter=new Mon_an_Adapter(HocNauAnActivity.this,mon_ans,sqLite);
        listView.setAdapter(adapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==88 && resultCode==22)
        {
            Mon_an note1=(Mon_an) data.getSerializableExtra("Note_cl");
            if(note1==null)
            {
                Toast.makeText(this,"Thêm không thành công",Toast.LENGTH_SHORT).show();
            }else {
                sqLite.add_Note(note1);
                mon_ans.clear();
                mon_ans.addAll(sqLite.getNote());
                adapter.notifyDataSetChanged();
                listView.setSelection(mon_ans.size()-1);
                Toast.makeText(this,"Thêm  thành công",Toast.LENGTH_SHORT).show();
            }
        }

    }
}