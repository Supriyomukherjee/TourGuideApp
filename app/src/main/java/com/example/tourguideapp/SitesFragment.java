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


public class SitesFragment extends Fragment {



    public SitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.layout_list_of_places, container, false);
        final int[] imageSight = {R.drawable.tower_bridge, R.drawable.buckingham_palace, R.drawable.london_eye, R.drawable.tate_modern_2,
                R.drawable.shakespeares_globe, R.drawable.barbican_2};

        final String[] sightName = getResources().getStringArray(R.array.sights_name);
        final  String[] sightAddress = getResources().getStringArray(R.array.shop_address);
        final  String[] sightDescription = getResources().getStringArray(R.array.sights_description);
        final String[] sightWebSite =  getResources().getStringArray(R.array.sights_website);


        final ArrayList<Place> places = new ArrayList<>();
        for (int i = 0; i <5; i++) {
            places.add(new Place(sightName[i], sightAddress[i], imageSight[i]));
        }

        final  PlaceAdapter adapter = new PlaceAdapter(getActivity() , places , R.color.primary_light );

        final ListView listView = rootview.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
                intent.putExtra(getString(R.string.key_name), sightName[position]);
                intent.putExtra(getString(R.string.key_address), sightAddress[position]);
                intent.putExtra(getString(R.string.key_description), sightDescription[position]);
                intent.putExtra(getString(R.string.key_website), sightWebSite[position]);
                intent.putExtra(getString(R.string.key_image), imageSight[position]);
                startActivity(intent);
            }
        });
        return rootview;
    }


}