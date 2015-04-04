package com.hackaton.inrange.server_data;

/**
 * Created by Boris on 04.04.2015.
 */
public class User {
    private String id;
    private String name;
    private String lastName;
    private boolean male;
    private int age;
    private String userLongitude;
    private String userLatitude;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isMale() {
        return male;
    }

    public int getAge() {
        return age;
    }

    public String getUserLongitude() {
        return userLongitude;
    }

    public String getUserLatitude() {
        return userLatitude;
    }
}
