package com.alexbaryzhikov.comedian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show);

    Intent intent = getIntent();
    String joke = intent.getStringExtra("joke");
    if (!TextUtils.isEmpty(joke)) {
      ((TextView) findViewById(R.id.output)).setText(joke);
    } else {
      ((TextView) findViewById(R.id.output)).setText(R.string.no_joke);
    }
  }
}
