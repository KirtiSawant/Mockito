package com.tutorial;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class WorldDictionary implements Dictionary {

    private Map<String,String > worldMap;
    public WorldDictionary(){
        worldMap=new HashMap<String ,String>();

    }
    public void add(String word,String meaning){
        worldMap.put(word,meaning);
    }
    public String getMeaning(String word){
        return worldMap.get(word);
    }



}
