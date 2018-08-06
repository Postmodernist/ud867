package com.udacity.gradle.flavorspecificactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void tellJoke(View view) {
    Intent intent = new Intent(this, JokeActivity.class);
    startActivity(intent);
  }
}
