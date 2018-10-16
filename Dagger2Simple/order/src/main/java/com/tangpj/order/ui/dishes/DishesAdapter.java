package com.tangpj.order.ui.dishes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tangpj.order.R;
import com.tangpj.order.pojo.Dish;

import java.util.List;

import javax.inject.Inject;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.DishHolder>{

    private List<Dish> dishes;

    @Inject
    public DishesAdapter(){

    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
        notifyDataSetChanged();
    }

    public Dish getDish(int position){
        return dishes.get(position);
    }

    @NonNull
    @Override
    public DishHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_menu, viewGroup, false);
        return new DishHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishHolder dishHolder, int i) {
        Dish dish = getDish(i);
        dishHolder.isSelect.setChecked(dish.getIsSelect());
        dishHolder.tvName.setText(dish.getName());
    }

    @Override
    public int getItemCount() {
        return dishes == null ? 0 : dishes.size();
    }

    class DishHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        CheckBox isSelect;

        DishHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text);
            isSelect = itemView.findViewById(R.id.cb);
        }
    }
}
