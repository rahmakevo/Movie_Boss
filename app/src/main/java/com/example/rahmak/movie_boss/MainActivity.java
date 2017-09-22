package com.example.rahmak.movie_boss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu_favorites:
                favorites(menuItem);
                return true;
            case R.id.wealthy_actors:
                actors(menuItem);
                return true;
            case R.id.settings:
                settings(menuItem);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void favorites(MenuItem item) {
        Intent intent = new Intent(this, Favorites.class);
        startActivity(intent);
    }

    public void actors(MenuItem item) {
        Intent intent = new Intent(this, Actors.class);
        startActivity(intent);
    }

    public void settings(MenuItem item) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void button_enter(View view) {
        String name = editText.getText().toString();
        Intent intent = new Intent(this, Movies.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
