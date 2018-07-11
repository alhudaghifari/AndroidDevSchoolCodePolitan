package com.alhudaghifari.latihanviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ghifar on 11/07/18.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentNews();
            case 1:
                return new FragmentTutorial();
            case 2:
                return new FragmentInfo();
            default:
                return new FragmentNews();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "News";
        } else if (position == 1) {
            return "Tutorial";
        } else {
            return "Info";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
