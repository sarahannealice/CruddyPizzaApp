package com.example.cruddypizzaapp;

import androidx.recyclerview.widget.*;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    public ArrayList<Order> orderList;

    public OrderAdapter(ArrayList<Order> orderHistoryList) {
        orderList = orderHistoryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderTV;
        ImageButton delete;

        public ViewHolder(View itemView) {
            super(itemView);
            orderTV = itemView.findViewById(R.id.orderTV);
        }
    }

    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position) {
        //create string for this text view in advance if this works
        holder.orderTV.setText(orderList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }



}
