package com.beck.Calculators;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "convertMoney", value = "/convert-money")
public class ConvertMoney extends HttpServlet {

  private static Map<String, String> results = new HashMap<>();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("WEB-INF/calculators/fin-calc-beck.jsp").forward(req, resp);
    System.out.println("get req");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String conversion = req.getParameter("annuityType");
    System.out.println(conversion);
    String rate = req.getParameter("rate");
    System.out.println(rate);
    String years = req.getParameter("years");
    System.out.println(years);
    String annualPayment = req.getParameter("annualPayment");
    results.clear();
    results.put("conversion", conversion);
    results.put("rate", rate);
    results.put("years", years);
    results.put("annualPayment", annualPayment);
    convertMoney(conversion, rate, years,annualPayment);
    req.setAttribute("results", results);
    req.getRequestDispatcher("WEB-INF/calculators/fin-calc-beck.jsp").forward(req, resp);
  }

  private void convertMoney(String conversion, String rate, String Years, String annualPayment) {
    if (conversion == null || (!conversion.equals("PV") && !conversion.equals("PVD") && !conversion.equals("FV") && !conversion.equals("FVD"))) {
      results.put("conversionError", "Select a conversion type");
    }
    if (!isANumberDouble(rate)) {
      results.put("rateError", "Please input a valid rate");
    }
    if (!isANumberYears(Years)) {
      results.put("yearError", "Please input a valid year");
    }
    if (!isANumberDouble(annualPayment)) {
      results.put("paymentError", "Please input a valid payment");
    }
    if (!results.containsKey("conversionError")
        && !results.containsKey("rateError")
        && !results.containsKey("yearError")
        && !results.containsKey("paymentError")) {
      double interestRate = Double.parseDouble(rate)/100;
      int years = Integer.parseInt(Years);
      double payment = Double.parseDouble(annualPayment);
      double moneyResult=0;
      String resultString="";
      if (conversion.equals("PV")){
        moneyResult = payment* (1- Math.pow((1+interestRate),(0-years))) / interestRate;
        System.out.println(moneyResult);
         resultString = String.format("The present value of %f (starting in 1 year) to be received for %d years at a %f discount rate is %f",payment,years,interestRate,moneyResult);


      }
      if (conversion.equals("PVD")){
        moneyResult = payment* (1- Math.pow((1+interestRate),(0-years))) / interestRate;
        moneyResult = moneyResult * (1+interestRate);
        System.out.println(moneyResult);
        resultString = String.format("The present value of %f (starting today) to be received for %d years at a %f discount rate is %f",payment,years,interestRate,moneyResult);



      }
      if (conversion.equals("FV")){
        moneyResult = payment * ((Math.pow((1+interestRate),years)-1)/interestRate);
        System.out.println(moneyResult);
        resultString = String.format("The future value of %2f (starting in one year) to be invssted for %d years at a %2f interest rate is %2f",payment,years,interestRate,moneyResult);



      }
      if (conversion.equals("FVD")){
        moneyResult = (1+interestRate)* payment * ((Math.pow((1+interestRate),years)-1)/interestRate);
        System.out.println(moneyResult);
        resultString = String.format("The future value of %2f (starting now) to be invssted for %d years at a %2f %% interest rate is %2f",payment,years,interestRate*100,moneyResult);



      }

      results.put("moneyConverted", String.format("%s",resultString));
    }
  }

  public static boolean isANumberDouble(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean isANumberYears(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}

