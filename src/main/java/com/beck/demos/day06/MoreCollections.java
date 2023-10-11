package com.beck.demos.day06;

import java.util.*;

public class MoreCollections {
  private static List<BankAccount> myList4;
  static List<BankAccount> myList5;

  public static void main(String[] args) {
    //immuatable
    myList4 = Arrays.asList(new BankAccount(100));
    myList4 = new ArrayList<>(Arrays.asList(new BankAccount(100)));
    //can not add to a list, you need an array list
    //mutatable
    myList4.add(new BankAccount(200));
    //shallow copy
    myList5 = new ArrayList<>(myList4);

    myList5.get(0).setBalance(101);
    Collections_demo.printCollection(myList4, "vertical");

    //deep copy
    List<BankAccount> myList6 = new ArrayList<>(myList5.size());
    for (int i = 0; i < myList5.size(); i++) {
      myList6.set(i, myList5.get(i));
    }

    List<BankAccount> myList7 = new ArrayList<>(myList6.size());
    Iterator<BankAccount> itty = myList5.iterator();
    while (itty.hasNext()) {
      myList7.add(itty.next().clone());
    }
  }
}



