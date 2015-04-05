package com.hackaton.inrange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackaton.inrange.server_data.Event;
import com.hackaton.inrange.server_data.User;

/**
 * Created by Андрей on 04.04.2015.
 */
public class PersonAdapter extends ArrayAdapter<User> {
    private Context mContext;
    private int mResource;

    public PersonAdapter(Context context, int resource) {
        super(context,resource);
        this.mContext = context;
        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Event event = getItem(position);
        User user = getItem(position);

        View viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.person_list_item, null);
        }

        ImageView imageView = (ImageView) convertView
                .findViewById(R.id.person_list_item_imageview);

        imageView.setImageResource(R.drawable.male);

        ((TextView) convertView.findViewById(R.id.person_list_item_textview))
                .setText(user.getName());

        //new TaskDownloadImage(imageView).execute(recentTrack.trackImageURL);
        //new DownloadImageLoader(context, imageView, recentTrack.trackImageURL).forceLoad();
        //Picasso.with(mContext).load(recentTrack.trackImageURL).into(imageView);

        return convertView;
    }
}

//class Event {
//    private String name;
//    private String description;
//    private String date;
//    private String location;
//
//
//    public Event (String name, String description, String date, String location){
//        this.setName(name);
//        this.setDescription(description);
//        this.setDate(date);
//        this.setLocation(location);
//    }
//
//    @Override
//    public String toString() {
//        return getName() + '\n' + getDate() + '\n' + getLocation();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDesctiption() {
//        return description;
//    }
//
//    public void setDescription(String description){
//        this.description = description;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//}
