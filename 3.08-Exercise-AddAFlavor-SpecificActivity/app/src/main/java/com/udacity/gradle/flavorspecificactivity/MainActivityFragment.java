package com.udacity.gradle.flavorspecificactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivityFragment extends Fragment {

  public MainActivityFragment() {
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    Button button = view.findViewById(R.id.button);
    MainActivity mainActivity = (MainActivity) getActivity();
    if (mainActivity != null) {
      button.setOnClickListener(mainActivity::tellJoke);
    }
    return view;
  }
}
