package com.beck.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
  @JsonProperty("uuid")
  private String uuid ;

  @JsonProperty("username")
  private String username ;

  @JsonProperty("password")
  private String password  ;

  @JsonProperty("salt")
  private String salt ;

  @JsonProperty("md5")
  private String md5 ;

  @JsonProperty("sha1")
  private String sha1 ;

  @JsonProperty("sha256")
  private String sha256;

  public String getUuid() {
    return uuid;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getSalt() {
    return salt;
  }

  public String getMd5() {
    return md5;
  }

  public String getSha1() {
    return sha1;
  }

  public String getSha256() {
    return sha256;
  }

  @Override
  public String toString() {
    return "login{" +
        "\n\tuuid='" + uuid + '\'' +
        ",\n\t username='" + username + '\'' +
        ",\n\t password='" + password + '\'' +
        ",\n\t salt='" + salt + '\'' +
        ",\n\t md5='" + md5 + '\'' +
        ",\n\t sha1='" + sha1 + '\'' +
        ",\n\t sha256='" + sha256 + '\'' +
        '}';
  }
}
