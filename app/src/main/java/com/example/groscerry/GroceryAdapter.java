package com.example.groscerry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelGrocery> mList;
    OnCheckListener checkListener;

    GroceryAdapter(Context context, OnCheckListener checkListener,  ArrayList<ModelGrocery> list){
        mContext = context;
        mList = list;
        this.checkListener = checkListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_grocery_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ModelGrocery groceryItem = mList.get(position);

        ImageView image = holder.item_image;
        TextView name, days, time, price;

        name = holder.item_name;
        days = holder.item_days;
        time = holder.item_time;
        price = holder.item_price;

        RatingBar rating = holder.item_rating;
        CheckBox checkBox = holder.item_checkbox;


        image.setImageResource(groceryItem.getImage());

        name.setText(groceryItem.getName());
        days.setText(groceryItem.getDays());
        time.setText(groceryItem.getTime());
        price.setText(groceryItem.getPrice());

        rating.setRating(groceryItem.getRating());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkListener.onCheck(groceryItem, isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_name, item_time, item_days, item_price;
        RatingBar item_rating;
        CheckBox item_checkbox;

        public ViewHolder(View itemView) {

            super(itemView);


            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_days = itemView.findViewById(R.id.item_days);
            item_time = itemView.findViewById(R.id.item_time);
            item_price = itemView.findViewById(R.id.item_price);
            item_rating =itemView.findViewById(R.id.item_rating);
            item_checkbox = itemView.findViewById(R.id.checkBox);
        }
    }
    interface OnCheckListener {
        void onCheck (ModelGrocery grocery, boolean check );
    }

}
