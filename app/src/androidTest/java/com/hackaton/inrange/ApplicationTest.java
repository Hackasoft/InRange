package com.hackaton.inrange;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

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

        ParseObject gameScore = new ParseObject("GameScore2");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        String id = gameScore.getObjectId();
        gameScore.saveInBackground();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore2");
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
    }
}