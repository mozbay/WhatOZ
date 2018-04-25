package com.whatoz.application.aphorism.HttpProcess;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by muratozbay on 25.04.2018.
 */

public class ParseToObject {

    public static ArrayList<String> parseObjectDeneme(JSONArray resJsonArray) {

        try {
            JSONObject jsonObject = resJsonArray.getJSONObject(0);
            Log.e("PARSE_USERNAME", jsonObject.getString("username"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
