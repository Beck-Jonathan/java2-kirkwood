package com.hauschildt.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.beck.data.JsonReader;
import com.beck.data.User;
import com.beck.data.UserFromJson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

@WebServlet(name="userJsonServlet", value="/user-json")
public class UserJsonServlet extends HttpServlet {
  private static List<User> users;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("users", users);
    req.getRequestDispatcher("WEB-INF/demo/user-json.jsp").forward(req,resp);
  }

  @Override
  public void init() throws ServletException {
    try {
      JSONObject json = JsonReader.readJsonFromUrl("https://randomuser.me/api/?format=json&seed=abc&results=10&nat=us&inc=name,location,gender,email,phone,cell,nat&noinfo");
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      UserFromJson userFromJson = mapper.readValue(json.toString(), UserFromJson.class);
      userFromJson.getUsers().forEach(System.out::println);
    } catch(IOException e) {
      // TODO: Forward data error to jsp
    }

  }
}
