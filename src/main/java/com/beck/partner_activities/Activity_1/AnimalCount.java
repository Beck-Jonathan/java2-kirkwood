package com.beck.partner_activities.Activity_1;

import java.util.*;

public class AnimalCount {

  private static Map<String, Integer> counter = new HashMap<String, Integer>();
  private static   Map<Integer,Integer> metaCount = new HashMap<>();

  public static void main(String[] args) {

    Map<Person, List<Animal>> owners_and_their_pets = new HashMap<>();


    Person marc = new Person("Marc");
    List<Animal> marcs_pets = new ArrayList<>();
    marcs_pets.add(new Cat("Waffles"));
    marcs_pets.add(new Cat("Sprout"));
    owners_and_their_pets.put(marc, marcs_pets);

    Person krystal = new Person("Krystal");
    List<Animal> krystal_pets = new ArrayList<>();
    krystal_pets.add(new Cat("Todd"));
    krystal_pets.add(new Cat("Margo"));
    krystal_pets.add(new Dog("Gus"));
    owners_and_their_pets.put(krystal, krystal_pets);

    Person bob = new Person("Bob");
    List<Animal> bobs_pets = new ArrayList<>();
    owners_and_their_pets.put(bob, bobs_pets);

    Person amy = new Person("Amy");
    List<Animal> amys_pets = new ArrayList<>();
    amys_pets.add(new Cat("Zipper"));

    owners_and_their_pets.put(amy, amys_pets);
    Person Jonathan = new Person("Jonathan");
    List<Animal> Jonathans_pets = new ArrayList<>();
    Jonathans_pets.add(new Rabbit("Gus"));
    Jonathans_pets.add(new Cat("Bubbles"));
    Jonathans_pets.add(new Fish("Speedy"));
    Jonathans_pets.add(new Turtle("Shelly"));

    owners_and_their_pets.put(Jonathan, Jonathans_pets);
    Person caspian = new Person("Caspian");
    List<Animal> caspians_pets = new ArrayList<>();
    caspians_pets.add(new Cat("Tinkerbell"));
    caspians_pets.add(new Cat("Fred"));
    caspians_pets.add(new Cat("Macready"));
    caspians_pets.add(new Dog("Mina"));
    caspians_pets.add(new Fish("Captain_Hook"));
    caspians_pets.add(new Mouse("Squire"));
    caspians_pets.add(new Snake("Botwoon"));
    owners_and_their_pets.put(caspian, caspians_pets);
    printMap(owners_and_their_pets);

    owners_and_their_pets.forEach((peep, list) -> list.forEach(animal -> {
      var x = animal.getClass().getSimpleName();
      if(counter.containsKey(x)) {
        counter.put(x, counter.get(x) + 1);
      }
      else {
        counter.put(x, 1);
      }
    }));
    //counter.entrySet().forEach(System.out::println);
    for (var key : counter.keySet()) {
      if (counter.get(key)>1){
        System.out.println("There are " + counter.get(key) +" "+ key+"s");
      }
      if (counter.get(key)==1){
        System.out.println("There is " +counter.get(key) +" " + key);
      }
      //System.out.println(key + "\uD83D\uDCA9" + counter.get(key));  //keyset method
    }
    System.out.println("Results for test question");
    String people = " Person Has ";
    for (var key : metaCount.keySet()) {
      if (metaCount.get(key)!=1){
        people = " People Have ";

      }
      else{
        people = " Person Has ";
      }
      if (key==0){
        System.out.println(metaCount.get(key)+people+ " 0 pets");
      }
      if (key==1){
        System.out.println(metaCount.get(key)+people+key+" pet");
      }
      if (key>1){
        System.out.println(metaCount.get(key)+people+key+" pets");
      }
      //System.out.println(key + "\uD83D\uDCA9" + counter.get(key));  //keyset method
    }
  }


  public static void printMap(Map<Person, List<Animal>> animalset) {

    for (Map.Entry entry : animalset.entrySet()) {

      System.out.print(entry.getKey()); // method reference
      List<Animal> animals = animalset.get(entry.getKey());
      Integer numberofpets = animals.size();
      if (numberofpets == 0) {
        System.out.print(" has no pets");
        if (metaCount.containsKey("0")) {
        metaCount.put(0,metaCount.get("0")+1);
        }
        else {metaCount.put(0,1);}

      }
      if (numberofpets == 1) {
        System.out.print("\'s pet: ");
        if (metaCount.containsKey("1")) {
          metaCount.put(1,metaCount.get("1")+1);
        }
        else {metaCount.put(0,1);}
      }
      if (numberofpets > 1) {
        System.out.print("\'s pets: ");
        if (metaCount.containsKey(numberofpets)) {
          metaCount.put(2,metaCount.get(numberofpets+1));
        }
        else {metaCount.put(numberofpets,1);}

      }
      Iterator<Animal> it = animals.iterator();
      while (it.hasNext()) {
        numberofpets--;
        Animal str = it.next();
        if (numberofpets > 0)
          System.out.print(str.toString() + ", ");
        else {
          System.out.print(str.toString());
        }

      }
      System.out.println();

    }
  }
}