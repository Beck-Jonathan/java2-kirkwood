package com.beck.controller;

import com.beck.data.*;
import com.beck.data.Team;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet(name="userJsonServlet", value="/hockey-json")
public class HockeyJsonServlet extends HttpServlet {
  private static List<Team> teams = new ArrayList<>();
  private static List<String> leagues = new ArrayList<>();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String q = req.getParameter("q");
    String s = req.getParameter("sort");
    String league = req.getParameter("state");
    req.setAttribute("q", q);
    req.setAttribute("s", s);
    req.setAttribute("league", league);
    String query = q != null ? q : "";
    String sort = s != null ? s : "";
    String state2 = league != null ? league : "";
    List<Team> copy = new ArrayList<>(teams);
//        for(User user: users) {
//            try {
//                deepCopy.add((User)user.clone());
//            } catch (CloneNotSupportedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    if(!query.equals("")) {
      copy.removeIf(team -> !team.getTeam().contains(query.toLowerCase()));
    }
    if(!state2.equals("")) {
      copy.removeIf(user -> !user.getStadium().equals(state2));
    }
    if(!sort.equals("")) {
      if(sort.equals("az")) {
        Collections.sort(copy);
      } else {
        copy.sort((a, b) -> b.compareTo(a));
      }
    }
    req.setAttribute("teams", teams);
    req.setAttribute("states", league);
    req.getRequestDispatcher("WEB-INF/demo/hockey-team-json.jsp").forward(req, resp);
  }

  @Override
  public void init() throws ServletException {
    try {
      JSONObject json = JsonReader.readJsonFromUrl("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Ice_Hockey&c=Canada");
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      TeamFromJson teamFromJson = mapper.readValue(json.toString(), TeamFromJson.class);
//            userFromJson.getUsers().forEach(System.out::println);
      teams = teamFromJson.getTeams();

      for(Team team: teams) {

        String league = team.getLeague();
        if(!leagues.contains(league)) {
          leagues.add(league);
        }
      }
      Collections.sort(leagues);
    } catch(IOException e) {
      // TODO: Forward data error to jsp
    }

  }
}
