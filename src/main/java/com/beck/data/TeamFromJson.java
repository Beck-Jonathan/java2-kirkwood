package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamFromJson {


  @JsonProperty("teams")
  private List<Team> teams;

  public List<Team> getTeams() {
    return teams;
  }
}
