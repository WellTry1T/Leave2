package com.innovation.user.leave;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class ChoiceCountry extends Activity implements CCAdapter.OnRecyclerListener {

    private List<Country> countryList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_country);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(ChoiceCountry.this);
        recyclerView.setLayoutManager(llm);

        countryList = new ArrayList<>();
        countryList.add(new Country("Канада",
                "Уровень жизни:",
                "18 место по версии \"Numbeo\"",
                "с индексом 170.32",
                R.drawable.bg_canada));

        CCAdapter adapter = new CCAdapter(countryList, this);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onRecyclerClick(int position) {
        Intent intent = new Intent(this, SelectedCountry.class);
        intent.putExtra("country", countryList.get(position).title);
        startActivity(intent);
    }
}
