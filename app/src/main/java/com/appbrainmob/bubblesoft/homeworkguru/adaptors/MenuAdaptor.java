package com.appbrainmob.bubblesoft.homeworkguru.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbrainmob.bubblesoft.homeworkguru.R;

public class MenuAdaptor extends ArrayAdapter<String> {

    private final Context context;
    private final String[] resource;

    public MenuAdaptor(Context context, String[] resource) {
        super(context, R.layout.activity_listview, resource);

        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_listview, parent, false);

        TextView tv = (TextView) view.findViewById(R.id.label);
        ImageView iv = (ImageView) view.findViewById(R.id.logo);

        switch (this.resource[position]) {

            case "Solve It":
                iv.setImageResource(R.drawable.zero);
                tv.setText(resource[position]);
                break;

            case "Share":
                iv.setImageResource(R.drawable.one);
                tv.setText(resource[position]);
                break;

            case "About Us":
                iv.setImageResource(R.drawable.two);
                tv.setText(resource[position]);
                break;

            case "Contact":
                iv.setImageResource(R.drawable.three);
                tv.setText(resource[position]);
                break;
        }

        return view;
    }
}
