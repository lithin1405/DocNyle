package com.visionyle.docnyle.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.MedicalHistoryAdapter;
import com.visionyle.docnyle.modals.MedicalHistoryData;

import java.util.ArrayList;

public class TreatmentPlansMedicationsFragment extends Fragment implements MedicalHistoryAdapter.RemoveClickListner{
    private RecyclerView mRecyclerView;
    private MedicalHistoryAdapter mRecyclerAdapter;
    Button btnAddItem;
    ArrayList<MedicalHistoryData> myList = new ArrayList<>();
    EditText etdrugname, etdosage,etnoofdays;

    public TreatmentPlansMedicationsFragment() {
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
        View view= inflater.inflate(R.layout.treatment_plan_medication_fragment, container, false);
        mRecyclerView = view. findViewById(R.id.rcList);
        mRecyclerAdapter = new MedicalHistoryAdapter(myList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        etdrugname = view. findViewById(R.id.etdrugname);
        etdosage = view. findViewById(R.id.etdosage);
        etnoofdays=view. findViewById(R.id.etnoofdays);
        btnAddItem =view. findViewById(R.id.additem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String drugname=etdrugname.getText().toString();
                String dosage=etdosage.getText().toString();
                String noofdays=etnoofdays.getText().toString();
                MedicalHistoryData mLog = new MedicalHistoryData();
                mLog.setHealthillness(drugname);
                mLog.setSince(dosage);
                mLog.setMedication(noofdays);
                myList.add(mLog);
                mRecyclerAdapter.notifyData(myList);
                etdrugname.setText("");
                etdosage.setText("");
                etnoofdays.setText("");
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