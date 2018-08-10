package com.example.android.clickcounter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ClickCounterTest {

  private ClickCounter clickCounter;

  @Before
  public void setUp() {
    clickCounter = new ClickCounter();
  }

  @After
  public void tearDown() {
    clickCounter = null;
  }

  @Test
  public void incrementIsCorrect() {
    assertEquals(0, clickCounter.getCount());
    clickCounter.increment();
    assertEquals(1, clickCounter.getCount());
  }

  @Test
  public void getCountIsCorrect() throws NoSuchFieldException, IllegalAccessException {
    Field countField = clickCounter.getClass().getDeclaredField("count");
    countField.setAccessible(true);
    int c = countField.getInt(clickCounter);
    assertEquals(c, clickCounter.getCount());
  }
}
