package com.beck.demos.Day08;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
  @Test
  public void defaultConstructor(){
    String expected = "1/1";
    String actual = new Fraction().toString();
    assertEquals (expected,actual);


  }
  @Test
  public void paramaterizedConstructor() {
    String expected = "4/5";
    String actual = new Fraction(4,5).toString();
    assertEquals(expected,actual);

  }

  @Test
  public void getNumerator(){
    int expected = 4;
    int acutal = new Fraction(4,5).getNumerator();
    assertEquals(expected,acutal);

  }

  @Test
  public void getDenominator(){
    assertEquals(4,new Fraction(3,4).getDenominator());


  }

  @Test
  public void setNumerator() {
    int expected =4;
    Fraction f = new Fraction();
    f.setNumerator(4);
    int acutal = f.getNumerator();
    assertEquals(expected,acutal);



  }

  @Test
  public void setDenominator(){
    int expected =4;
    Fraction f = new Fraction();
    f.setDenominator(4);
    int acutal = f.getDenominator();
    assertEquals(expected,acutal);
    assertThrows(IllegalArgumentException.class,()->f.setDenominator(0));
    assertThrowsExactly(IllegalArgumentException.class,()->f.setDenominator(0));



  }
  @Test
  public void greatestCommonDivisor() {
    int expected = 15;
    int actual = Fraction.greatestCommonDivisor(75, 45);
    assertEquals(expected, actual);
  }

  @Test
  public void assertTruth(){
    assertTrue(2==6/3);
    assertTrue("Test".equals("Te"+"st"));

  }
  @Test
  public void roundOff () {
    assertEquals(3.3,1.1+2.2,.0001);

  }
  @Test
  public void muckWithZeroes(){
    int actual = Fraction.greatestCommonDivisor(0,1);
    int expected = 1;
    assertEquals(actual,expected);

  }


}