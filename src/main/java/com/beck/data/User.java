package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class User implements Serializable {
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
  @JsonProperty("login")
  private String login;

  @JsonProperty("dob")
  private String dob;

  @JsonProperty("registered")
  private String resgistered;
  @JsonProperty("id")
  private  String ID;

  @JsonProperty("picture")
  private  String picture;

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
        "\n\tRegistered='" + resgistered + '\'' +
        "\n\tID='" + ID + '\'' +
        "\n\tPicture='" + picture + '\'' +
        "\n\tlogin='" + login  + '\'' +
        "\n\tdob='" + dob + '\'' +

        "\n}";
  }

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
}

class Name  implements Serializable{
  @JsonProperty("title")
  private String title;
  @JsonProperty("first")
  private String first;
  @JsonProperty("last")
  private String last;

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

class Location implements Serializable {
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

  @Override
  public String toString() {
    return "{" +
        "\n\t\tstreet=" + street +
        "\n\t\tcity='" + city + '\'' +
        "\n\t\tstate='" + state + '\'' +
        "\n\t\tcountry='" + country + '\'' +
        "\n\t\tpostcode='" + postcode + '\'' +
        "\n\t\tcoordinates=" + coordinates +
        "\n\t\ttimezone=" + timezone +
        "\n\t}";
  }

  public Street getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  public String getPostcode() {
    return postcode;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Timezone getTimezone() {
    return timezone;
  }
}

class Street implements Serializable {
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
class Timezone implements Serializable{
  @JsonProperty("offset")
  private String offset;
  @JsonProperty("description")
  private String description;

  @Override
  public String toString() {
    return "{" +
        "\n\t\toffset='" + offset + '\'' +
        "\n\t\tdescription='" + description + '\'' +
        "\n\t}";
  }

  public String getOffset() {
    return offset;
  }

  public String getDescription() {
    return description;
  }
}
class Coordinates  implements Serializable{
  @JsonProperty("latitude")
  private String latitude;
  @JsonProperty("longitude")
  private String longitude;

  @Override
  public String toString() {
    return "{" +
        "\n\t\tlatitude='" + latitude + '\'' +
        "\n\t\tlongitude='" + longitude + '\'' +
        "\n\t}";
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }
}