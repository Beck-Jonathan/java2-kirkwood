package com.beck.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Artist {
  @JsonProperty("Name")
  private String Name;
  @JsonProperty("Picture")
  private String Picture;

  public Artist(String name, String picture) {
    Name = name;
    Picture = picture;
  }

  @Override
  public String toString() {
    return "Artist{" +
        "Name='" + Name + '\'' +
        ", Picture='" + Picture + '\'' +
        '}';
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getPicture() {
    return Picture;
  }

  public void setPicture(String picture) {
    Picture = picture;
  }
}
