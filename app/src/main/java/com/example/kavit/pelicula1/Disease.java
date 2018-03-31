package com.example.kavit.pelicula1;

/**
 * Created by kavit on 20-09-2017.
 */

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by USER on 19-09-2017.
 */

public class Disease {
    private String name;
    private String desc;
    private ArrayList<String> specialists;
    private Integer count = 0;

    public Disease(){}

    public Disease(String name, String desc, ArrayList<String> specialists) {
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

    public ArrayList<String> getSpecialists() { return specialists; }

    public void setSpecialists(ArrayList<String> specialists) { this.specialists = specialists; }

    public Integer getCount(){ return count; }

}
