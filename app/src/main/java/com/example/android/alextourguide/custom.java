package com.example.android.alextourguide;


import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.speech.tts.Voice;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class custom extends ArrayAdapter<Name> {

    private int mcolorid;
    public custom(Activity context,ArrayList<Name> data, int colorid) {
        super(context, 0,data);
        mcolorid=colorid;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        Name currentAndroidFlavor = getItem(position);
        View listItemView = convertView;
        View listitem=convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);

        }


        // Get the {@link AndroidFlavor} object located at this position in the list

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView add = (TextView) listItemView.findViewById(R.id.address);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        add.setText(currentAndroidFlavor.getAddress());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView name = (TextView) listItemView.findViewById(R.id.Name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        name.setText(currentAndroidFlavor.getName());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object an
        // set the image to iconView
        iconView.setImageResource(currentAndroidFlavor.getImages());



        View textcontainer=listItemView.findViewById(R.id.linear);
        int color= ContextCompat.getColor(getContext(),mcolorid);
        textcontainer.setBackgroundColor(color);










        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
