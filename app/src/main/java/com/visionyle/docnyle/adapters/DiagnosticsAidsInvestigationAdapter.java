package com.visionyle.docnyle.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.visionyle.docnyle.fragments.BloodInvestigationsFragment;
import com.visionyle.docnyle.fragments.OtherConditionFragment;
import com.visionyle.docnyle.fragments.RadiologyFragment;
import com.visionyle.docnyle.fragments.UpdateChiefComplaintsFragment;

public class DiagnosticsAidsInvestigationAdapter extends FragmentPagerAdapter {

    public DiagnosticsAidsInvestigationAdapter(FragmentManager fm) {
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
                return new RadiologyFragment();
            case 1:
                return new BloodInvestigationsFragment();
            default:
                return null;

        }

    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Radiology";
            case 1:
                return "Blood Investigations";
//                case 2:
//                    return "Tab 3";
        }
        return null;
    }
}