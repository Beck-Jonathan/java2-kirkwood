package com.beck.controller;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name="userJsonServlet", value="/user-json")
public class UserJsonServlet extends HttpServlet {
  private static List<User> users;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //users.forEach(System.out::println);
    String query = req.getParameter("q");
    String sort = req.getParameter("sort");
    String sort2 = sort !=null ? sort:"";
    if(query == null) {
      query = "";
    }
    String query2 = query;
    List<User> deepCopy = new ArrayList<>();
    for(User user: users) {
      try {
        deepCopy.add((User)user.clone());
      } catch (CloneNotSupportedException e) {
        throw new RuntimeException(e);
      }
    }
    deepCopy.removeIf(user -> !user.getName().fullName().toLowerCase().contains(query2.toLowerCase()));

    if (!sort.equals("")){
    if (sort.equals("az")) {
      Collections.sort(deepCopy);
    }else {
      deepCopy.sort((a, b) -> b.compareTo(a));
    }


    }
    req.setAttribute("users", deepCopy);
    req.getRequestDispatcher("WEB-INF/demo/user-json.jsp").forward(req, resp);
  }

  @Override
  public void init() throws ServletException {
    try {
      JSONObject json = JsonReader.readJsonFromUrl("https://randomuser.me/api/?format=json&seed=abc&results=10&nat=us&noinfo");
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      UserFromJson userFromJson = mapper.readValue(json.toString(), UserFromJson.class);
      userFromJson.getUsers().forEach(System.out::println);
      users = userFromJson.getUsers();
    } catch(IOException e) {
      // TODO: Forward data error to jsp
    }

  }
}
