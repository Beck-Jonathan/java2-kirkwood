package com.beck.partner_activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalCount {
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
    Person Jonathan = new Person("Jonathan");
    List<Animal>  Jonathans_pets = new ArrayList<>();

    owners_and_their_pets.put(amy, amys_pets);
  }
}