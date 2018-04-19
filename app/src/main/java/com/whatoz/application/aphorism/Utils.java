package com.whatoz.application.aphorism;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.whatoz.application.aphorism.HttpProcess.ServiceExecuter;

import org.json.JSONObject;

/**
 * Created by muratozbay on 17.04.2018.
 */

public class Utils {
    public static final String TAG = "Utils";

    public static boolean checkTheseEqual(String parameter1, String parameter2) {
        if (parameter1.equals(parameter2)) {
            Log.e(TAG, "EŞİT");
            return true;
        } else {
            Log.e(TAG, "EŞİT DEĞİL");
            return false;
        }
    }

    public boolean isConnected3g(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;

            if (connectivityManager != null) {
                networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            }
            return networkInfo == null ? false : networkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isConnectingWIFI(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;

            if (connectivityManager != null) {
                networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            }

            return networkInfo == null ? false : networkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public void alertMessage(Context context, String message) {
        try {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle(context.getResources().getString(R.string.app_name));
            alert.setMessage(message);

            alert.setPositiveButton(context.getResources().getString(R.string.app_name), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.create();
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callServiceExecuter(Context context, boolean isAlertMessage, String methodName, Object[] methodsParam, String postMethodName, Object viewScreen, String dialogFlag) {

        if (isConnected3g(context) || isConnectingWIFI(context)) {
            JSONObject jsonObject = new JSONObject();
            ServiceExecuter serviceExecuter = new ServiceExecuter(methodName, postMethodName, methodsParam, viewScreen, dialogFlag);
            serviceExecuter.execute(jsonObject);
        } else {
            if (isAlertMessage) {
                alertMessage(context, context.getResources().getString(R.string.app_name));
            }

        }
    }
}
