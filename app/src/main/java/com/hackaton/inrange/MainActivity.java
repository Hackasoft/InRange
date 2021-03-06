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

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private String[] names;
    private String[] descriptions;
    private String[] dates;
    private String[] locations;

    private ListView mListView;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = this.getResources().getStringArray(R.array.names);
        descriptions = this.getResources().getStringArray(R.array.descriptions);
        dates = this.getResources().getStringArray(R.array.date);
        locations = this.getResources().getStringArray(R.array.places);

        mListView = (ListView) findViewById(R.id.main_activity_list);
        mListAdapter = new ListAdapter(this,R.id.list_item);

        mListView.setAdapter(mListAdapter);

        mListAdapter.clear();
        ArrayList<Event> list = EventDao.getAllLocation();
        for (Event bb: list)
        {
            mListAdapter.add(bb);
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// ArrayList<String> sendDataInArray = new ArrayList<String>(4);
// String[] arrPassData = parent.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                Event event = (Event) parent.getItemAtPosition(position);
                Log.d("Found",event.getName());
                intent.putExtra("longtitude",event.getLongitude());
                Log.d("Found",event.getLongitude());
                intent.putExtra("latitude",event.getLatitude());
                intent.putExtra("passData", mListView.getAdapter().getItem(position).toString());
                startActivity(intent);
            }
        });
       /* for (int i=0; i<5; i++){
            mListAdapter.add(new Event(
                    names[i],
                    descriptions[i],
                    dates[i],
                    locations[i]
            ));
        }*/
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
