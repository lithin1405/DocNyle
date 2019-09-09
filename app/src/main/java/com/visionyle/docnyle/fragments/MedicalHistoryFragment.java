package com.visionyle.docnyle.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.MedicalHistoryAdapter;
import com.visionyle.docnyle.modals.MedicalHistoryData;

import java.util.ArrayList;

public class MedicalHistoryFragment  extends Fragment implements MedicalHistoryAdapter.RemoveClickListner {
    private RecyclerView mRecyclerView;
    private MedicalHistoryAdapter mRecyclerAdapter;
    Button btnAddItem;
    ArrayList<MedicalHistoryData> myList = new ArrayList<>();
    EditText ethealthillness, etsince,etmedication;


    public MedicalHistoryFragment() {
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
        View view= inflater.inflate(R.layout.medicalhistory_fragment, container, false);
        mRecyclerView = view. findViewById(R.id.rcList);
        mRecyclerAdapter = new MedicalHistoryAdapter(myList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        ethealthillness = view. findViewById(R.id.ethealthillness);
        etsince = view. findViewById(R.id.etsince);
        etmedication=view. findViewById(R.id.etmedication);
        btnAddItem =view. findViewById(R.id.additem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String healthillness=ethealthillness.getText().toString();
                String since=etsince.getText().toString();
                String medication=etmedication.getText().toString();
                MedicalHistoryData mLog = new MedicalHistoryData();
                mLog.setHealthillness(healthillness);
                mLog.setSince(since);
                mLog.setMedication(medication);
                myList.add(mLog);
                mRecyclerAdapter.notifyData(myList);
                ethealthillness.setText("");
                etsince.setText("");
                etmedication.setText("");
            }
        });


        return view;
    }

    @Override
    public void OnRemoveClick(int index) {
        myList.remove(index);
        mRecyclerAdapter.notifyData(myList);
    }
}