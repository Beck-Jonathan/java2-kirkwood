package com.beck.demos.Week10;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("https://randomuser.me/api/?format=json&seed=abc&results=10&nat=us&inc=gender,name,email,phone,cell,nat&noinfo");
    //System.out.println(json.toString());
    ObjectMapper mapper = new ObjectMapper();
    Map<String,Object> personMap = mapper.readValue(json.toString(), Map.class);
    personMap.entrySet().forEach(System.out::println);
    //System.out.println(json.get("id"));
    UserFromJson userFromJson = mapper.readValue(json.toString(), UserFromJson.class);
    userFromJson.getUsers().forEach(System.out::println);
  }
}