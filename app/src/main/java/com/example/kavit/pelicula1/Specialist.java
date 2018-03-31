package com.example.kavit.pelicula1;

import java.util.Map;

/**
 * Created by abhishekpadalkar on 3/31/18.
 */

public class Specialist {

    private String name;
    private String email;
    private String kind;
    private String loc;

    public Specialist() {}

    public Specialist(String name, String email, String kind, String loc) {
        // [START_EXCLUDE]
        this.name = name;
        this.email = email;
        this.kind = kind;
        this.loc = loc;
        // [END_EXCLUDE]
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getKind() { return kind; }

    public void setKind(String kind) { this.kind = kind; }

    public String getLoc() { return loc; }

    public void setLoc(String loc) { this.loc = loc; }

}
// [END specialist_class]