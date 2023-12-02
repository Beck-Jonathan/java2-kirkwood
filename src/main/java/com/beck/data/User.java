package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class User implements Cloneable, Serializable, Comparable <User>{
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

  @JsonProperty("registered")
  private Registered registered;

  @JsonProperty("id")
  private Id id;

  @JsonProperty("login")
  private Login login;

  @JsonProperty("dob")
  private Dob dob;



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
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public int compareTo(User o) {
    int result = this.getName().getLast().compareTo(o.getName().getLast());
    if (result==0){
      result = this.getName().getFirst().compareTo(o.getName().getFirst());

    }
    return result;
  }

  public Registered getRegistered() {
    return registered;
  }

  public Id getId() {
    return id;
  }

  public Login getLogin() {
    return login;
  }

  public Dob getDob() {
    return dob;
  }

  @Override
  public String toString() {
    return "User{" +
        "\n\tgender='" + gender + '\'' +
        ", \n\tname=" + name +
        ", \n\temail='" + email + '\'' +
        ", \n\tphone='" + phone + '\'' +
        ", \n\tcell='" + cell + '\'' +
        ", \n\tnat='" + nat + '\'' +
        ", \n\tlocation=" + location +
        ", \n\tpicture=" + picture +
        ", \n\tregistered=" + registered +
        ", \n\tid=" + id +
        ", \n\tlogin=" + login +
        ", \n\tdob=" + dob +
        '}';
  }
}