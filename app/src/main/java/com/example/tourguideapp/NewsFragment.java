package com.example.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.layout_list_of_places, container, false);


        final int[] imageNew = {R.drawable.luna_cinema, R.drawable.jazz_cafe_camden, R.drawable.silent_disco_cutty_sark, R.drawable.grayson_perry,
                R.drawable.greenwich_fet, R.drawable.tristan_yseult};
        final String[] newName = getResources().getStringArray(R.array.new_name);
        final String[] newAddress = getResources().getStringArray(R.array.new_address);
        final String[] newDescription = getResources().getStringArray(R.array.new_description);
        final String[] newWebsite = getResources().getStringArray(R.array.new_website);


        ArrayList<Place> places = new ArrayList<>() ;
        for(int i=0;i<=5;i++)
        {
            places.add(new Place(newName[i],newAddress[i],imageNew[i]));
        }

        final  PlaceAdapter adapter = new PlaceAdapter(getActivity() , places , R.color.primary_light );
        final ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
            intent.putExtra(getString(R.string.key_name), newName[position]);
            intent.putExtra(getString(R.string.key_address), newAddress[position]);
            intent.putExtra(getString(R.string.key_description), newDescription[position]);
            intent.putExtra(getString(R.string.key_website), newWebsite[position]);
            intent.putExtra(getString(R.string.key_image), imageNew[position]);
            startActivity(intent);
        });
        return rootview;
    }


}