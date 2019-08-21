package com.visionyle.docnyle.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.ChiefComplaintsAdapter;
import com.visionyle.docnyle.adapters.PagerAdapter;

import java.util.Objects;

public class ChiefComplaintsFragment extends Fragment {
    TabLayout tabLayout;

    public ChiefComplaintsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.chiefcomplaints_fragment, container, false);
        final ViewPager pager = view.findViewById(R.id.pager);
        assert pager != null;
        tabLayout =  view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(new ChiefComplaintsAdapter(getChildFragmentManager()));
        pager.setOnTouchListener(mSuppressInterceptListener);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0D47A1"));
        tabLayout.setSelectedTabIndicatorHeight((int) (2 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#0D47A1"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("NewApi")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (Objects.requireNonNull(tabLayout.getTabAt(0)).isSelected()){
                    firstTab();
                }else if (Objects.requireNonNull(tabLayout.getTabAt(1)).isSelected()){
                    firstTab();
                }
            }
            @SuppressLint("NewApi")
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (Objects.requireNonNull(tabLayout.getTabAt(0)).isSelected()){
                    unSelected();
                }else if (Objects.requireNonNull(tabLayout.getTabAt(1)).isSelected()){
                    unSelected();
                }
            }
            @SuppressLint("NewApi")
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (Objects.requireNonNull(tabLayout.getTabAt(0)).isSelected()){
                    firstTab();
                }else if (Objects.requireNonNull(tabLayout.getTabAt(1)).isSelected()){
                    firstTab();
                }
            }
        });
        return view;
    }

    private void unSelected() {
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0D47A1"));
        tabLayout.setSelectedTabIndicatorHeight((int) (2 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#0D47A1"), Color.parseColor("#0D47A1"));
    }

    private void firstTab() {
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0D47A1"));
        tabLayout.setSelectedTabIndicatorHeight((int) (2 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#0D47A1"));
    }

    private View.OnTouchListener mSuppressInterceptListener = new View.OnTouchListener() {

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(
                    event.getAction() == MotionEvent.ACTION_DOWN &&
                            v instanceof ViewGroup
            ) {
                ((ViewGroup) v).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    };

}
