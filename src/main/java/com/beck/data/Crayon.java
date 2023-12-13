package com.beck.data;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crayon implements Comparable  {

  public static void main(String[] args) {
    //create a list and add 5 crayons
    List<Crayon> crayons = new ArrayList<>();
      Crayon red = new Crayon("red",.6);
    Crayon red2 = new Crayon("red",.3);
    Crayon green = new Crayon("green",.65);
    Crayon blue = new Crayon("blue",.2);
    Crayon orange = new Crayon("orange",.2);
    crayons.add(red);
    crayons.add(red2);
    crayons.add(green);
    crayons.add(blue);
    crayons.add(orange);
    //sort the list
    Collections.sort(crayons);
    //print the list
    System.out.println("All crayons in normal sort order");
    crayons.forEach(System.out::println);
    System.out.println( );

    //copy the list
    List<Crayon> smallCrayons =  new ArrayList(crayons);
    List<Crayon> smallCrayons2 =  new ArrayList(crayons);
    //remove all under 50%
    System.out.println("All crayons with more than 50%");
        for (int i=smallCrayons.size()-1;i>=0;i--)
        {
          if(smallCrayons.get(i).percentRemaining<.5){
            smallCrayons2.remove(i);
          }


        }




    //print the copy
    smallCrayons2.forEach(System.out::println);
    System.out.println();
    //reverse the origianl
    Collections.reverse(crayons);
    //print the original (reversed)
    System.out.println("reversed sort order");
    crayons.forEach(System.out::println);

    }



  String color;
  double percentRemaining;

  public Crayon() {
    this.color="black";
    this.percentRemaining=1;
  }

  public Crayon(String color, double percentRemaining) {
    this.setColor(color);
    this.setPercentRemaining(percentRemaining);
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getPercentRemaining() {
    return percentRemaining;
  }

  public void setPercentRemaining(double percentRemaining) {
    if (percentRemaining<0||percentRemaining>1){
      throw new IllegalArgumentException();
    }
    this.percentRemaining = percentRemaining;
  }



  @Override
  public int compareTo(@NotNull Object o) {
    Crayon other = (Crayon) o ;
    int result = this.getColor().compareTo(other.getColor());
    if (result==0){
      result = (int) (this.getPercentRemaining()-other.getPercentRemaining())*100;

    }
    return result;
  }

  @Override
  public String toString() {
    return "Crayon{" +
        "color='" + color + '\'' +
        ", percentRemaining=" + percentRemaining +
        '}';
  }
}
