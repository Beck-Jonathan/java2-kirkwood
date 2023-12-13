package com.beck.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrayonTest {

  @Test
  void main() {
  }

  @Test
  void getColor() {
    Crayon crayon  = new Crayon();

    String result = crayon.getColor();
    assertEquals("black",result);
  }

  @Test
  void setColor() {

    Crayon crayon  = new Crayon();
    crayon.setColor("blue");
    String result = crayon.getColor();
    assertEquals("blue",result);
  }

  @Test
  void getPercentRemaining() {

    Crayon crayon  = new Crayon();

    double result = crayon.getPercentRemaining();
    assertEquals(1,result);
  }

  @Test
  void setPercentRemaining() {
    Crayon crayon  = new Crayon();
    crayon.setPercentRemaining(.6);
    double result = crayon.getPercentRemaining();
    assertEquals(.6,result);
  }
  @Test
  void setPercentRemainingthrowserrorfortoolow() {
    Crayon crayon  = new Crayon();

    assertThrows(IllegalArgumentException.class, () -> crayon.setPercentRemaining(-3));
  }
  @Test
  void setPercentRemainingthrowserrorfortoohigh() {
    Crayon crayon  = new Crayon();

    assertThrows(IllegalArgumentException.class, () -> crayon.setPercentRemaining(1.2));

  }
  @Test
  void compareTo() {
    Crayon c1 = new Crayon("blue",.7);
    Crayon c2 = new Crayon ("green",.4);
    Crayon c3 = new Crayon ("green",.2);
    int result = c1.compareTo(c2);
    Boolean test1 = (result>0);
    result=c2.compareTo(c3);
    Boolean test2 = (result<0);
    assertFalse(test1);
    assertFalse(test2);
  }

  @Test
  void testToString() {
    Crayon crayon = new Crayon("blue",.7);
    String result = crayon.toString();
    String expected = "Crayon{color='blue', percentRemaining=0.7}";
    assertEquals(result,expected);
  }
}