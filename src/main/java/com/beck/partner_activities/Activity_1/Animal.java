package com.beck.partner_activities.Activity_1;

public abstract class Animal {
  protected String name;

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String toString() {
    return this.name;
  }
}