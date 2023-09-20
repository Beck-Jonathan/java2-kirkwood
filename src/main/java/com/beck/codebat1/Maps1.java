package com.beck.codebat1;

import java.util.*;

public class Maps1 {
  public static void main(String[] args) {

    Map<String, String> Bat = new HashMap<>();
    Bat.put("a", "candy");
    Bat.put("b", "test");
    mapBully(Bat);

  }

  public static Map<String, String> mapBully(Map<String, String> map) {
    String aStuff = map.get("a");
    if (map.get("a") != null && !aStuff.equals("")) {
      map.put("b", aStuff);
      map.put("a", "");
    }
    return map;
  }

  public Map<String, String> topping1(Map<String, String> map) {
    map.put("bread", "butter");
    if (map.containsKey("ice cream")) {
      map.put("ice cream", "cherry");
    }
    return map;
  }

  public Map<String, String> mapAB2(Map<String, String> map) {
    String aStuff = map.get("a");
    String bStuff = map.get("b");
    if (aStuff!=null && bStuff!=null && aStuff.equals(bStuff)){
      map.remove("a");
      map.remove("b");

    }
    return map;

  }

  public Map<String, String> mapShare(Map<String, String> map) {
    map.remove("c");
    String aStuff = map.get("a");
    if (map.get("a") != null && !aStuff.equals("")) {
      map.put("b", aStuff);
    }
    return map;


  }



}


