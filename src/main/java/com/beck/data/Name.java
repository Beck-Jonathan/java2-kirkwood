package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class  Name implements Serializable {
  @JsonProperty("title")
  private String title;
  @JsonProperty("first")
  private String first;
  @JsonProperty("last")
  private String last;

  public String fullName() {
    return first + " " + last;
  }

  @Override
  public String toString() {
    return "{" +
        "\n\t\ttitle='" + title + '\'' +
        "\n\t\tfirst='" + first + '\'' +
        "\n\t\tlast='" + last + '\'' +
        "\n\t}";
  }

  public String getTitle() {
    return title;
  }

  public String getFirst() {
    return first;
  }

  public String getLast() {
    return last;
  }
}
