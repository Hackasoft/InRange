package com.hackaton.inrange.server_data;

import android.os.AsyncTask;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

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
    public final static String EventId = "PlaceId";
    public static void addUser(User a)
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(UserClassName);
        query.whereEqualTo(UserID, a.getId());
        List<ParseObject> list = new ArrayList<ParseObject>();
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (list.size()>0) return;
        ParseObject z = new ParseObject(UserClassName);
        Log.d("ran","good1");
        z.put(UserID,a.getId());
        z.put(UserName,a.getName());
        z.put(UserLastName,a.getLastName());
        z.put(UserAge,a.getAge());
        z.put(UserMale,a.isMale());
        z.put(UserLatitude,a.getUserLatitude());
        z.put(UserLongitude,a.getUserLongitude());
        z.saveInBackground();
        Log.d("ran","good2");
   //     z.put(UserID);
    }

    public static void updateUserLocation(String latitude,String longitude)
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(UserDao.UserClassName);
        query.whereEqualTo(UserID, UserHolder.applicationUser);
        List<ParseObject> list = new ArrayList<ParseObject>();
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (list.size() ==  1)
        {
          ParseObject object =  list.get(0);
            object.put(UserLatitude,latitude);
            object.put(UserLongitude,longitude);
            object.saveInBackground();
        }
        else Log.d("DaoUpdate","fuck") ;
    }
    public static ArrayList<User> getUsers(String Eventid){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(UserDao.UserClassName);
         query.whereEqualTo(UserDao.EventId, Eventid);
        List<ParseObject> list = new ArrayList<ParseObject>();
        ArrayList<User> users = new ArrayList<>();
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (list.size()!=0)
        {
            for (ParseObject o: list)
            {
                User z = new User(o);
                users.add(z);
            }
            return users;
        }
        return users;
    }
}
