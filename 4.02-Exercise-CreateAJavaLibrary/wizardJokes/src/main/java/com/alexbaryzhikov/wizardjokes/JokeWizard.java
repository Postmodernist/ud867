package com.alexbaryzhikov.wizardjokes;

import com.alexbaryzhikov.manualJokes.JokeSmith;

public class JokeWizard {
  public static String getJoke() {
    return JokeSmith.getJoke() + " ;)";
  }
}
