package com.beck.DataAccess;

import com.beck.model.User;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConnection{
  public static void main(String[] args) throws SQLException {

    getConnection();
    List<User> users= getAll();
    for (int i=0;i<users.size();i++){
      System.out.println(users.get(i).toString());
    }
  }
  public static List<User> getAll() {
    List<User> list = new ArrayList<>();
    try (Connection connection = getConnection()) { //connection came from driver manager
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_get_all_users()}")) {
          try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
              int id = resultSet.getInt("id");
              String firstName = resultSet.getString("first_name");
              String lastName = resultSet.getString("last_name");
              String email = resultSet.getString("email");
              String phone = resultSet.getString("phone");
              char[] password = resultSet.getString("password").toCharArray();
              String language = resultSet.getString("language");
              String status = resultSet.getString("status");
              String privileges = resultSet.getString("privileges");
              Instant created_at = resultSet.getTimestamp("created_at").toInstant();
              Instant last_logged_in = resultSet.getTimestamp("last_logged_in").toInstant();
              Instant updated_at = resultSet.getTimestamp("updated_at").toInstant();
              User user = new User(id, firstName, lastName, email, phone, password, language, status, privileges, created_at, last_logged_in, updated_at);
              list.add(user);
            }

          }



        }

      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
      System.out.println("Code: " + e.getErrorCode());
      System.out.println("SQL State: " + e.getSQLState());
    }
    return list;
  }
}
