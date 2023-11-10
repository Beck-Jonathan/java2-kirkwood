package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Team implements Cloneable, Serializable, Comparable <Team>{

  @JsonProperty("strTeam")
  private String strTeam;

  @JsonProperty("strLeague")
  private String strLeague;

  @JsonProperty("strStadium")
  private String strStadium;


  @JsonProperty("strStadiumLocation")
  private String strStadiumLocation;

  @JsonProperty("strStadiumCapacity")
  private int strStadiumCapacity;




  @Override
  public String toString() {
    return "Team{" +
        "\n\tTeamx='" + strTeam + '\'' +
        ",\n\t League='" + strLeague + '\'' +
        ",\n\t Stadium='" + strStadium + '\'' +
        ", \n\tStadiumLocation='" + strStadiumLocation + '\'' +
        ", \n\tStadiumCapacity=" + strStadiumCapacity +
        "\n }";
  }

  public String getstrTeam() {
    return strTeam;
  }

  public String getstrLeague() {
    return strLeague;
  }

  public String getstrStadium() {
    return strStadium;
  }

  public String getstrStadiumLocation() {
    return strStadiumLocation;
  }

  public int getstrStadiumCapacity() {
    return strStadiumCapacity;
  }

  public int compareTo(Team o) {
    int result = this.getstrTeam().compareTo(o.getstrTeam());

    return result;
  }
}
