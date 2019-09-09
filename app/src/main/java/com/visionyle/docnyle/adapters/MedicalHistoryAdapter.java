package com.visionyle.docnyle.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.visionyle.docnyle.R;
import com.visionyle.docnyle.modals.MedicalHistoryData;

import java.util.ArrayList;

public class MedicalHistoryAdapter extends RecyclerView.Adapter<MedicalHistoryAdapter.RecyclerItemViewHolder> {
    private ArrayList<MedicalHistoryData> myList;
    private RemoveClickListner mListner;
    public MedicalHistoryAdapter(ArrayList<MedicalHistoryData> myList,RemoveClickListner listner) {
        this.myList = myList;
        mListner=listner;
    }
    @NonNull
    public RecyclerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medical_history_list, parent, false);
        return new RecyclerItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerItemViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d("onBindViewHoler ", myList.size() + "");
        holder.healthillness.setText(myList.get(position).getHealthillness());
        holder.since.setText(myList.get(position).getSince());
        holder.medication.setText(myList.get(position).getMedication());
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
        private final AppCompatTextView medication;
        private final AppCompatTextView deleterecord;
        RecyclerItemViewHolder(final View parent) {
            super(parent);
            healthillness =  parent.findViewById(R.id.healthillness);
            since = parent.findViewById(R.id.since);
            medication =  parent.findViewById(R.id.medication);
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