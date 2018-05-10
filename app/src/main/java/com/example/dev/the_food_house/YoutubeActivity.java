package com.example.dev.the_food_house;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Admin on 5/10/2018.
 */

public class YoutubeActivity extends AppCompatActivity {

    public static String API_KEY = "AIzaSyDAnpDMu4RlzUpi5UDLM0spas0rFZXsVjQ";
    String ID_PLAYLIST = "PLzdMyHCicARDe-kIi8PQRMpJCnSteXZg-";

    String urlGetJson = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLzdMyHCicARDe-kIi8PQRMpJCnSteXZg-&key=AIzaSyDAnpDMu4RlzUpi5UDLM0spas0rFZXsVjQ&maxResults=50";

    ListView lvVideo;
    ArrayList<VideoYoutube> arrayVideo;
    VideoYouTubeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtubemain);

        lvVideo = (ListView) findViewById(R.id.listviewVideo);
        arrayVideo = new ArrayList<>();

        adapter = new VideoYouTubeAdapter(this, R.layout.row_video_youtube, arrayVideo);
        lvVideo.setAdapter(adapter);

        GetJsonYoutube(urlGetJson);

        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(YoutubeActivity.this, PlayVideoActivity.class);
                intent.putExtra("idVideoYouTube", arrayVideo.get(i).getIdVideo());
                startActivity(intent);
            }
        });
    }

    private void GetJsonYoutube(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonItems = response.getJSONArray("items");

                            String title = ""; String url = ""; String idVideo = "";

                            for (int i = 0; i < jsonItems.length(); i++){
                                JSONObject jsonItem = jsonItems.getJSONObject(i);

                                JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");

                                title = jsonSnippet.getString("title");

                                JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");

                                JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");

                                url = jsonMedium.getString("url");

                                JSONObject jsonResourceID = jsonSnippet.getJSONObject("resourceId");

                                idVideo = jsonResourceID.getString("videoId");

                                //Toast.makeText(MainActivity.this, idVideo, Toast.LENGTH_SHORT).show();

                                arrayVideo.add(new VideoYoutube(title, url, idVideo));
                            }

                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(YoutubeActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
