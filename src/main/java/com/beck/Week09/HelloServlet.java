package com.beck.Week09;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
  //get requests
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res){
    System.out.println("you made a geTTt request");

  }


  //post requets
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res){
    System.out.println("you made a post request");


  }




}
