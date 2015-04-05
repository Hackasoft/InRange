package com.hackaton.inrange;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Log;


import com.hackaton.inrange.server_data.User;
import com.hackaton.inrange.server_data.UserHolder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Boris on 04.03.2015.
 *
 * DownloadProfile class read some profile data from VK server and write this data to file
 * @author Boris
 */
public class DownloadProfile extends AsyncTask<Void,Void,String> {
    /**
     *the url of request to VK server
     */
    private String url;
    /**
     * the name of file
     */
    private  String FileUrl = "profile.txt";

    /**
     *
     * @param url - the url of request to VK server
     */
    public DownloadProfile(String url)
    {
        this.url = url;
    }

    /**
     *
     * @param inputStream the stream with the data which must be converted to String
     * @return String with the profile data
     * @throws java.io.IOException
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String convertInputStreamToString(InputStream inputStream) throws IOException {
        String result = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
        String line = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;
            Log.d("Ura",result);
    }catch (IOException e) {

        }
        finally {
            inputStream.close();
        }
        return result;
    }

    /**
     *
     * @param parsing String with the profile data
     */
    public void initializeUser(String parsing)
    {
        int id = Integer.parseInt(parsing.split("\"uid\":")[1].split(",")[0]);
        String firstName = parsing.split("\"first_name\":\"")[1].split("\",")[0];
        String lastName = parsing.split("\"last_name\":\"")[1].split("\"")[0];
        Log.d("token",""+id);
        Log.d("token",""+firstName);
        Log.d("token", "" + lastName);
        UserHolder.applicationUser = new User(""+id,firstName,lastName,true,20);
    }
    /**
     * main method of AsyncTask
     */
    @Override
    protected String doInBackground(Void... params) {
        InputStream inputStream = null;
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            Log.d("token", url);
            System.out.println("err");
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            Log.d("token","it works1");            // receive response as inputStream

            inputStream = httpResponse.getEntity().getContent();
            String result = "";
            Log.d("token","it really works");
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
            Log.d("token", result);
            initializeUser(result);
            //writeToFile();
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return "made";
    }

    /**
     * the method which write data to file
     */



}
