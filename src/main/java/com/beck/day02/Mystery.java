package com.beck.day02;

public class Mystery {
  private static int count = 0;

  public Mystery() {
    count++;
  }

  public static int getCount() {
    return count;
  }
}

