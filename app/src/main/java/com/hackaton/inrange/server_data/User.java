package com.hackaton.inrange.server_data;

import com.parse.ParseObject;

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
    private String EventId;

    public User() {
        userLatitude = "";
        userLatitude = "";
        EventId = "";
    }

    public User(String id, String name, String lastName, boolean male, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.male = male;
        this.age = age;
        userLatitude = "";
        userLongitude = "";
        EventId = "";
    }
    public User(ParseObject b)
    {
        id = b.getString(UserDao.UserID);
        name = b.getString(UserDao.UserName);
        lastName = b.getString(UserDao.UserLastName);
        userLatitude = b.getString(UserDao.UserLatitude);
        userLongitude = b.getString(UserDao.UserLongitude);
        male = b.getBoolean(UserDao.UserMale);
        age = b.getInt(UserDao.UserAge);
        EventId = b.getString(UserDao.EventId);
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
