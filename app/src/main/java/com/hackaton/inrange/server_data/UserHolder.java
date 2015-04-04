package com.hackaton.inrange.server_data;

import com.hackaton.inrange.ListAdapter;

import java.util.ArrayList;

/**
 * Created by Boris on 04.04.2015.
 */
public class UserHolder {
    public static User applicationUser ;
   // public static ArrayList<User> currentUsers;
    public static ArrayList<Event> events;
    static {
        applicationUser = new User();
        events = new ArrayList<Event>();
     //   currentUsers = new ArrayList<>();
    }
}
