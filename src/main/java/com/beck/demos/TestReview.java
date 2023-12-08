package com.beck.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReview {
  public static void main(String[] args) {

    int sum = 0;
    int count = 0;
    int[] arr = {12, 2, 9, 18, 18, 14, 16};
    for (int num : arr) {
      if (num % 3 == 0) {
        sum = sum + num;
        count++;

      }

    }
    double average = sum / count;
    System.out.println(average);

    List<Integer> arr2 = new ArrayList<>(Arrays.asList(12,9,14,15,15,18));
    int finalSum = sum;
    //arr.forEach(
    //git init -b main
    //parameter are the list of things that are required
    //arguement are the actual values that are passed
    //string [] months = {"jan","feb"};   normal array
    //uml stuff
    //diamond head is a collection of things
    //https://talon.kirkwood.edu/content/enforced/188708-CIS_175_CRF02_2023FA/Relationship-types.png?_&d2lSessionVal=fcY94m4gQOEVAaSHRgcpuPU4V&ou=188708

    //collections heirarchy
    //set<Toy> toys = new LinkedHashSet
    //https://talon.kirkwood.edu/content/enforced/188708-CIS_175_CRF02_2023FA/java-collections.jpg?_&d2lSessionVal=fcY94m4gQOEVAaSHRgcpuPU4V&ou=188708
    // toys.forEach ( toy -> Syste.out.println(t0y.getname());)
    //functioaal interafaces has one abstract method
    //type t is generic type
    //implements comparable
    //check my hockey team for xample


  }
}