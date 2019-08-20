package com.visionyle.docnyle.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.visionyle.docnyle.fragments.ChiefComplaintsFragment;
import com.visionyle.docnyle.fragments.DiagnosticsAidsInvestigationsFragment;
import com.visionyle.docnyle.fragments.MedicalHistoryFragment;
import com.visionyle.docnyle.fragments.OPRegistrationFragment;
import com.visionyle.docnyle.fragments.SurgicalProcedureInterventionFragment;
import com.visionyle.docnyle.fragments.TreatmentPlansMedicationsFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public  android.support.v4.app.Fragment getItem(int position) {
//        return OPRegistrationFragment.newInstance(position + 1, position == getCount() - 1);
        switch (position) {
            case 0:
                return new OPRegistrationFragment();
            case 1:
                return new MedicalHistoryFragment();
            case 2:
                return new ChiefComplaintsFragment();
            case 3:
                return new DiagnosticsAidsInvestigationsFragment();
            case 4:
                return new TreatmentPlansMedicationsFragment();
            case 5:
                return new SurgicalProcedureInterventionFragment();
//                default://
//                return Tab3Fragment.newInstance();
//               }
            default:
                return null;
        }

        }


    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}