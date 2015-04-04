package com.hackaton.inrange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackaton.inrange.server_data.Event;

/**
 * Created by Андрей on 04.04.2015.
 */
public class ListAdapter extends ArrayAdapter<Event> {
    private Context mContext;
    private int mResource;

    public ListAdapter(Context context, int resource) {
        super(context,resource);
        this.mContext = context;
        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = getItem(position);

        View viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.main_activity_list_item, null);
        }

        ImageView imageView = (ImageView) convertView
                .findViewById(R.id.event_pic_list_item_imageview);

        imageView.setImageResource(R.drawable.male);

        ((TextView) convertView.findViewById(R.id.event_name_list_item_textview))
                .setText(event.getName());
        ((TextView) convertView.findViewById(R.id.event_short_description_list_item_textview))
                .setText(event.getDesctiption());
        ((TextView) convertView.findViewById(R.id.event_date_list_item_textview))
                .setText(event.getDate());
        ((TextView) convertView.findViewById(R.id.event_distance_list_item_textview))
                .setText(event.getLocation());

        //new TaskDownloadImage(imageView).execute(recentTrack.trackImageURL);
        //new DownloadImageLoader(context, imageView, recentTrack.trackImageURL).forceLoad();
        //Picasso.with(mContext).load(recentTrack.trackImageURL).into(imageView);

        return convertView;
    }
}



