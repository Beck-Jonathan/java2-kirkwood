package com.beck.DataAccess;

import com.beck.data.Team;
import com.beck.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO extends DBConnection{

  public static void main(String[] args) throws SQLException {

    getConnection();
    List<Team> teams= getAll();
    for (int i=0;i<teams.size();i++){
      System.out.println(teams.get(i).toString());
    }
  }
  public static List<Team> getAll() {
    List<Team> list = new ArrayList<>();
    try (Connection connection = getConnection()) { //connection came from driver manager
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Team()}")) {
          try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {

              String strTeam = resultSet.getString("Team_ID");
              String strLeague = resultSet.getString("League");
              String strStadium = resultSet.getString("Stadium_Name");
              String strStadiumLocation = resultSet.getString("Stadium_Location");
              //String strStadiumCapacity = resultSet.getString("password")

              Team team = new Team(strTeam,strLeague,strStadium,strStadiumLocation,0);
              list.add(team);

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


