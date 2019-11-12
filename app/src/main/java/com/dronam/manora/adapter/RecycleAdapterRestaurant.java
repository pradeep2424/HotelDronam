package com.dronam.manora.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dronam.manora.R;
import com.dronam.manora.listeners.OnRecyclerViewClickListener;
import com.dronam.manora.model.RestaurantObject;
import java.util.ArrayList;

public class RecycleAdapterRestaurant extends RecyclerView.Adapter<RecycleAdapterRestaurant.ViewHolder> {
    Context context;
    private OnRecyclerViewClickListener clickListener;

    ArrayList<RestaurantObject> listRestaurants;

    public RecycleAdapterRestaurant(Context context, ArrayList<RestaurantObject> listRestaurants) {
        this.context = context;
        this.listRestaurants = listRestaurants;
    }

    public void setClickListener(OnRecyclerViewClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivRestaurantImage;
        TextView tvRestaurantName;
        TextView tvRestaurantAddress;
        TextView tvRestaurantReviews;
        RatingBar ratingBarReviews;

        public ViewHolder(View itemView) {
            super(itemView);

             ivRestaurantImage = itemView.findViewById(R.id.iv_restaurantImage);
             tvRestaurantName = itemView.findViewById(R.id.tv_restaurantName);
             tvRestaurantAddress = itemView.findViewById(R.id.tv_restaurantAddress);
             tvRestaurantReviews = itemView.findViewById(R.id.tv_restaurantReviews);
             ratingBarReviews = itemView.findViewById(R.id.ratingBar_restaurantReviews);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }

    @Override
    public RecycleAdapterRestaurant.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_restaurant,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterRestaurant.ViewHolder holder, int position) {
        RestaurantObject restaurantObj =  listRestaurants.get(position);

        holder.tvRestaurantName.setText(restaurantObj.getRestaurantName());
//        holder.tvRestaurantAddress.setText();
//        holder.tvRestaurantReviews.setText();
//        holder.ratingBarReviews.setRating();

         Glide.with(context).load(restaurantObj.getLogo()).into(holder.ivRestaurantImage);
    }

    @Override
    public int getItemCount() {
        return listRestaurants.size();
    }
}
