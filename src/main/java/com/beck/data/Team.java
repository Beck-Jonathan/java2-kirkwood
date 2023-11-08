package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Team implements Cloneable, Serializable, Comparable <Team>{

  @JsonProperty("strTeam")
  private String Team;

  @JsonProperty("strLeague")
  private String League;

  @JsonProperty("strStadium")
  private String Stadium;


  @JsonProperty("strStadiumLocation")
  private String StadiumLocation;

  @JsonProperty("strStadiumCapacity")
  private int StadiumCapacity;


  @Override
  public int compareTo(Team o) {
    return 0;
  }

  @Override
  public String toString() {
    return "Team{" +
        "\n\tTeam='" + Team + '\'' +
        ",\n\t League='" + League + '\'' +
        ",\n\t Stadium='" + Stadium + '\'' +
        ", \n\tStadiumLocation='" + StadiumLocation + '\'' +
        ", \n\tStadiumCapacity=" + StadiumCapacity +
        "\n }";
  }

  public String getTeam() {
    return Team;
  }

  public String getLeague() {
    return League;
  }

  public String getStadium() {
    return Stadium;
  }

  public String getStadiumLocation() {
    return StadiumLocation;
  }

  public int getStadiumCapacity() {
    return StadiumCapacity;
  }
}
