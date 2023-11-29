package com.beck.DataAccess;

import com.beck.Project.utilities.PasswordUtility;
import com.beck.model.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
  public static void add(User user) {
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_add_user(?, ?)}")) {
          statement.setString(1, user.getEmail());
          String encryptedPassword = PasswordUtility.hashpw(new String(user.getPassword()));
          statement.setString(2, encryptedPassword);
          int numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not create user. Try again later");
          }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
          throw new RuntimeException("Could not create user. Try again later");
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not create user. Try again later");
    }
  }
}
