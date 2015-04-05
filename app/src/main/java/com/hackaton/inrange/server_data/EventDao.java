package com.hackaton.inrange.server_data;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 04.04.2015.
 */
public class EventDao {
    public final static String ClassEventName = "EventClass2";
    public final static String EventName = "name";
    public final static String EventDescription = "description";
    public final static String EventDate = "date";
    public final static String EventLocation = "location";
    public final static String EventLongitude = "longitude";
    public final static String EventLatitude = "latitude";
    public static ArrayList<Event> getAllLocation()
    {
        ParseObject object = new ParseObject(ClassEventName);
        ParseQuery<ParseObject> query = ParseQuery.getQuery(ClassEventName);
        List<ParseObject> list = new ArrayList<ParseObject>();
        ArrayList<Event> events = new ArrayList<>();
        try {
            list = query.find();
            if (list.size()!=0)
            {
                for (ParseObject event: list)
                {
                    Event newEvent = new Event(event);
                    events.add(newEvent);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return events;
    }
    public static void createEvent(Event event)
    {
        ParseObject object = new ParseObject(ClassEventName);
        object.put(EventName,event.getName());
        object.put(EventDescription,event.getDesctiption());
        object.put(EventDate,event.getDate());
        object.put(EventLocation,event.getLocation());
        object.saveInBackground();
        Log.d("ran", "good1");
    }
    public static void createEvent(Event event,String eventLatitude,String eventLongitude)
    {
        ParseObject object = new ParseObject(ClassEventName);
        object.put(EventName,event.getName());
        object.put(EventDescription,event.getDesctiption());
        object.put(EventDate,event.getDate());
        object.put(EventLocation,event.getLocation());
        object.put(EventLatitude,eventLatitude);
        object.put(EventLongitude,eventLongitude);
        object.saveInBackground();
        Log.d("ran", "good1");
    }
}
