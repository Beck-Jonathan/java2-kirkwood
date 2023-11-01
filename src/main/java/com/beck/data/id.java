package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class id {
  @JsonProperty("name")
  private String name;
  @JsonProperty("value")
  private String value;

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "id{" +
        "\n\tname='" + name + '\'' +
        ",\n\t value='" + value + '\'' +
        '}';
  }
}
