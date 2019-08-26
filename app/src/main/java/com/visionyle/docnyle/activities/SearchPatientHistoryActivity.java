package com.visionyle.docnyle.activities;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.CustomAdapter;
import com.visionyle.docnyle.modals.Contact;
import com.visionyle.docnyle.modals.MyApplication;
import com.visionyle.docnyle.modals.MyDividerItemDecoration;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class SearchPatientHistoryActivity extends AppCompatActivity{

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient_history);
        //Start Toolbar
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title =  toolbar.findViewById(R.id.toolbar_title);
        ImageView homeicon = toolbar.findViewById(R.id.homeicon);
        ImageView logout = toolbar.findViewById(R.id.logout);
        title.setText("Patient Search");
        title.setPadding(0, 0, 60, 0);
        title.setGravity(Gravity.CENTER);
        homeicon.setVisibility(View.VISIBLE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SearchPatientHistoryActivity.this)
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
        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });

    }


}