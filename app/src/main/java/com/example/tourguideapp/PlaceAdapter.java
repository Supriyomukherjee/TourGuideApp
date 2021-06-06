package com.example.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place>
{
private  int mColorResourceId ;
    public PlaceAdapter(Context context, ArrayList<Place> places, int coloResourceId) {
        super(context, 0, places);
        mColorResourceId = coloResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout_list_item, parent, false);
        }
        Place currentPlace = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.name);
        titleTextView.setText(currentPlace.getmName());

        TextView descriptionTextView =(TextView) listItemView.findViewById(R.id.description);
        descriptionTextView.setText(currentPlace.getmDescription());


        ImageView imageView = (ImageView)listItemView.findViewById(R.id.img);
        imageView.setImageResource(currentPlace.getmImageResourceId());
        imageView.setVisibility(View.VISIBLE);


        View textContainer = listItemView.findViewById(R.id.text_container);
        int colorId = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(colorId);

        return  listItemView;
    }
}
