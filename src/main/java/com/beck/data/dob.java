package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class dob {
  @JsonProperty("date")
  private String date;
  @JsonProperty("age")
  private int age;

  public String getDate() {
    return date;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "dob{" +
        "\n\tdate='" + date + '\'' +
        ",\n\t age=" + age +
        '}';
  }
}
