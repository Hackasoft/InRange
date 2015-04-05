package com.hackaton.inrange;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.hackaton.inrange.server_data.Event;
import com.hackaton.inrange.server_data.EventDao;
import com.hackaton.inrange.server_data.User;
import com.hackaton.inrange.server_data.UserDao;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

    }
    public void testParse()
    {

       /* ParseObject gameScore = new ParseObject("GameScore2");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        String id = gameScore.getObjectId();
        gameScore.saveInBackground();
       */
        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore2");
        query.whereEqualTo("playerName", "Sean Plott");
        List<ParseObject> list = new ArrayList<ParseObject>();
        try {
         list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("initialized","Ura"+list.size());
        Log.d("initialized","URA"+list.get(0).getInt("score"));
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        if (list.size()!=0)  Assert.assertEquals(list.get(0).getInt("score"),1337);
        else Assert.assertFalse(true);
        User a = new User("12333","qwewqe","bhjgads",true,22);
        UserDao.addUser(a);
        ParseQuery<ParseObject> query = ParseQuery.getQuery(UserDao.UserClassName);
       // query.whereEqualTo("playerName", "Sean Plott");
        List<ParseObject> list = new ArrayList<ParseObject>();
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("UserDao_add","After1"+list.size());
        UserDao.addUser(a);
        query = ParseQuery.getQuery(UserDao.UserClassName);
       // query.whereEqualTo("playerName", "Sean Plott");
      //  List<ParseObject> list = new ArrayList<ParseObject>();
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("UserDao_add","After2"+list.size());*/
        ArrayList<Event> list = EventDao.getAllLocation();
        Assert.assertEquals(list.get(0).getDate(),"today");
        Assert.assertEquals(list.size(),5);
        Log.d("Events","went "+list.size());
    }
    public void testEvents()
    {
       /* Event a = new Event("Hackaton","Mobi dev","today","Donskaya str. 4A");
        EventDao.createEvent(a);
        Event b = new Event("Food festival","Sushi","tomorrow","Peremogi avn. 34");
        EventDao.createEvent(b);
        Event c = new Event("Rock concert","Pink Floyd in Kiev!!","06.04.2015","Explanadna str. 1");
        EventDao.createEvent(c);
        Event d = new Event("Theater drama","Some text","monday next week","Lvovska str. 321");
        EventDao.createEvent(d);
        Event e = new Event("Book presentation","Book 6 \"ice and fire\"","30.04.2019","Lounge avn. 123");
        EventDao.createEvent(e);
        */ArrayList<Event> list = EventDao.getAllLocation();
        Assert.assertEquals(list.get(0).getDate(),"today");
        Assert.assertEquals(list.size(),5);
        Log.d("Events","went "+list.size());

    }
}