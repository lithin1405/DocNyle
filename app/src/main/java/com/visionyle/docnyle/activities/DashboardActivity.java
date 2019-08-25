package com.visionyle.docnyle.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.visionyle.docnyle.R;

public class DashboardActivity extends AppCompatActivity {

    private CardView opregistration,medicalhistory,chiefcomplaints,diagnosticaids,treatmentplans
            ,surgicalprocedure,settings,reports;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Start Toolbar
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title =  toolbar.findViewById(R.id.toolbar_title);
        ImageView homeicon = toolbar.findViewById(R.id.homeicon);
        ImageView logout = toolbar.findViewById(R.id.logout);
        title.setText("Menu");
        title.setPadding(0, 0, 60, 0);
        title.setGravity(Gravity.CENTER);
        homeicon.setVisibility(View.INVISIBLE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DashboardActivity.this)
                        .setTitle("Alert")
                        .setMessage("Are you sure you want to Logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", null).show();

            }
        });
        opregistration=findViewById(R.id.opregistration);
        medicalhistory=findViewById(R.id.medicalhistory);
        chiefcomplaints=findViewById(R.id.chiefcomplaints);
        diagnosticaids=findViewById(R.id.diagnosticaids);
        treatmentplans=findViewById(R.id.treatmentplans);
        surgicalprocedure=findViewById(R.id.surgicalprocedure);
        settings=findViewById(R.id.settings);
        reports=findViewById(R.id.reports);
        opregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PatientEntryActivity.class);
                startActivity(intent);
            }
        });
        medicalhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PatientEntryActivity.class);
                startActivity(intent);
            }
        });
        chiefcomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PatientEntryActivity.class);
                startActivity(intent);
            }
        });
        diagnosticaids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PatientEntryActivity.class);
                startActivity(intent);
            }
        });
        treatmentplans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PatientEntryActivity.class);
                startActivity(intent);
            }
        });
        surgicalprocedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PatientEntryActivity.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
            }
        });
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ReportsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
