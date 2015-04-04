package com.hackaton.inrange.server_data;

import java.util.ArrayList;

/**
 * Created by Boris on 04.04.2015.
 */
public class UserHolder {
    public static User applicationUser ;
    public static ArrayList<User> currentUsers;
    static {
        applicationUser = new User();
        currentUsers = new ArrayList<>();
    }
}
