package com.example.dev.the_food_house;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;





/**
 * Created by hoans_000 on 5/1/2018.
 */

public class HistoryActivity extends AppCompatActivity {
    String name5;
    String x = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();
        Bitmap bmp =  BitmapFactory.decodeResource(getResources(),R.drawable.avartar);//your image

        ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
        bmp.recycle();
        byte[] byteArray = bYtE.toByteArray();
        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);

        name5 = intent.getStringExtra("YourValueKey5");

        if (x.equalsIgnoreCase(name5)) {

            TextView tv = (TextView) findViewById(R.id.his);
            tv.setText("History");
            ImageView iv=(ImageView)findViewById(R.id.profile);
            iv.setImageResource(R.drawable.avartar);

        }
    }
}
