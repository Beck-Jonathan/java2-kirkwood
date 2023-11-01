package com.beck.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import static com.beck.data.JsonReader.readJsonFromUrl;

public class JsonReaderHockey {

  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Ice_Hockey&c=Canada");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //Map<String,Object> map = mapper.readValue(json.toString(), Map.class);
    //map.entrySet().forEach(System.out::println);
    TeamFromJson teamFromJson = mapper.readValue(json.toString(), TeamFromJson.class);
    teamFromJson.getTeams().forEach(System.out::println);
  }
}
