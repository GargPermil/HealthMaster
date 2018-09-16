package com.mann.healthmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mann.healthmaster.Modal.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class TudoWarActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    RecyclerView mRecyclerView1;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> alName;
    ArrayList<Integer> alImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudo_war);

        ArrayList<Player> data = new ArrayList<>();
        data.add(new Player("Cheesy...", null, 1));
        data.add(new Player("Crispy... ", null, 2));
        data.add(new Player("Fizzy...", null, 3));
        data.add(new Player("Fruity...", null, 4));

        // Calling the RecyclerView
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView1 = findViewById(R.id.recycler_view1);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HLVAdapter(TudoWarActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView1.setAdapter(mAdapter);
    }
}