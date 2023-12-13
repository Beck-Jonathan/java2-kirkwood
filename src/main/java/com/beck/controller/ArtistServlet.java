package com.beck.controller;

import com.beck.data.ArtistFromJson;
import com.beck.data.JsonReader;
import com.beck.data.User;
import com.beck.data.UserFromJson;
import com.beck.model.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@WebServlet(name = "artistDBServlet", value = "/view-artist")
public class ArtistServlet  extends HttpServlet {
  private static Artist artist;
  private static List<Artist> artists;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    init();
    req.setAttribute("artists", artists);



    req.getRequestDispatcher("WEB-INF/demo/view-artist.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPut(req, resp);
  }

  @Override
  public void init() throws ServletException {
    try {
      JSONObject json = JsonReader.readJsonFromUrl("https://randomuser.me/api/?format=json&seed=abc&results=20&nat=us&noinfo");
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      ArtistFromJson artistFromJson = mapper.readValue(json.toString(), ArtistFromJson.class);
           artistFromJson.getArtists().forEach(System.out::println);
      System.out.println("x'");
      artists = artistFromJson.getArtists();


    } catch(IOException e) {
      // TODO: Forward data error to jsp
    }
  }
  }
