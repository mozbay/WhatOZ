package com.whatoz.application.aphorism.HttpProcess;

/**
 * Created by muratozbay on 18.04.2018.
 */

public class WhatozService {

    public String getDeneme (String url, String condition) {
        HttpPostObject postObject = new HttpPostObject();

        try {
            String httpStr = url; // +"?" + condition
            return postObject.httpGet(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
