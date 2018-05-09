package com.whatoz.application.aphorism.HttpProcess;

import android.util.Log;

import com.whatoz.application.aphorism.Applicaiton.App;
import com.whatoz.application.aphorism.Model.User;
import com.whatoz.application.aphorism.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by muratozbay on 25.04.2018.
 */

public class ParseToObject {

    public static final String TAG = "ParseToObject";


    public static User parseObjectUser(JSONArray resultJsonArray) {
        try {

            JSONObject jsonObject = resultJsonArray.getJSONObject(0);
            User user = new User();

            user.setuId(jsonObject.has(App.getContext().getString(R.string._uid)) ? jsonObject.getString(App.getContext().getString(R.string._uid)) : "");
            user.setMobileNumber(jsonObject.has(App.getContext().getString(R.string._mobileNumber)) ? jsonObject.getInt(App.getContext().getString(R.string._mobileNumber)) : 0);
            user.setEmail(jsonObject.has(App.getContext().getString(R.string._email)) ? jsonObject.getString(App.getContext().getString(R.string._email)) : "");
            user.setUserName(jsonObject.has(App.getContext().getString(R.string._username)) ? jsonObject.getString(App.getContext().getString(R.string._username)) : "");
            user.setPassword(jsonObject.has(App.getContext().getString(R.string._password)) ? jsonObject.getString(App.getContext().getString(R.string._password)) : "");
            return user;
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
            return null;
        }
    }

    public static User parseObjectUser(JSONObject jsonObject) {
        try {

            User user = new User();

            user.setuId(jsonObject.has(App.getContext().getString(R.string._uid)) ? jsonObject.getString(App.getContext().getString(R.string._uid)) : "");
            user.setMobileNumber(jsonObject.has(App.getContext().getString(R.string._mobileNumber)) ? jsonObject.getInt(App.getContext().getString(R.string._mobileNumber)) : 0);
            user.setEmail(jsonObject.has(App.getContext().getString(R.string._email)) ? jsonObject.getString(App.getContext().getString(R.string._email)) : "");
            user.setUserName(jsonObject.has(App.getContext().getString(R.string._username)) ? jsonObject.getString(App.getContext().getString(R.string._username)) : "");
            user.setPassword(jsonObject.has(App.getContext().getString(R.string._password)) ? jsonObject.getString(App.getContext().getString(R.string._password)) : "");
            return user;
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
            return null;
        }
    }


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
