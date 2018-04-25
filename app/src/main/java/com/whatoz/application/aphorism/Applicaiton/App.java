package com.whatoz.application.aphorism.Applicaiton;

import android.app.Application;
import android.content.Context;

/**
 * Created by muratozbay on 25.04.2018.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {return mContext;}
}
