package com.visionyle.docnyle.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.visionyle.docnyle.fragments.OtherConditionFragment;
import com.visionyle.docnyle.fragments.UpdateChiefComplaintsFragment;

public class ChiefComplaintsAdapter extends FragmentPagerAdapter {

    public ChiefComplaintsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public  android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new UpdateChiefComplaintsFragment();
            case 1:
                return new OtherConditionFragment();
            default:
                return null;

        }

    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Update Chief Complaints";
            case 1:
                return "Other Condition";
//                case 2:
//                    return "Tab 3";
        }
        return null;
    }
}