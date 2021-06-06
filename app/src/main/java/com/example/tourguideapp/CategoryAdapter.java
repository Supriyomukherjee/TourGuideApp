package com.example.tourguideapp;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private String tabNames[] = new String[]{"Sights", "What's on", "Food + drink", "Shopping"};
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }
    @Override
    public Fragment getItem(int position) {

        Log.i("Tab Position", String.valueOf(position));
        switch (position) {
            case 0:
                 return new SitesFragment();
        case 1:
                return new NewsFragment();
         case 2:return new FoodFragment();
         case 3 :return new ShopFragment();
        }
        return null;

    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      //  return tabNames[position];
        if (position == 0) {
            return mContext.getString(R.string.tab_sight);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_new);
        } else if (position == 2) {
            return mContext.getString(R.string.tab_food);
        } else {
            return mContext.getString(R.string.tab_shop);
        }
    }
    }

