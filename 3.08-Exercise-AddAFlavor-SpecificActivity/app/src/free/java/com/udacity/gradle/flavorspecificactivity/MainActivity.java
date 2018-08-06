package com.udacity.gradle.flavorspecificactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void tellJoke(View view) {
    CharSequence text = this.getString(R.string.toast_text);
    int duration = Toast.LENGTH_LONG;
    Toast toast = Toast.makeText(this, text, duration);
    toast.show();
  }
}
