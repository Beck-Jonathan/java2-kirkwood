package com.beck.day06;
import java.util.*;
import java.util.stream.Collectors;

public class Collections_demo {
  private static List<String> myList;
  private static Set<String> mySet;
  private static Queue<String> myQueue;
  private static Map <Integer,String> myMap;

  public static void main(String[] args) {

    myList = new ArrayList<>();
//    myList = new LinkedList<>();
//    myList = new Stack<>();
    myList.add("cat");
    myList.add("dog");
    myList.add(1,"rabbit");
    myList.addAll(Arrays.asList("a","b","c"));
   // for (int j=0;j<myList.size();j++){
    //  System.out.println(myList.get(j));
    //}
    //printCollection(myList,"vertical");
    printCollection(myList,"horizontal");

    mySet = new HashSet<>();
//    mySet = new LinkedHashSet<>;
//    mySet = new TreeSet<>();

    myQueue = new PriorityQueue<>();
//    myQueue = new ArrayDeque<>();

    myMap = new HashMap<>();
//    myMap = new TreeMap<>();
//    myMap = new Hashtable<>();



  }

  public static void printCollection(Collection C, String direction) {
    if (!direction.equalsIgnoreCase("horizontal")&&!direction.equalsIgnoreCase("vertical")){
      return;
    }
    if (direction.equals("vertical")){
      for (var s : C){
        System.out.println(s.toString());
      }
      //lamda expression
      C.forEach((el) -> System.out.println(el));
      //method reference
      C.forEach(System.out::println);
    }
    if (direction.equals("horizontal")){
//      System.out.println(C.toString());
//      for (var s : C){
//        System.out.print(s.toString());
//        System.out.print(" , ");
//      }
//      //lamda expression
//      C.forEach((el) -> System.out.print(el+" , "));
//      //method reference
//      C.forEach(System.out::print);

      System.out.println(C.stream().map(Object::toString).collect(Collectors.joining(" , ")));
    }



  }
}
