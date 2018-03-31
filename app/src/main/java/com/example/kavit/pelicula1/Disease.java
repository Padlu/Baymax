package com.example.kavit.pelicula1;

/**
 * Created by kavit on 20-09-2017.
 */

import java.util.Map;

/**
 * Created by USER on 19-09-2017.
 */

public class Disease {
    private String name;
    private String desc;
    private Map<Integer, String> specialists;

    public Disease(String name, String desc, Map<Integer, String> specialists) {
        this.name = name;
        this.desc = desc;
        this.specialists = specialists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<Integer, String> getSpecialists() { return specialists; }

    public void setSpecialists(Map<Integer, String> specialists) { this.specialists = specialists; }

}
