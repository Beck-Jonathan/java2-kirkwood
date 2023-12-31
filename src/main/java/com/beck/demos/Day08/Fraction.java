package com.beck.demos.Day08;

import java.math.BigInteger;

public class Fraction {

  // were gonna use my main man jUnit
  //This comes with MAven projects'
  //to check if you have a maven project, check for pom.xml. If you have pom.xml, you are wokring on a maven project
  //Your tests are going to be in src/main/test
  //blue folders are called source roots
  //green folders are called test source roots
  //it has it's own resource folders
  //right click on the class name, then pick show contect actions, create test. Theres some more menus there
  //but just hit okay for now
  //

  private int numerator;
  private int denominator;

  public Fraction() {
    this.numerator = 1;
    this.denominator = 1;


  }
  public Fraction(int numerator, int denominator) {
    setNumerator(numerator);
    setDenominator(denominator);
  }

  public int getNumerator(){
    return this.numerator;
  }

  public void setNumerator (int numerator){
    this.numerator=numerator;
  }

  public int getDenominator(){
    return this.denominator;
  }

  public void setDenominator (int denominator){
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator can not be zero");
    }
    this.denominator = denominator;

  }

  public String toString() {
    return this.numerator + "/" + this.denominator;
  }

  public static int greatestCommonDivisor(int num1, int num2) {
    BigInteger i = BigInteger.valueOf(num1).gcd(BigInteger.valueOf(num2));
    int gcd = Integer.parseInt(i.toString());
    return gcd;
  }

  //removing instructor code (as to ad in my own code later)

  //public Fraction simplify() {
   // int gcd = greatestCommonDivisor(this.numerator, this.denominator);
    //Fraction simplifiedFraction = new Fraction(this.numerator / gcd, this.denominator / gcd);
    //if(simplifiedFraction.numerator >= 0 && simplifiedFraction.denominator < 0
     //   || simplifiedFraction.numerator < 0 && simplifiedFraction.denominator < 0) {
     // simplifiedFraction.numerator *= -1;
     // simplifiedFraction.denominator *= -1;
   // }
    //return simplifiedFraction;
 // }

  //Adding in my code from last term to see if the tests still pass
  public Fraction simplify(){
    int gcd = greatestCommonDivisor(this.numerator, this.denominator);
    int newNumerator = this.numerator / gcd;
    int newDenominator = this.denominator / gcd;
    if (newNumerator >= 0 && newDenominator < 0){
      newNumerator = newNumerator * -1;
      newDenominator = newDenominator * -1;
    } else if (newNumerator < 0 && newDenominator < 0){
      newNumerator = newNumerator * -1;
      newDenominator = newDenominator * -1;
    }
    Fraction f = new Fraction(newNumerator, newDenominator);
    return f;
  }

  public  String  mixedNumber(){
    String xx=" ";
    Fraction g = this.simplify();
    Integer x = g.getDenominator();
    Integer y = g.getNumerator();
    if (x==0){return  y.toString();}
    else if (y==0){return "0";}
    else if (x==y){return "1";}
    else if (y>x){
      Integer whole = y/x;
      Integer remainder = y%x;
      if (remainder == 0) {
        return whole.toString();
      }
      String result = whole.toString()+" "+remainder.toString()+ "/" + x.toString();
      return result;}
    else if(y<0&& Math.abs(y)>Math.abs(x)){
      Integer whole = y/x;
      Integer remainder = -y%x;
      String result = whole.toString()+" "+remainder.toString()+ "/" + x.toString();
      return result;}
    else {return g.toString();}






  }


}

