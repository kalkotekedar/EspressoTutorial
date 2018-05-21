package com.incubxperts.espressotutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Dashboard extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_titles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        TitlesAdapter mTitlesAdapter = new TitlesAdapter(getApplicationContext());
        mRecyclerView.setAdapter(mTitlesAdapter);
    }
}