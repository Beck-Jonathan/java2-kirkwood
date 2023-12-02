package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registered {
  @JsonProperty("date")
  private String date;
  @JsonProperty("age")
  private String age;

  public String getDate() {
    return date;
  }

  public String getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "registered{" +
        "\n\tdate='" + date + '\'' +
        ",\n\t age='" + age + '\'' +
        '}';
  }
}
