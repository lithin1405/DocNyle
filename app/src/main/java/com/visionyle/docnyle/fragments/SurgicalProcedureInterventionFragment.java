package com.visionyle.docnyle.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.visionyle.docnyle.R;

public class SurgicalProcedureInterventionFragment extends Fragment {
    TextView lbl_page;

    public SurgicalProcedureInterventionFragment() {
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
        View view=inflater.inflate(R.layout.fragment_page, container, false);
        lbl_page=view.findViewById(R.id.lbl_page);
        lbl_page.setText("Surgical Procedure Intervention");
        return view;
    }

}