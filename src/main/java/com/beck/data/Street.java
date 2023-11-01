package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Street implements Serializable {
  @JsonProperty("number")
  private String number;
  @JsonProperty("name")
  private String name;

  @Override
  public String toString() {
    return "{" +
        "\n\t\tnumber='" + number + '\'' +
        "\n\t\tname='" + name + '\'' +
        "\n\t}";
  }

  public String getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }
}
