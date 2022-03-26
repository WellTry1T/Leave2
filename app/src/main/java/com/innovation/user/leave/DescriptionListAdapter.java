package com.innovation.user.leave;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DescriptionListAdapter extends RecyclerView.Adapter<DescriptionListAdapter.DescriptionViewHolder> {


    public class DescriptionViewHolder extends RecyclerView.ViewHolder{

        CardView cardViewDesc;
        TextView titleDesc;
        TextView mainDesc;

        public DescriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewDesc = itemView.findViewById(R.id.cardViewDesc);
            titleDesc = itemView.findViewById(R.id.titleDesc);
            mainDesc = itemView.findViewById(R.id.mainDesc);
        }
    }

    List<String> descList;

    DescriptionListAdapter(ArrayList<String> descList){
        this.descList = descList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public DescriptionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_desc, viewGroup, false);
        DescriptionListAdapter.DescriptionViewHolder pvh = new DescriptionListAdapter.DescriptionViewHolder(v);
        return pvh;
    }

    public String[] mColors = {"#FF464868","#FF656846","#FF476846","#FF684661","#FF684646","#7DAE5400","#7DAE0000","#7D0003AE","#7D11AE00","#7DAE5100","#7DA800AE","#7DAE5400"};

    @Override
    public void onBindViewHolder(@NonNull DescriptionViewHolder descViewHolder, int i) {
//            descViewHolder.cardViewDesc.setBackgroundColor(Color.parseColor(mColors[i]));
            descViewHolder.cardViewDesc.setCardBackgroundColor(Color.parseColor(mColors[i]));
            if(i % 2 == 0) {
                try {
                    descViewHolder.titleDesc.setText(descList.get(i));
                    descViewHolder.mainDesc.setText(descList.get(i + 1));
                } catch (IndexOutOfBoundsException e) {

                }
            }else {
                descViewHolder.cardViewDesc.setVisibility(View.GONE);
            }
    }
    @Override
    public int getItemCount() {
        return descList.size();
    }
}
