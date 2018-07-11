package com.alhudaghifari.codepolitanlite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.alhudaghifari.codepolitanlite.fragment.InfoFragment;
import com.alhudaghifari.codepolitanlite.fragment.NewsFragment;
import com.alhudaghifari.codepolitanlite.fragment.TutorialFragment;

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
                return new NewsFragment();
            case 1:
                return new TutorialFragment();
            case 2:
                return new InfoFragment();
            default:
                return new NewsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "News";
            case 1:
                return "Tutorial";
            default:
                return "Info";
        }
    }
}
