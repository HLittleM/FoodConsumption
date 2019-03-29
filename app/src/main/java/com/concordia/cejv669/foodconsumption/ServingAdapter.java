package com.concordia.cejv669.foodconsumption;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServingAdapter extends RecyclerView.Adapter<ServingAdapter.MyViewHolder>{
        List<Serving> servingList;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView entryDate,name, calories, quantity, totalCalories;
    ImageView warning;

    MyViewHolder(View view) {
        super(view);
        entryDate= view.findViewById(R.id.textViewDate);
        name = view.findViewById(R.id.textViewName);
        calories=view.findViewById(R.id.textViewCalories);
        quantity=view.findViewById(R.id.textViewQuantity);
        totalCalories=view.findViewById(R.id.textViewTotalCalories);
        warning=view.findViewById(R.id.imageViewWarning);
    }

}

    ServingAdapter(List<Serving> servingList) {
        this.servingList = servingList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.serving_row, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServingAdapter.MyViewHolder viewHolder, int i) {
        final Serving serving= servingList.get(i);
        Date rawDate=new Date(serving.getRecordDate());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
        String strDate = dateFormat.format(rawDate);
        viewHolder.entryDate.setText(String.valueOf(strDate));
        viewHolder.name.setText(serving.getName());
        viewHolder.calories.setText(serving.getCalories()+" Cal./Unit");
        viewHolder.quantity.setText(serving.getQuantity()+" Unit");
        int tCal=serving.getCalories()*serving.getQuantity();
        viewHolder.totalCalories.setText(tCal+" Cal. ");
        if(tCal>1000){
            viewHolder.warning.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return this.servingList.size();
    }
}
