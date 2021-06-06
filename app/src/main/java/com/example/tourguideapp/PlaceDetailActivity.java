package com.example.tourguideapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceDetailActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_place_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set custom font to TextViews inside activity_place_detail
        String fontpath = "fonts/PatrickHandSC_Regular.ttf";
        TextView titleView = (TextView) findViewById(R.id.title_large);
        Typeface tf = Typeface.createFromAsset(getAssets(), fontpath);
        TextView addressView = (TextView) findViewById(R.id.address_large);
        TextView descriptionView = (TextView) findViewById(R.id.description_large);
        titleView.setTypeface(tf);
        addressView.setTypeface(tf);
        descriptionView.setTypeface(tf);


        //Get extras from the intent in the MainActivity, using the 'keys' provided
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(getString(R.string.key_name));
        String address = bundle.getString(getString(R.string.key_address));
        int image = bundle.getInt(getString(R.string.key_image));
        String description = bundle.getString("description");
        final String website = bundle.getString("website");


        ImageView detailImage = (ImageView) findViewById(R.id.large_image);
        detailImage.setImageResource(image);

        TextView detailTitle = (TextView) findViewById(R.id.title_large);
        detailTitle.setText(name);

        TextView detailAddress = (TextView) findViewById(R.id.address_large);
        detailAddress.setText(address);

        TextView detailDescription = (TextView) findViewById(R.id.description_large);
        detailDescription.setText(description);

        //Intent for opening a browser app and navigating to the website;
        //Intent corresponds  to the 'link' ImageView in activity_place_detail

        ImageView goWebsite = (ImageView) findViewById(R.id.go_to_website);
        goWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intentWebsite);
            }
        });

        ImageView shareImage = findViewById(R.id.share);
        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SENDTO);
                intentShare.setData(Uri.parse(getString(R.string.email_data)));
                intentShare.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                startActivity(intentShare);
            }
        });


    }
}