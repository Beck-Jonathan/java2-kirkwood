package com.beck.day06;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccount implements Cloneable{

  @Override
  public BankAccount clone() {
    try{
      return (BankAccount) super.clone();
    } catch(CloneNotSupportedException e){
      throw new RuntimeException(e);
    }
  }

  private double balance;

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    return String.format("Your balance on %s is %s", dateFormatter.format(LocalDate.now()), currencyFormatter.format(balance));
  }
}
