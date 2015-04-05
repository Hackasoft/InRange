package com.hackaton.inrange;

import java.util.Locale;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class DetailsActivity extends ActionBarActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    private TextView tabTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tabTextView = (TextView) findViewById(R.id.section_label);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });






        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }









    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return "Map".toUpperCase(l);
            }
            return null;
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private TextView nameTextView;
        private TextView dateTextView;
        private boolean mFlagMapCreation = false;
        GoogleMap map;
        Marker marker;
        Marker marker1;
        GPSTracker gps;
        CircleOptions circleOptions;
        SupportMapFragment mapFragment;
        final String TAG = "myLogs";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        double lo ;
        double la;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView;


            //container.removeView(rootView);
            Intent intent = getActivity().getIntent();
            String[] recievedArray = intent.getStringExtra("passData").split("\n");
            String lot = intent.getStringExtra("longtitude");
            String lat = intent.getStringExtra("latitude");
            lo = Double.parseDouble(lot);
             la = Double.parseDouble(lat);


//            SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map_fragment);
//            map = mapFragment.getMap();
//            init();
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.details_fragment, container, false);
                    nameTextView = (TextView) rootView.findViewById(R.id.detail_name_textview);
                    dateTextView = (TextView) rootView.findViewById(R.id.detail_date_textview);
                    nameTextView.setText(recievedArray[0]);
                    dateTextView.setText(recievedArray[1]);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_details, container, false);








                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.map_fragment, container, false);

                    mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment_id);

                    map = mapFragment.getMap();
//                    initMap();

                    Log.d("SUPERTAG", "After map inflating!");
                    if (map == null) {
                        getActivity().finish();
                    }
                    init();
                    Log.d("SUPERTAG", "After init!");



                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_details, container, false);
                    break;
            }

            Log.d("NOT FROM CASE", "HELLO");
            return rootView;
        }

        public void initMap(){
            if (!mFlagMapCreation){
                mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment_id);
                map = mapFragment.getMap();
                mFlagMapCreation = true;
            }

        }


        public void init(){
            Log.d("SUPERTAG", "INSIDE INIIT METHOD!!");
            map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    Log.d("ClickListener", "onMapClick: " + latLng.latitude + "," + latLng.longitude);

                    if (marker!=null){
                        marker.remove();
                    }
                    Log.d("Found",lo + " "+ la);
                    marker = map.addMarker(new MarkerOptions()
                            .position(new LatLng(latLng.latitude,  latLng.longitude))
                            .title(latLng.latitude + " " + latLng.longitude));


                }
            });

            map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(LatLng latLng) {
                    Log.d("LongClickListener", "onMapLongClick: " + lo + "," + la);
                    gps = new GPSTracker(getActivity());

                    marker1 = map.addMarker(new MarkerOptions()
                            .position(new LatLng(lo,  la))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                            .title(la + " " + lo));




                    // check if GPS enabled
                    if (gps.canGetLocation()) {



                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();

                        if (marker != null) {
                            marker.remove();
                        }
                        marker = map.addMarker(new MarkerOptions()
                                .position(new LatLng(latitude, longitude))

                                .title(latitude + " " + longitude));
                        if (circleOptions != null) {
                            circleOptions.visible(false);
                        }
                        circleOptions = new CircleOptions()
                                .center(new LatLng(latitude, longitude))
                                .strokeWidth(1)
                                .strokeColor(-16711681)
                                .radius(100);
                        map.addCircle(circleOptions);

                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(
                                new LatLngBounds(new LatLng(la, lo), new LatLng(latitude, longitude)),
                                100);
                        map.animateCamera(cameraUpdate);

//                        CameraPosition cameraPosition = new CameraPosition.Builder()
//                                .target(new LatLng(latitude, longitude))
//                                .zoom(16)
//                                .tilt(20)
//                                .build();
//                        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
//                        map.animateCamera(cameraUpdate);
                    }
                }
            });

            map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

                @Override
                public void onCameraChange(CameraPosition camera) {
                    Log.d(TAG, "onCameraChange: " + camera.target.latitude + "," + camera.target.longitude);
                }
            });

        }



        public void changeType(){
            if (map.getMapType()!=GoogleMap.MAP_TYPE_SATELLITE)
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            else
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        }

    }

}
