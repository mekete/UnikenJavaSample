package com.uniken.sampleapp.manager;

import android.content.Context;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

import com.uniken.sampleapp.R;

public class SettingsManager {
    public static final float INVALID_LAT_OR_LNG = -99f;
    public static final String EMPTY_STRING = "";
    private static Context context = ApplicationManager.getAppContext();

    public static String getActivationCode() {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(R.string.pref_key_activation_code), EMPTY_STRING);
    }

    public static void setActivationCode(String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(context.getString(R.string.pref_key_activation_code), value).commit();
    }

    @Nullable
    public static String getAccessCode() {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(R.string.pref_key_access_code), EMPTY_STRING);
    }

    public static void setAccessCode(String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(context.getString(R.string.pref_key_access_code), value).commit();
    }

    // -------------------------------------------------------------------------

}


