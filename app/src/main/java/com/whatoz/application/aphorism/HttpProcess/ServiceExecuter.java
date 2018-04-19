package com.whatoz.application.aphorism.HttpProcess;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by muratozbay on 18.04.2018.
 */

public class ServiceExecuter extends AsyncTask<JSONObject, Void, Void> {

    private String methodName;
    private String postMethodName;
    private Object[] methodParam;
    private Class[] methodParamsType;
    private String strJson = "";
    private Object viewScreen;
    private String showDialog;

    public ServiceExecuter(String methodName, String postMethodName, Object[] methodParam, Object viewScreen, String showDialog) {

        this.methodName = methodName;
        this.postMethodName = postMethodName;
        this.methodParam = methodParam;
        this.methodParamsType = new Class[methodParam.length];
        this.viewScreen = viewScreen;
        this.showDialog = showDialog;

        for (int i = 0; i < methodParam.length; i++) {
            this.methodParamsType[i] = methodParam[i].getClass();
        }

    }

    @Override
    protected void onPreExecute() {
        try {
            if (showDialog.equalsIgnoreCase("true")) {

            }
        } catch (Exception e) {
        }
    }

    @Override
    protected Void doInBackground(JSONObject... jsonObjects) {

        try {
            Class cls;
            cls = Class.forName("com.whatoz.application.aphorism.HttpProcess.WhatozService");

            Object obj = cls.newInstance();

            Method method = cls.getDeclaredMethod(this.methodName, this.methodParamsType);
            strJson = (String) method.invoke(obj, this.methodParam);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        try {
            super.onPostExecute(aVoid);

            try {
                Class cls;
                cls = Class.forName("com.whatoz.application.aphorism.HttpProcess.WhatozService");

                Object obj = cls.newInstance();

                Method method = cls.getDeclaredMethod(this.postMethodName, new Class[]{String.class, Object.class});
                method.invoke(obj, new Object[]{this.strJson, this.viewScreen});

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }
}
