package com.innovation.user.leave;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CCAdapter extends RecyclerView.Adapter<CCAdapter.CountryViewHolder> {

    private OnRecyclerListener mOnRecyclerListener;

    List<Country> countryList;

    public static class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cardView;
        ImageView imageView;
        TextView title;
        TextView titleHeader;
        TextView titleHeaderCountry;
        TextView titleHeaderCountryBelow;
        TextView more;
        OnRecyclerListener onRecyclerListener;

        CountryViewHolder(View itemView, OnRecyclerListener onRecyclerListener) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            titleHeader = itemView.findViewById(R.id.titleHeader);
            titleHeaderCountry = itemView.findViewById(R.id.titleHeaderCountry);
            titleHeaderCountryBelow = itemView.findViewById(R.id.titleHeaderCountryBelow);
            more = itemView.findViewById(R.id.more);
            itemView.setOnClickListener(this);
            this.onRecyclerListener = onRecyclerListener;
        }

        @Override
        public void onClick(View v) {
            onRecyclerListener.onRecyclerClick(getAdapterPosition());
        }
    }


    CCAdapter(List<Country> countryList, OnRecyclerListener onRecyclerListener){
        this.countryList = countryList;
        this.mOnRecyclerListener = onRecyclerListener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        CountryViewHolder pvh = new CountryViewHolder(v, mOnRecyclerListener);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder countryViewHolder, int i) {
        countryViewHolder.title.setText(countryList.get(i).title);
        countryViewHolder.titleHeader.setText(countryList.get(i).titleHeader);
        countryViewHolder.titleHeaderCountry.setText(countryList.get(i).titleHeaderCountry);
        countryViewHolder.titleHeaderCountryBelow.setText(countryList.get(i).titleHeaderCountryBelow);
        countryViewHolder.imageView.setImageResource(countryList.get(i).img);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public interface OnRecyclerListener{
        void onRecyclerClick(int position);
    }
}