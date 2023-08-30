package com.beck.day02;
// Assume a class BankAccount exists with an instance variable called "balance" (a double).
//        Write a toString method that could print "Your balance on May X, 20XX is $1,234.56". Substitute "May X, 20XX" with today's date. Substitute "1,234.56" with the balance.
//        You must apply date and number formatting to earn full credit.
//    }

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class bank_account {
  private Double balance;

  public bank_account(Double balance) {
    this.balance = balance;
  }

  public String toString(){
    String result = "";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd,YYYY");
    LocalDate today = LocalDate.now();
    NumberFormat moneybags = NumberFormat.getCurrencyInstance();


    return "your balance of the day of " +formatter.format(today) + " is " + moneybags.format(this.balance);


  }
}
