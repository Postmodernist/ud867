package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private SimpleIdlingResource idlingResource;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (idlingResource == null) {
      idlingResource = new SimpleIdlingResource();
    }
  }

  public SimpleIdlingResource getIdlingResource() {
    return idlingResource;
  }
}
