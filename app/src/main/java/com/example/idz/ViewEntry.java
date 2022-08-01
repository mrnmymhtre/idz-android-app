package com.example.idz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class ViewEntry extends AppCompatActivity {


    private ArrayList<EntryModal> EntryModalArrayList;
    private DBHandler dbHandler;
    private EntryRVAdapter EntryRVAdapter;
    private RecyclerView EntryRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entry);

        EntryModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewEntry.this);


        EntryModalArrayList = dbHandler.readEntry();

        EntryRVAdapter = new EntryRVAdapter(EntryModalArrayList, ViewEntry.this);
        EntryRV = findViewById(R.id.idEntry);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewEntry.this, RecyclerView.VERTICAL, false);
        EntryRV.setLayoutManager(linearLayoutManager);

        EntryRV.setAdapter(EntryRVAdapter);
    }
}
