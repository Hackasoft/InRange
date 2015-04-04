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
    private String userLongitude ;
    private String userLatitude;

    public User() {
        userLatitude = "";
        userLatitude = "";
    }

    public User(String id, String name, String lastName, boolean male, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.male = male;
        this.age = age;
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserLongitude(String userLongitude) {
        this.userLongitude = userLongitude;
    }

    public void setUserLatitude(String userLatitude) {
        this.userLatitude = userLatitude;
    }
}
