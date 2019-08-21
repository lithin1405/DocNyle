package com.visionyle.docnyle.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.ChiefComplaintsAdapter;
import com.visionyle.docnyle.adapters.PagerAdapter;

public class OtherConditionFragment extends Fragment {

    public OtherConditionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.other_condition_fragment, container, false);
    }

}