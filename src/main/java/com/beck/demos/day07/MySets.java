package com.beck.demos.day07;

import java.util.HashSet;
import java.util.Set;

public class MySets {
  private static Set<String> mySet;

  public static void main(String[] args) {
    mySet = new HashSet<>(); // new TreeSet<>();
    mySet.add("apple");
    mySet.add("banana");
    mySet.add("carrot");
    mySet.add("donut");
    mySet.add("donut"); // No duplicate values
    mySet.forEach(System.out::println); // Not ordered by index
    System.out.println();

    // mySet.remove(0); // Can't remove by index
    mySet.remove("donut"); // Can only remove by object
    // mySet.remove(mySet.size() - 1); // Again, can't remove by index
    mySet.forEach(System.out::println);
  }
}
