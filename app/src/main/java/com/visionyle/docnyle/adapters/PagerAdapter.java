package com.visionyle.docnyle.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.visionyle.docnyle.fragments.PageFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1, position == getCount() - 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}