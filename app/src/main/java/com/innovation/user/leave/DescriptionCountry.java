package com.innovation.user.leave;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DescriptionCountry extends AppCompatActivity{

    private ArrayList<String> descList;
    private RecyclerView recyclerViewDesc;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;
    private ImageView bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_country);
        bg = findViewById(R.id.bg);

        Intent intent = getIntent();
        descList = intent.getStringArrayListExtra("List");

        RecyclerView recyclerViewDesc = findViewById(R.id.recyclerViewDesc);

        LinearLayoutManager llm = new LinearLayoutManager(DescriptionCountry.this);
        recyclerViewDesc.setLayoutManager(llm);

        DescriptionListAdapter adapter = new DescriptionListAdapter(descList);
        recyclerViewDesc.setAdapter(adapter);

    }
}
