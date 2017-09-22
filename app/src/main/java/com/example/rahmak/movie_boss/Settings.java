package com.example.rahmak.movie_boss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private ListView listView;

    private String[] settings = {
            "Wallpaper",
            "Brightness",
            "Font Size",
            "Notifications",
            "Storage",
            "Setup",
            "Sound",
            "Personal Information"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        listView = (ListView) findViewById(R.id.list_view);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, settings);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplication(), settings[i], Toast.LENGTH_LONG).show();
            }
        });

    }
}
