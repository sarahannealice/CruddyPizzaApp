package com.example.cruddypizzaapp;

import androidx.recyclerview.widget.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
        ImageButton btnEdit, btnList, btnDelete;

        //variables
        private final Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            orderTV = itemView.findViewById(R.id.orderTV);
            btnList = itemView.findViewById(R.id.btnList);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        int orderNum = orderList.indexOf(orderList.get(position)) + 1000;
        String quickLookup = "order#" + orderNum + "\n" + orderList.get(position).getName() + "\n" +
                orderList.get(position).getPhone() + "\nsize: " + orderList.get(position).getSize();
        String details = orderList.get(position).getName() + "\n" + orderList.get(position).getPhone()
                + "\nsize: " + orderList.get(position).getSize() + "\ntoppings:\n\t\t" + orderList.get(position).getTop1()
                + "\n\t\t" + orderList.get(position).getTop2() + "\n\t\t" + orderList.get(position).getTop3();
        //create string for this text view in advance if this works
        holder.orderTV.setText(quickLookup);

        //onclick for delete order
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //https://stackoverflow.com/a/45413953
                orderList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, orderList.size());
            }
        });//end delete order onclick

        //onclick for view order details
        holder.btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailsIntent = new Intent(v.getContext(), DetailsPage.class);
                Context context = v.getContext();
                context.startActivity(detailsIntent);
            }
        });//end view order details

        //onclick for edit order
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//end of edit order
    }//end onBindViewHolder

    @Override
    public int getItemCount() {
        return orderList.size();
    }


}
