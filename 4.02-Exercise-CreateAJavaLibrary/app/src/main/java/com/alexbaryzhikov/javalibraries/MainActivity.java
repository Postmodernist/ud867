package com.alexbaryzhikov.javalibraries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alexbaryzhikov.manualJokes.JokeSmith;
import com.alexbaryzhikov.wizardjokes.JokeWizard;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView jokeText = findViewById(R.id.joke_text);
    jokeText.setText(JokeSmith.getJoke());

    TextView jokeText2 = findViewById(R.id.joke_text2);
    jokeText2.setText(JokeWizard.getJoke());
  }
}
