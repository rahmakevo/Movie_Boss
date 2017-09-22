package com.example.rahmak.movie_boss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Movies extends AppCompatActivity {

    API_Service api_service = new API_Service();

    ArrayList<Results> resultsArrayLists = new ArrayList<>();

    MyAdapter myAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);

        // textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
//        textView.setText("Enjoy the movie: "+ name);
        fetchApiService(name);
    }

    private void fetchApiService(String name){
        api_service.fetchApiService(name, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                resultsArrayLists = api_service.processResults(response);

                Movies.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myAdapter = new MyAdapter(getApplicationContext(), resultsArrayLists);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Movies.this);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(myAdapter);

                    }
                });
            }
        });
    }
}
