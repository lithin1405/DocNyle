package com.visionyle.docnyle.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.modals.MedicalHistoryData;

import java.util.ArrayList;

public class RadiologyAdapter extends RecyclerView.Adapter<RadiologyAdapter.RecyclerItemViewHolder> {
    private ArrayList<MedicalHistoryData> myList;
    private RadiologyAdapter.RemoveClickListner mListner;
    public RadiologyAdapter(ArrayList<MedicalHistoryData> myList, RadiologyAdapter.RemoveClickListner listner) {
        this.myList = myList;
        mListner=listner;
    }
    @NonNull
    public RadiologyAdapter.RecyclerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.radiology_list, parent, false);
        return new RadiologyAdapter.RecyclerItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RadiologyAdapter.RecyclerItemViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d("onBindViewHoler ", myList.size() + "");
        holder.healthillness.setText(myList.get(position).getHealthillness());
        holder.since.setText(myList.get(position).getSince());
    }
    @Override
    public int getItemCount() {
        return(null != myList?myList.size():0);
    }
    public void notifyData(ArrayList<MedicalHistoryData> myList) {
        Log.d("notifyData ", myList.size() + "");
        this.myList = myList;
        notifyDataSetChanged();
    }
    class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView healthillness;
        private final AppCompatTextView since;
        private final AppCompatTextView deleterecord;
        RecyclerItemViewHolder(final View parent) {
            super(parent);
            healthillness =  parent.findViewById(R.id.healthillness);
            since = parent.findViewById(R.id.since);
            deleterecord = parent.findViewById(R.id.deleterecord);

            deleterecord.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.OnRemoveClick(getAdapterPosition()
                    );
                }
            });
        }
    }

    public interface RemoveClickListner {
        void OnRemoveClick(int index);
    }

}