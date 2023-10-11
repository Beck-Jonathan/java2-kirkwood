package com.beck.demos.quiz;

import java.util.*;

public class main {
  public static void main(String[] args) {
    Map<String, Integer> groceryList = new HashMap<>();
    groceryList.put("milk", 1);
    groceryList.put("bread", 2);
    groceryList.put("eggs", 1);

    System.out.println("A");
    for (String key : groceryList.keySet()) {
      System.out.println(key + "=" + groceryList.get(key));
    }

    System.out.println("B");
    groceryList.forEach((key, value) -> System.out.println(key + "=" + value));

    System.out.println("c");
    for(int i = 0; i < groceryList.size(); i++) {
      System.out.println(groceryList.get(i) + "=" + i);
    }

    System.out.println("d");
    groceryList.entrySet().forEach(System.out::println);
    System.out.println("e");
    for (Map.Entry entry : groceryList.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }
  }
}
