package com.appbrainmob.bubblesoft.homeworkguru.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import com.appbrainmob.bubblesoft.homeworkguru.R;

public class AlertDialogView {

    public void aboutUs(Context c) {

        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        LayoutInflater li = LayoutInflater.from(c);
        final View view = li.inflate(R.layout.aboutus, null);
        adb.setView(view).setCancelable(true).setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.setTitle("ABOUT US");
        ad.show();
    }

    public void contactUs(Context c) {

        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        LayoutInflater li = LayoutInflater.from(c);
        final View view = li.inflate(R.layout.contactus, null);
        adb.setView(view).setCancelable(true).setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.setTitle("CONTACT US");
        ad.show();
    }
}
