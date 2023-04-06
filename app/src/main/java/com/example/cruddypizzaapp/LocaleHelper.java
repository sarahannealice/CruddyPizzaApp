package com.example.cruddypizzaapp;

import static android.content.Context.*;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class LocaleHelper {
    public static final String SELECTED = "Locale.Helper.Selected.Language";


    //sets locale language
    void setLocale(Context context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config = context.getResources().getConfiguration();
        config.setLocale(locale);
        config.setLayoutDirection(locale);
        SharedPreferences.Editor editor = context.getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString(SELECTED, lang);
        editor.apply();
    }

    //loads previously used language
    private void loadLocale(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString(SELECTED, "");
        setLocale(context, language);
    }
}
