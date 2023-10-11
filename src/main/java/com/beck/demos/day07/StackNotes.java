package com.beck.demos.day07;

import java.util.Stack;

public class StackNotes {
  private static Stack<Plate> myStack;

  public static void main(String[] args) {
    myStack = new Stack<>();
    Plate plate1 = new Plate("red");
    Plate plate2 = new Plate("yellow");
    Plate plate3 = new Plate("blue");
    Plate plate4 = new Plate("green");
//        myStack.add(plate1);
//        myStack.add(plate2);
//        myStack.add(plate3);
//        myStack.add(plate4);
//        myStack.remove(0);
//        myStack.remove(plate4);
//        myStack.remove(myStack.size() - 1);
    myStack.push(plate1);
    myStack.push(plate2);
    myStack.push(plate3);
    myStack.push(plate4);
    System.out.println(myStack.pop() + " removed");
    System.out.println(myStack.peek() + " is on top of the stack");
    System.out.println(myStack.pop() + " removed");
    System.out.println(myStack.search(plate1));
    System.out.println(myStack.search(plate2));
    System.out.println(myStack.search(plate3));
    myStack.forEach(System.out::println);
    System.out.println(myStack.pop() + " removed");
    System.out.println(myStack.empty());
    System.out.println(myStack.pop() + " removed");
    System.out.println(myStack.empty());
  }

  public static class Plate {
    private String color;

    public Plate(String color) {
      this.color = color;
    }

    @Override
    public String toString() {
      return "Plate{" +
          "color='" + color + '\'' +
          '}';
    }
  }

}
