package com.example.android_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // data to populate the RecyclerView with
        ArrayList<String> sectionNames = new ArrayList<>();
        sectionNames.add("Pharmacy");
        sectionNames.add("Registry");
        sectionNames.add("Cartwheel");
        // set up the RecyclerView
        RecyclerView recyclerView =
                findViewById(R.id.rvSections);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, sectionNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " +
                        adapter.getItem(position) + " on row number " + position,
                Toast.LENGTH_SHORT).show();
    }
}