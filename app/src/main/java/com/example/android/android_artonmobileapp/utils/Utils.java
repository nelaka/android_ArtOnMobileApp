package com.example.android.android_artonmobileapp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

public class Utils {


    public static void mySnackBar(View view, int message) {
        String msg = view.getResources().getString(message);
        Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }



}
