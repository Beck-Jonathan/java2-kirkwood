package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class User implements Cloneable, Serializable {
  @JsonProperty("gender")
  private String gender;
  @JsonProperty("name")
  private Name name;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("cell")
  private String cell;
  @JsonProperty("nat")
  private String nat;
  @JsonProperty("location")
  private Location location;
  @JsonProperty("picture")
  private Picture picture;

  public String getGender() {
    return gender;
  }

  public Name getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getCell() {
    return cell;
  }

  public String getNat() {
    return nat;
  }

  public Location getLocation() {
    return location;
  }

  public Picture getPicture() {
    return picture;
  }

  @Override
  public String toString() {
    return "User{" +
        "\n\tgender='" + gender + '\'' +
        "\n\tname='" + name + '\'' +
        "\n\tlocation='" + location + '\'' +
        "\n\temail='" + email + '\'' +
        "\n\tphone='" + phone + '\'' +
        "\n\tcell='" +cell + '\'' +
        "\n\tnat='" + nat + '\'' +
        "\n}";
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}