package com.example.helloworld;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class ReadJson {

    public static JSONArray read_json(String file_name) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(file_name);
        Object obj = jsonParser.parse(reader);
        JSONArray breakList = (JSONArray) obj;
        return breakList;
    }
}
