package com.beck.partner_activities;

import java.util.*;

public class AnimalCount {
  private static Map<String, Integer> counter;

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
    counter = new HashMap<String, Integer>();
    owners_and_their_pets.forEach((person, Animal) -> {
      Animal.forEach(animal -> {
        if (counter.containsKey(animal.getClass().getSimpleName())) {
          counter.put(animal.getClass().getSimpleName(), counter.get(animal.getClass().getSimpleName()) + 1);
        } else {
          counter.put(animal.getClass().getSimpleName(), 1);
        }
      });

    });
    for (var key : counter.keySet()) {
      if (counter.get(key)>1){
        System.out.println("There are " + counter.get(key) +" "+ key+"s");
      }
      if (counter.get(key)==1){
        System.out.println("There is " +counter.get(key) +" " + key);
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
      }
      if (numberofpets == 1) {
        System.out.print("\'s pet: ");
      }
      if (numberofpets > 1) {
        System.out.print("\'s pets: ");
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