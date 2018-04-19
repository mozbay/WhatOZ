package com.whatoz.application.aphorism.HttpProcess;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by muratozbay on 18.04.2018.
 */

public class HttpPostObject {

    String json = "";
    public static final String TAG = "HttpPostObject";

    public String httpGet(String url) throws JSONException {
        try {
            InputStream inInputStream = null;
            URL stringUrl;
            try {
                stringUrl = new URL(url);
                URLConnection urlConnection = null;

                try {
                    urlConnection = stringUrl.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Log.e(TAG, url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(3000);

                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        inInputStream = httpURLConnection.getInputStream();
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        inInputStream, "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                inInputStream.close();
                json = builder.toString();

            } catch (Exception e) {
                Log.e("Buffered Error", "Error converting result: " + e.toString());
            }


            return json;
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String HttpPost(String url, JSONObject jsonObject) throws JSONException {

        try {
            InputStream inInputStream = null;
            URL stringUrl;
            try {
                stringUrl = new URL(url);
                URLConnection urlConnection = null;

                try {
                    urlConnection = stringUrl.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Log.e(TAG, url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(3000);

                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        inInputStream = httpURLConnection.getInputStream();
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        inInputStream, "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                inInputStream.close();
                json = builder.toString();

            } catch (Exception e) {
                Log.e("Buffered Error", "Error converting result: " + e.toString());
            }


            return json;
        } catch (Exception e) {
            return e.toString();
        }

    }
}


