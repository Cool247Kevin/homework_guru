package com.appbrainmob.bubblesoft.homeworkguru.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.appbrainmob.bubblesoft.homeworkguru.adaptors.MenuAdaptor;
import com.appbrainmob.bubblesoft.homeworkguru.views.AlertDialogView;

public class TempActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpWindowAnimations();

        String [] choice_list = {"Solve It", "Share", "About Us", "Contact"};

        setListAdapter(new MenuAdaptor(TempActivity.this, choice_list));
        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                pressButton(position);
            }
        });
    }

    //setup slide
    private void setUpWindowAnimations() {

        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setExitTransition(slide);
    }

    private void pressButton(int position) {

        switch (position) {

            case 0:
                Intent it0 = new Intent(getApplicationContext(), SolveItActivity.class);
                startActivity(it0);
                break;

            case 1:
                Intent it1 = new Intent(getApplicationContext(), ShareActivity.class);
                startActivity(it1);
                break;

            case 2:
                AlertDialogView adv2 = new AlertDialogView();
                adv2.aboutUs(TempActivity.this);
                break;

            case 3:
                AlertDialogView adv3 = new AlertDialogView();
                adv3.contactUs(TempActivity.this);
                break;

            default:
                Toast.makeText(getApplicationContext(), "PLEASE PUSH A VALID BUTTON !", Toast.LENGTH_LONG).show();
                break;
        }
    }
}