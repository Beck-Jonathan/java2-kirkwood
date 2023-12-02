package com.beck.controller;

import com.beck.model.User;
import com.beck.DataAccess.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import static com.beck.Project.utilities.PasswordUtility.checkpw;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
  private static Map<String, String> results = new HashMap<>();
  public static int invalidAttempts = 0;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/demo/login.jsp").forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("inputEmail1");
    String password1 = req.getParameter("inputPassword1");
    String[] rememberMe = req.getParameterValues("rememberMe");

    results.clear();
    results.put("email", email);
    results.put("password1", password1);
    if (rememberMe != null && rememberMe[0].equals("true")) {
      results.put("rememberMe", rememberMe[0]);
    } else {
      results.put("rememberMe", "");
    }
    try {
      User userFromDatabase = UserDAO.get(email);
      if (userFromDatabase == null) {
        invalidAttempts++;
        results.put("loginFail", "No user found with that email and password combination. You have used" + invalidAttempts+" attempts. On your 5th" +
            " unsuccessful attempt, the account will be locked.");

      } else {
        if (!checkpw(password1, String.valueOf(userFromDatabase.getPassword()))) {
          invalidAttempts++;
          results.put("loginFail", "No user found with that email and password combination. You have used" + invalidAttempts+" attempts. On your 5th" +
              " unsuccessful attempt, the account will be locked.");

          if (invalidAttempts > 4) {
            userFromDatabase.setStatus("locked");

            UserDAO.update(userFromDatabase);
            results.put("loginFail", "Account locked, you must reset your password to continue");
          }
        } else {
          results.clear();
          results.put("loginSuccess", "Welcome back " + userFromDatabase.getEmail());
          invalidAttempts = 0;
        }

      }
    } catch (RuntimeException | NoSuchAlgorithmException | InvalidKeySpecException e) {
      results.put("loginFail", "Can not log you in, try again later.");
    }

    req.setAttribute("results", results);
    req.getRequestDispatcher("WEB-INF/demo/login.jsp").forward(req, resp);
  }
}
