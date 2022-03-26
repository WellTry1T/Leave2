package com.innovation.user.leave;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class WayListAdapter extends RecyclerView.Adapter<WayListAdapter.WayViewHolder> {


    private OnPlusListener mOnPlusListener;

    public class WayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardViewWay;
        TextView titleWay;
        TextView titleMain;
        ImageButton floatingActionButton;
        ImageView iconCircle;
        OnPlusListener onPlusListener;
        Button description;
        String[] list;

        public WayViewHolder(@NonNull View itemView, OnPlusListener onPlusListener) {
            super(itemView);
            cardViewWay = itemView.findViewById(R.id.cardViewWay);
            titleWay = itemView.findViewById(R.id.titleWay);
            iconCircle = itemView.findViewById(R.id.iconCircle);
            titleMain = itemView.findViewById(R.id.titleMain);
            floatingActionButton = itemView.findViewById(R.id.floatingActionButton);
            this.onPlusListener = onPlusListener;
            floatingActionButton.setOnClickListener(this);
            description = itemView.findViewById(R.id.description);
            description.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            onPlusListener.onPlusClick(v, getAdapterPosition());
            if (v.equals(floatingActionButton)) {
                remove(getAdapterPosition());
            } else if (onPlusListener != null) {
                onPlusListener.onPlusClick(v, getAdapterPosition());
            }

            switch (v.getId()) {
                case R.id.description:
                    onPlusListener.onDescClick(v, getAdapterPosition());
            }
        }

        public void remove(int position) {
//        wayList.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, wayList.size());
            Object obj = wayList.get(position);
            wayList.clear();
            wayList.add((Way) obj);
//        wayList.add(0, new Way(wayList.get(position).titleWay,
//                            wayList.get(position).titleMain,
//                            wayList.get(position).iconCircle,
//                            wayList.get(position).floatingActionButton));
            notifyDataSetChanged();
        }
    }

    List<Way> wayList;

    WayListAdapter(List<Way> wayList, OnPlusListener onPlusListener){
        this.wayList = wayList;
        this.mOnPlusListener = onPlusListener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public WayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_way, viewGroup, false);
        WayListAdapter.WayViewHolder pvh = new WayListAdapter.WayViewHolder(v, mOnPlusListener);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull WayViewHolder wayViewHolder, int i) {
        wayViewHolder.titleWay.setText(wayList.get(i).titleWay);
        wayViewHolder.iconCircle.setImageResource(wayList.get(i).iconCircle);
        wayViewHolder.titleMain.setText(wayList.get(i).titleMain);
        if(wayList.get(i).isImageChanged()){
            wayViewHolder.description.setVisibility(View.VISIBLE);
            wayViewHolder.floatingActionButton.setVisibility(View.INVISIBLE);
//            wayViewHolder.floatingActionButton.setImageResource(R.drawable.ic_remove);
//            wayViewHolder.floatingActionButton.setBackgroundColor(Color.parseColor("#BAFFCED9"));
        }else{
            wayViewHolder.floatingActionButton.setImageResource(R.drawable.ic_add);
            wayViewHolder.floatingActionButton.setBackgroundColor(Color.parseColor("#D26EA570"));
        }
        wayViewHolder.description.setId(wayList.get(i).description);
    }

    @Override
    public int getItemCount() {
        return wayList.size();
    }

    public interface OnPlusListener{
        void onPlusClick(View v, int position);
        void onDescClick(View v, int position);

    }
}