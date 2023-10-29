package com.beck.demos.Week10;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UserFromJson {
  @JsonProperty("results")
  private List<User> users;

  public List<User> getUsers() {
    return users;
  }
}
class User {
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("gender")
  private String gender;

  @JsonProperty("cell")
  private String cell;

  @JsonProperty("nat")
  private String nat;
  @JsonProperty("name")
  private Name name;
  @JsonProperty("location")
  private Location location;


  @Override
  public String toString() {
    return "User{" +
        "\n\tgender='" + gender + '\'' +
        ",\n\tname='" + name + '\'' +
        ",\n\tlocation='" + location + '\'' +
        ",\n\temail='" + email + '\'' +
        ",\n\tphone='" + phone + '\'' +
        ",\n\tcell='" + cell + '\'' +
        ",\n\tnat='" + nat + '\'' +
        "\n}\n";
  }
}
class Name {
  @JsonProperty("title")
  private String title;
  @JsonProperty("first")
  private String first;
  @JsonProperty("last")
  private String last;

  @Override
  public String toString() {
    return "{" +
        "title='" + title + '\'' +
        ", first='" + first + '\'' +
        ", last='" + last + '\'' +
        '}';
  }
}
class Location {
  @JsonProperty("street")
  private Street street;

  @JsonProperty("city")
  private String city;

  @JsonProperty("state")
  private String state;

  @JsonProperty("country")
  private String country;

  @JsonProperty("postcode")
  private String postcode;

  @JsonProperty("coordinates")
  private Coordinates coordinates;

  @JsonProperty("timezone")
  private Timezone timezone;
}
class Street {
  @JsonProperty("number")
  private String number;

  @JsonProperty("name")
  private String name;

}

class Coordinates {
  @JsonProperty("latitude")
  private String latitude;

  @JsonProperty("longitude")
  private String longitude;
}

class Timezone {
  @JsonProperty("offset")
  private String offset;

  @JsonProperty("description")
  private String description;
}