package com.example.idz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class EntryRVAdapter extends RecyclerView.Adapter<EntryRVAdapter.ViewHolder> {


    private ArrayList<EntryModal> EntryModalArrayList;
    private Context context;


    public EntryRVAdapter(ArrayList<EntryModal> EntryModalArrayList, Context context) {
        this.EntryModalArrayList = EntryModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EntryModal modal = EntryModalArrayList.get(position);
        holder.entryNameTV.setText(modal.getName());
        holder.entryEmailTV.setText(modal.getEmail());
        holder.entryDobTV.setText(modal.getDob());
    }

    @Override
    public int getItemCount() {

        return EntryModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView entryNameTV, entryEmailTV, entryDobTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            entryNameTV = itemView.findViewById(R.id.idName);
            entryEmailTV = itemView.findViewById(R.id.idemail);
            entryDobTV = itemView.findViewById(R.id.iddate);
        }
    }
}
