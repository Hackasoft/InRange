package com.hackaton.inrange;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hackaton.inrange.server_data.Event;
import com.hackaton.inrange.server_data.EventDao;
import com.hackaton.inrange.server_data.UserDao;
import com.parse.Parse;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private String[] names;
    private String[] descriptions;
    private String[] dates;
    private String[] locations;

    private String[] imgThubs = {"http://www.brunels-old-station.co.uk/shopimages/Food-Festival.jpg",
        "http://www.theparentreport.com/wp-content/uploads/2013/08/RockConcert.jpg",
        "http://media.lvivalive.com/uploads/2011/12/maria-zankovetska-ukrainian-national-drama-theater-performance-scene.jpg",
        "http://ih.constantcontact.com/fs142/1102609499039/img/1762.jpg",
        "https://blog.hackerrank.com/wp-content/uploads/2015/01/hackny-hackathon-fall-2010-flickr-photo-sharing1.jpg"};

    private ListView mListView;
    private ListAdapter mListAdapter;
    private UserDao mUserDao;

    public static Event passedEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = this.getResources().getStringArray(R.array.names);
        descriptions = this.getResources().getStringArray(R.array.descriptions);
        dates = this.getResources().getStringArray(R.array.date);
        locations = this.getResources().getStringArray(R.array.places);

        mListView = (ListView) findViewById(R.id.main_activity_list);
        mListAdapter = new ListAdapter(this,R.id.list_item, imgThubs);

        mListView.setAdapter(mListAdapter);

        Parse.initialize(this,
                "GjPjY5gSyazmxQQ5Z0zqymhE9zPfPyUhIZj6UWQy",
                "8DLjAS0SbDNyPnL1stvBjr98sFnOXcwpx2XSahjP");

        mListAdapter.clear();

        ArrayList<Event> list = EventDao.getAllLocation();
        for (Event bb: list)
        {
            mListAdapter.add(bb);
        }

//        mListAdapter.addAll(EventDao.getAllLocation());
//        Log.d("MainActivity", Integer.toString(EventDao.getAllLocation().size()));

//        for (int i=0; i<5; i++){
//
//            mListAdapter.addAll(EventDao.getAllLocation());
//            Log.d("MainActivity", Integer.toString(EventDao.getAllLocation().size()));
//
//            mListAdapter.add(new Event(
//                    names[i],
//                    descriptions[i],
//                    dates[i],
//                    locations[i]
//            ));
//        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ArrayList<String> sendDataInArray = new ArrayList<String>(4);
//                String[] arrPassData = parent.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);

                Event event = (Event) parent.getItemAtPosition(position);

                passedEvent = event;

                intent.putExtra("longtitude",event.getLongitude());
                intent.putExtra("pic", imgThubs[position]);
                Log.d("Found",event.getLongitude());
                intent.putExtra("latitude",event.getLatitude());
                intent.putExtra("passData", mListView.getAdapter().getItem(position).toString());

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
