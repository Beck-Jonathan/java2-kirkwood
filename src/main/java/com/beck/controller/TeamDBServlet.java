package com.beck.controller;

import com.beck.DataAccess.TeamDAO;

import com.beck.data.Team;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "teamDBServlet", value = "/hockey-team-db")
public class TeamDBServlet extends HttpServlet {
  private static List<Team> teams;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("teams",teams);
    req.getRequestDispatcher("WEB-INF/demo/hockey-team-db.jsp").forward(req, resp);
  }

  @Override
  public void init() throws ServletException {
    teams = TeamDAO.getAll();
  }
}