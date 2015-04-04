package com.hackaton.inrange.server_data;

import android.os.AsyncTask;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import bolts.Task;

/**
 * Created by Boris on 04.04.2015.
 */
public class UserDao {
    public final static String UserClassName = "Users";
    public final static String UserID = "userid";
    public final static String UserName = "userName";
    public final static String UserLastName = "UserLastName";
    public final static String UserAge = "UserAge";
    public final static String UserMale = "UserMale";
    public final static String UserLatitude = "UserLatitude";
    public final static String UserLongitude = "UserLongitude";
    public static void addUser(User a)
    {
        ParseObject z = new ParseObject(UserClassName);
        z.put(UserID,a.getId());
        z.put(UserName,a.getName());
        z.put(UserLastName,a.getLastName());
        z.put(UserAge,a.getAge());
        z.put(UserMale,a.isMale());
        z.put(UserLatitude,a.getUserLatitude());
        z.put(UserLongitude,a.getUserLongitude());
        z.saveInBackground();
   //     z.put(UserID);
    }
    public static void updateUserLocation(String latitude,String longitude)
    {

    }
}
