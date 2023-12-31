package com.beck.demos.day07;

import java.util.*;

public class MappyHashy {
  private static Map<String, Integer> population;
  private static List<String> food;
  private static Map<String, Integer> foodCount;
  private static Map<String, String> stateTrees;
  private static Map<String, Integer> treeCount;

  public static void main(String[] args) {
    Map<String, Character> grades = new HashMap<>();
    grades.put("x",'a');

    population = new HashMap<>(); // new TreeMap<>();
    //chnage this to treemap and the keys are sorted alphabetical
    //key as string, int as the value. Gotta add stuff as pairs.
    // use the put method to add stuff
    population.put("Des Moines", 214133);
    population.put("Cedar Rapids", 136981);
    population.put("Davenport", 101724);
    population.put("Sioux City", 85791);
    population.put("Des Moines", 214134);
    //printMap is a function we created below
    printMap(population);
    //
    // change it to an entry set here. allows the faster looping
     population.entrySet().forEach(System.out::println);
    System.out.println(population.remove("Sioux City"));
    System.out.println(population.containsKey("Sioux City"));
    System.out.println(population.containsKey("Cedar Rapids"));
    System.out.println(population.containsValue(85791));
    System.out.println(population.containsValue(136981));
    System.out.println(population.size());
    food = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana"));
    foodCount = new HashMap<>();
    food.forEach(el -> {
      if (foodCount.containsKey(el)) {
        foodCount.put(el, foodCount.get(el) + 1);
      } else {
        foodCount.put(el, 1);
      }
    });
    printMap(foodCount);
    stateTrees = new HashMap<>();
    stateTrees.put("Wisconsin", "Sugar Maple");
    stateTrees.put("Illinois", "White Oak");
    stateTrees.put("Vermont", "Sugar Maple");
    stateTrees.put("West Virginia", "Sugar Maple");
    stateTrees.put("Maryland", "White Oak");
    stateTrees.put("New York", "Sugar Maple");
    stateTrees.put("Connecticut", "White Oak");
    printMap(stateTrees);

    treeCount = new HashMap<>();
    stateTrees.forEach((state, tree) -> {
      if (treeCount.containsKey(tree)) {
        treeCount.put(tree, treeCount.get(tree) + 1);
      } else {
        treeCount.put(tree, 1);
      }
    });
    printMap(treeCount);
   // population.forEach((key, value) -> System.out.println(key + "=" + value));
  }

  public static void printMap(Map<?, ?> map) {
    map.entrySet().forEach(System.out::println);
    System.out.println();
    map.forEach((key, value) -> System.out.println(key + "\uD83C\uDFF4\u200D☠\uFE0F" + value)); //entry set with method reference

    for (Map.Entry entry : map.entrySet()) {
      System.out.println(entry.getKey() + "\uD83D\uDC80" + entry.getValue()); // method reference
    }

    for (var key : map.keySet()) {
      System.out.println(key + "\uD83D\uDCA9" + map.get(key));  //keyset method
    }

  }
}
