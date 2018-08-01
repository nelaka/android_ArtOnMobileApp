package com.example.android.android_artonmobileapp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.R;

public class Utils {


    public static void mySnackBar(View view, int message) {
        String msg = view.getResources().getString(message);
        Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbar.show();
    }

    public void mySnackBar(View view, String message, int textColor, int bgColor) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        TextView textView = snackbarView.findViewById(R.id.snackbar_text);
        textView.setTextColor(view.getResources().getColor(textColor));
        snackbarView.setBackgroundColor(view.getResources().getColor(bgColor));
        snackbar.show();
    }


}
