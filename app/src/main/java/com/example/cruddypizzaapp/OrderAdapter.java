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
        //views
        TextView orderTV;
        ImageButton btnEdit, btnView, btnDelete;


        public ViewHolder(View itemView) {
            super(itemView);
            orderTV = itemView.findViewById(R.id.orderTV);
            btnView = itemView.findViewById(R.id.btnView);
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

        int orderNum = orderList.indexOf(orderList.get(position)) + 1001;
        String quickLookup = "order#" + orderNum + "\n" + orderList.get(position).getName() + "\n" +
                orderList.get(position).getPhone();
        //create string for this text view in advance if this works
        holder.orderTV.setText(quickLookup);

        //onclick for delete order
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //delete order from database
                DBAdapter dbAdapter = new DBAdapter(v.getContext());
                dbAdapter.open();

                if (dbAdapter.deleteOrder(orderList.get(position).getOrderNum())) {
//                if (dbAdapter.deleteOrder(orderList.indexOf(orderList.get(position))+1)) {
                    Toast.makeText(v.getContext(),"delete successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(v.getContext(),"failed to delete order", Toast.LENGTH_SHORT).show();
                }

                dbAdapter.close();

                //https://stackoverflow.com/a/45413953
                orderList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, orderList.size());
            }
        });//end delete order onclick

        //onclick for view order details
        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start detail page activity -- https://stackoverflow.com/a/28767516
                Intent detailsIntent = new Intent(v.getContext(), DetailsPage.class);
                detailsIntent.putExtra("KEY", orderList.indexOf(orderList.get(position)));
                Context context = v.getContext();
                context.startActivity(detailsIntent);
            }
        });//end view order details

        //onclick for edit order
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String KEY = "KEY";

                //sending order to display method
//                DisplayDetails.orderDetailsDisplayed(orderList.get(position));

                Intent editIntent = new Intent(v.getContext(), OrderPage.class);
                editIntent.putExtra(KEY, orderList.indexOf(orderList.get(position)));
                Context context = v.getContext();
                context.startActivity(editIntent);
            }
        });//end of edit order
    }//end onBindViewHolder

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    //------------------------method------------------------//
//    public void
}//end order adapter class
