package com.beck.demos.Day08;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
  @Test
  public void defaultConstructor() {
    String expected = "1/1";
    String actual = new Fraction().toString();
    assertEquals(expected, actual);

  }

  @Test
  public void paramaterizedConstructor() {
    String expected = "4/5";
    String actual = new Fraction(4, 5).toString();
    assertEquals(expected, actual);

  }

  @Test
  public void getNumerator() {
    int expected = 4;
    int acutal = new Fraction(4, 5).getNumerator();
    assertEquals(expected, acutal);

  }

  @Test
  public void getDenominator() {
    assertEquals(4, new Fraction(3, 4).getDenominator());

  }

  @Test
  public void setNumerator() {
    int expected = 4;
    Fraction f = new Fraction();
    f.setNumerator(4);
    int acutal = f.getNumerator();
    assertEquals(expected, acutal);

  }

  @Test
  public void setDenominator() {
    int expected = 4;
    Fraction f = new Fraction();
    f.setDenominator(4);
    int acutal = f.getDenominator();
    assertEquals(expected, acutal);
    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    //contains exception and lamda expresson. the lamda expresions is ()-> f.setDenominator(0)
    assertThrowsExactly(IllegalArgumentException.class, () -> f.setDenominator(0));

  }

  @Test
  public void greatestCommonDivisor() {
    int expected = 15;
    int actual = Fraction.greatestCommonDivisor(75, 45);
    assertEquals(expected, actual);
  }

  @Test
  public void assertTruth() {
    assertTrue(2 == 6 / 3);
    assertTrue("Test".equals("Te" + "st"));

  }

  @Test
  public void roundOff() {
    assertEquals(3.3, 1.1 + 2.2, .0001);

  }

  @Test
  public void muckWithZeroes() {
    int actual = Fraction.greatestCommonDivisor(0, 1);
    int expected = 1;
    assertEquals(actual, expected);

  }

  @Test
  public void testSimplify() {
    //This is JOnathans work
    Fraction F1 = new Fraction(2, 4);
    Fraction F2 = new Fraction(-2, 4);
    Fraction F3 = new Fraction(-2, -4);
    Fraction S1 = F1.simplify();
    Fraction S2 = F2.simplify();
    Fraction S3 = F3.simplify();
    assertEquals(S1.toString(), "1/2");
    assertTrue(S2.toString().equals("-1/2"));
    assertEquals(S3.getNumerator(), 1);
    assertTrue(S3.getDenominator() == 2);

    //this is Isabella's work

    Fraction fraction1 = new Fraction(75, 45);
    String expected1 = "5/3";
    String actual1 = fraction1.simplify().toString();
    assertEquals(expected1, actual1);

    Fraction fraction2 = new Fraction(5, 7);
    String expected2 = "5/7";
    String actual2 = fraction2.simplify().toString();
    assertTrue(expected2.equals(actual2));

    Fraction fraction3 = new Fraction(2, -4);
    int expectedNumerator = -1;
    int expectedDenominator = 2;
    int actualNumerator = fraction3.simplify().getNumerator();
    int actualDenominator = fraction3.simplify().getDenominator();
    assertEquals(expectedNumerator, actualNumerator);
    assertTrue(expectedDenominator == actualDenominator);

  }

  @Test
  public void testMixedNumber()
  {
    Fraction f1 = new Fraction(4, 1);
    Fraction f2 = new Fraction(0, 4);
    Fraction f3 = new Fraction(4, 4);
    Fraction f4 = new Fraction(8, 4);
    Fraction f5 = new Fraction(4, 8);
    Fraction f6 = new Fraction(13, 5);
    Fraction f7 = new Fraction(-13, 5);
    Fraction f8 = new Fraction(13, -5);
    Fraction f9 = new Fraction(-13, -5);
    Fraction f10 = new Fraction(-4, -5);
    String m1 = f1.mixedNumber();
    String m2 = f2.mixedNumber();
    String m3 = f3.mixedNumber();
    String m4 = f4.mixedNumber();
    String m5 = f5.mixedNumber();
    String m6 = f6.mixedNumber();
    String m7 = f7.mixedNumber();
    String m8 = f8.mixedNumber();
    String m9 = f9.mixedNumber();
    String m10 = f10.mixedNumber();
    String e1 = "4";
    String e2 = "0";
    String e3 = "1";
    String e4 = "2";
    String e5 = "1/2";
    String e6 = "2 3/5";
    String e7 = "-2 3/5";
    String e8 = "-2 3/5";
    String e9 = "2 3/5";
    String e10 = "4/5";
    assertEquals(m1, e1);
    assertEquals(m2, e2);
    assertEquals(m3, e3);
    assertEquals(m4, e4);
    assertEquals(m5, e5);
    assertEquals(m6, e6);
    assertEquals(m7, e7);
    assertEquals(m8, e8);
    assertEquals(m9, e9);
    assertEquals(m10, e10);

  }

}