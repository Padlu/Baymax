package com.example.kavit.pelicula1;

import java.util.Map;

/**
 * Created by abhishekpadalkar on 3/31/18.
 */

public class Symptom {


    private String name;
    private Map<Integer, String> d_id;

    public Symptom() {}

    public Symptom(String name, Map<Integer, String> d_id) {
        // [START_EXCLUDE]
        this.name = name;
        this.d_id = d_id;
        // [END_EXCLUDE]
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Map<Integer, String> getD_id() { return d_id; }

    public void setD_id(Map<Integer, String> d_id) { this.d_id = d_id; }

}
// [END symptom_class]