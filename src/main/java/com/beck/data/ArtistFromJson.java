package com.beck.data;

import com.beck.model.Artist;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistFromJson {

  @JsonProperty("results")
  private List<Artist> artists;

  public List<Artist> getArtists() {
    return artists;
  }
}
