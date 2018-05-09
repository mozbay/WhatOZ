package com.whatoz.application.aphorism.HttpProcess;

import com.whatoz.application.aphorism.MainActivity;
import com.whatoz.application.aphorism.NewUserActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by muratozbay on 18.04.2018.
 */

public class WhatozService {

    public String callGetMethod(String url) {
        HttpPostObject postObject = new HttpPostObject();

        try {
            String httpStr = url; // +"?" + condition
            return postObject.httpGet(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getResponseDeneme(String jso, Object viewScreen) {

        try {
            if (jso != null) {
                JSONArray jsonArray = new JSONArray(jso);
                if (jsonArray.length() > 0 && !jsonArray.isNull(0)) {
                    ((NewUserActivity) viewScreen).getDenemeResponse(ParseToObject.parseObjectDeneme(jsonArray));
                }
            }

        } catch (JSONException e1) {
            e1.printStackTrace();
        }

    }

    public String callPostMethod(String url, JSONObject jsonObject) {

        HttpPostObject postObject = new HttpPostObject();

        try {
            String httpStr = url; // +"?" + condition
            return postObject.httpPost(httpStr,jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getLoginResponse(String jso, Object viewScreen) {

        try {
            if (jso != null) {
                JSONArray jsonArray = new JSONArray(jso);
                if (jsonArray.length() > 0 && !jsonArray.isNull(0)) {
                    ((MainActivity) viewScreen).getLoginResponse(ParseToObject.parseObjectUser(jsonArray));
                }
            }

        } catch (JSONException e1) {
            e1.printStackTrace();
        }

    }
}
