
package com.visionyle.docnyle.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.libraries.remixer.Remixer;
import com.google.android.libraries.remixer.annotation.BooleanVariableMethod;
import com.google.android.libraries.remixer.annotation.ColorListVariableMethod;
import com.google.android.libraries.remixer.annotation.RangeVariableMethod;
import com.google.android.libraries.remixer.annotation.RemixerBinder;
import com.google.android.libraries.remixer.storage.LocalStorage;
import com.google.android.libraries.remixer.ui.RemixerInitialization;
import com.google.android.libraries.remixer.ui.view.RemixerFragment;
import com.rakshakhegde.stepperindicator.StepperIndicator;

import com.rakshakhegde.stepperindicator.StepperIndicator;
import com.visionyle.docnyle.R;
import com.visionyle.docnyle.adapters.PagerAdapter;


public class PatientEntryActivity extends AppCompatActivity {
    StepperIndicator indicator;
    TextView title;
    int position=0;

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_entry);
        position=getIntent().getIntExtra("zero",0);
        final ViewPager pager = findViewById(R.id.pager);
        assert pager != null;
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        title=findViewById(R.id.title);

        title.setText("OP Registration");

        indicator = findViewById(R.id.stepper_indicator);
        // We keep last page for a "finishing" page
        indicator.setViewPager(pager, true);

        indicator.setStepCount(6);

//        indicator.addOnStepClickListener(new StepperIndicator.OnStepClickListener() {
//            @Override
//            public void onStepClicked(int step) {
//                pager.setCurrentItem(step, false);
//            }
//        });

        pager.setCurrentItem(position, false);

        pager.beginFakeDrag();

        pager.setHorizontalScrollBarEnabled(false);


        if (position == 0) {

            title.setText("OP Registration");

        } else if (position == 1) {

            title.setText("Medical History");

        }else if (position == 2) {

            title.setText("Chief Complaints");

        }else if (position == 3) {

            title.setText("Diagnostic Aids / Investigations");

        }else if (position == 4) {

            title.setText("Treatment Plans / Medications");

        }else if (position == 5) {

            title.setText("Surgical Procedure / Intervention");

        }

//        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float v, int i1) {
//                if (position == 0) {
//
//                    title.setText("OP Registration");
//
//                } else if (position == 1) {
//
//                    title.setText("Medical History");
//
//                }else if (position == 2) {
//
//                    title.setText("Chief Complaints");
//
//                }else if (position == 3) {
//
//                    title.setText("Diagnostic Aids / Investigations");
//
//                }else if (position == 4) {
//
//                    title.setText("Treatment Plans / Medications");
//
//                }else if (position == 5) {
//
//                    title.setText("Surgical Procedure / Intervention");
//
//                }
//            }
//
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onPageSelected(int position) {
//                if (position == 0) {
//
//                    title.setText("OP Registration");
//
//
//                } else if (position == 1) {
//
//                    title.setText("Medical History");
//
//                }else if (position == 2) {
//
//                    title.setText("Chief Complaints");
//
//                }else if (position == 3) {
//
//                    title.setText("Diagnostic Aids / Investigations");
//
//                }else if (position == 4) {
//
//                    title.setText("Treatment Plans / Medications");
//
//                }else if (position == 5) {
//
//                    title.setText("Surgical Procedure / Intervention");
//
//                }
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });



//        RemixerInitialization.initRemixer(getApplication());
//        Remixer.getInstance().setSynchronizationMechanism(new LocalStorage(getApplicationContext()));
//
//        RemixerBinder.bind(this);
//
//        final FloatingActionButton remixerButton = findViewById(R.id.remixerButton);
//        RemixerFragment.newInstance().attachToFab(this, remixerButton);
    }



//    @RangeVariableMethod(minValue = 6, maxValue = 70, initialValue = 20)
//    public void setLabelSize(Float fontSize) {
//        indicator.setLabelSize(fontSize);
//    }
//
//    @BooleanVariableMethod(initialValue = true)
//    public void showLabels(Boolean showLabels) {
//        indicator.showLabels(showLabels);
//    }
//
//    @BooleanVariableMethod
//    public void showStepNumberInstead(Boolean showStepNumberInstead) {
//        indicator.showStepNumberInstead(showStepNumberInstead);
//    }
//
//    @BooleanVariableMethod
//    public void useBottomIndicator(Boolean useBottomIndicator) {
//        indicator.useBottomIndicator(useBottomIndicator);
//    }
//
//    @ColorListVariableMethod(limitedToValues = {0xFF00b47c, 0xFF3f51b5, 0xFFf44336})
//    public void setIndicatorColor(Integer indicatorColor) {
//        indicator.setIndicatorColor(indicatorColor);
//    }
//
//    @ColorListVariableMethod(limitedToValues = {0xFF00b47c, 0xFF3f51b5, 0xFFf44336})
//    public void setLineDoneColor(Integer lineDoneColor) {
//        indicator.setLineDoneColor(lineDoneColor);
//    }
//
//    @ColorListVariableMethod(limitedToValues = {Color.BLACK, Color.WHITE, 0xFF00b47c, 0xFF3f51b5, 0xFFf44336})
//    public void setLabelColor(Integer labelColor) {
//        indicator.setLabelColor(labelColor);
//    }

}