package com.alexbaryzhikov.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alexbaryzhikov.comedian.ShowActivity;
import com.alexbaryzhikov.jokes.JokeSmith;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.tell_joke).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        intent.putExtra("joke", JokeSmith.getJoke());
        startActivity(intent);
      }
    });
  }
}
