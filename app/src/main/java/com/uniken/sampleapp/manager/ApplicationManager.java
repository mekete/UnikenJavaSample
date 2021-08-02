package com.uniken.sampleapp.manager;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDexApplication;


public class ApplicationManager extends MultiDexApplication {
    private static final String TAG = "ApplicationManager";
    private static Context mContext;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();



    }



    public static class CurrentSession {

    }


}