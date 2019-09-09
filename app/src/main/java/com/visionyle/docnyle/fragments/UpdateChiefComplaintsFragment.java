package com.visionyle.docnyle.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.RadiologyAdapter;
import com.visionyle.docnyle.adapters.UpdateComplaintsAdapter;
import com.visionyle.docnyle.modals.MedicalHistoryData;

import java.util.ArrayList;

public class UpdateChiefComplaintsFragment extends Fragment implements UpdateComplaintsAdapter.RemoveClickListner{
    private RecyclerView mRecyclerView;
    private UpdateComplaintsAdapter mRecyclerAdapter;
    AppCompatImageView btnAddItem;
    ArrayList<MedicalHistoryData> myList = new ArrayList<>();
    EditText ethealthillness;

    public UpdateChiefComplaintsFragment() {
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
        View view= inflater.inflate(R.layout.update_chief_complaints_fragment, container, false);
        mRecyclerView = view. findViewById(R.id.rcList);
        mRecyclerAdapter = new UpdateComplaintsAdapter(myList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        ethealthillness = view. findViewById(R.id.ethealthillness);
        btnAddItem =view. findViewById(R.id.additem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String healthillness=ethealthillness.getText().toString();
                MedicalHistoryData mLog = new MedicalHistoryData();
                mLog.setHealthillness(healthillness);
                myList.add(mLog);
                mRecyclerAdapter.notifyData(myList);
                ethealthillness.setText("");
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