package com.hackaton.inrange.server_data;

import com.parse.ParseObject;

import java.util.ArrayList;

/**
 * Created by Boris on 04.04.2015.
 */
public class Event {
    private String id;
    private String name;
    private String description;
    private String date;
    private String location;
    private String longitude;
    private String latitude;
    private ArrayList<User> users;

    public Event (String name, String description, String date, String location){
        this.setName(name);
        this.setDescription(description);
        this.setDate(date);
        this.setLocation(location);
        users = new ArrayList<User>();
    }
    public Event(ParseObject zz)
    {
        id = zz.getObjectId();
        name = zz.getString(EventDao.EventName);
        description = zz.getString(EventDao.EventDescription);
        date = zz.getString(EventDao.EventDate);
        location = zz.getString(EventDao.EventLocation);
        latitude = zz.getString(EventDao.EventLatitude);
        longitude = zz.getString(EventDao.EventLongitude);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesctiption() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return getName() + '\n' + getDate() + '\n' + getLocation();
    }
}
