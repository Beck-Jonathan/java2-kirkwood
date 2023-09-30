package com.beck.codebat1;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Maps2 {
  public static void main(String[] args) {
    Map<String, String> Bat = new HashMap<>();
    Bat.put("a", "candy");
    Bat.put("b", "test");
    String[] strArray2 = {"a", "b", "b", "b", "a", "c", "a", "a"};
    String output=wordAppend(strArray2);
    System.out.println(output);
  }

  public Map<String, Integer> word0(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      map.put(str, 0);
    }

    return map;
  }

  public Map<String, Integer> wordLen(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      map.put(str, str.length());
    }

    return map;

  }
  public Map<String, String> firstChar(String[] strings) {
    Map<String, String> map = new HashMap<>();

    for (String str : strings) {
      if (!map.containsKey(str.substring(0,1))){
        map.put(str.substring(0, 1),  str);
      }
      else  {

        map.put(str.substring(0, 1), map.get(str.substring(0,1)) + str);
      }


    }
    return map;

  }

  public Map<String, Integer> wordCount(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      } else map.put(str, 1);
    }

    return map;
  }

  public Map<String, String> topping2(Map<String, String> map) {

    if (map.containsKey("ice cream")) {
      map.put("yogurt", map.get("ice cream"));
    }
    if (map.containsKey("spinach")) {
      map.put("spinach", "nuts");
    }

    return map;
  }

  public Map<String, String> topping3(Map<String, String> map) {
    if (map.containsKey("potato")) {
      map.put("fries", map.get("potato"));
    }
    if (map.containsKey("salad")) {
      map.put("spinach", map.get("salad"));
    }

    return map;
  }

  public Map<String, String> mapAB(Map<String, String> map) {
    if (map.containsKey("a") && map.containsKey("b")) {
      map.put("ab", map.get("a") + map.get("b"));
    }

    return map;

  }

  public Map<String, String> mapAB3(Map<String, String> map) {
    if (map.containsKey("a") && !map.containsKey("b")) {
      map.put("b", map.get("a"));
    }
    if (!map.containsKey("a") && map.containsKey("b")) {
      map.put("a", map.get("b"));

    }

    return map;

  }

  public Map<String, String> mapAB4(Map<String, String> map) {
    if (map.containsKey("a") && map.containsKey("b")) {
      if (map.get("a").length() > map.get("b").length()) {
        map.put("c", map.get("a"));
      }
      if (map.get("a").length() < map.get("b").length()) {
        map.put("c", map.get("b"));
      }
      if (map.get("a").length() == map.get("b").length()) {
        map.put("a", "");
        map.put("b", "");
      }
    }

    return map;

  }

  public Map<String, String> pairs(String[] strings) {
    Map<String, String> map2 = new HashMap<>();
    for (String str : strings) {
      map2.put(str.substring(0, 1), str.substring(str.length() - 1, str.length()));
    }

    return map2;
  }

  public Map<String, Boolean> wordMultiple(String[] strings) {
    Map<String, Boolean> map2 = new HashMap<>();
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      } else {
        map.put(str, 1);
      }
    }
    map.forEach((str, num) -> {
      if (num >= 2) {
        map2.put(str, true);
      } else {
        map2.put(str, false);
      }
    });
    return map2;
  }

  public static String wordAppend(String[] strings) {
    int counter=0;
    String buddy = "";
    String[] appends;
    Map<String, Integer> map = new HashMap<>();
    for (String str : strings) {
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
        if (map.get(str)%2==0){
          buddy=buddy+str;
        }
      } else map.put(str, 1);
    }


    return buddy;

  }

  public String[] allSwap(String[] strings) {
    Map<String, Integer> map2 = new HashMap<String, Integer>();
    for (int i = 0; i < strings.length; i++) {
      String key_char = String.valueOf(strings[i].charAt(0));

    if (map2.containsKey(key_char)) {

      Integer index_to_swap = map2.get(key_char);
      String temp = strings[index_to_swap];
      strings[index_to_swap]= strings[i];
      strings[i]=temp;

      map2.remove(key_char);

    }
      else {
        map2.put(key_char,i);
      }
    }

    return strings;
  }

  public String[] firstSwap(String[] strings) {
    Map<String, Integer> map2 = new HashMap<String, Integer>();
    List<String> banned = new ArrayList<>();

    for (int i = 0; i < strings.length; i++) {
      String key_char = String.valueOf(strings[i].charAt(0));

      if (map2.containsKey(key_char)&&!banned.contains(key_char)) {

        Integer index_to_swap = map2.get(key_char);
        String temp = strings[index_to_swap];
        strings[index_to_swap]= strings[i];
        strings[i]=temp;

        map2.remove(key_char);
        banned.add(key_char);

      }
      else {
        map2.put(key_char,i);
      }
    }

    return strings;
  }



}

