package com.tangpj.order.ui.dishes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tangpj.order.R;
import com.tangpj.order.pojo.Dish;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.DishHolder>{

    private List<Dish> dishes;

    private Map<Dish, Boolean> selectMap;

    private int position = -1;

    @Inject
    public DishesAdapter(){

    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
        Map<Dish, Boolean> map = new LinkedHashMap<>((int)(dishes.size() / 0.75));
        for (Dish dish : dishes){
            if (selectMap != null
                    && selectMap.containsKey(dish)
                    && selectMap.get(dish)) map.put(dish,true);
            else map.put(dish, false);
        }
        selectMap = map;
        notifyDataSetChanged();
    }

    public Dish getDish(int position){
        return dishes.get(position);
    }

    public boolean isSelect(Dish dish){
        return selectMap.get(dish);
    }

    public HashMap<Dish, Boolean> getSelectMap() {
        return new HashMap<>(selectMap);
    }

    public Dish getLongClickDish(){
        if (position == - 1 || position >= dishes.size() ) return null;
        return getDish(position);
    }

    public int getLongClickPosition(){
        return position;
    }

    public boolean removedDish(Dish dish){
        int removePos = dishes.indexOf(dish);
        if (removePos < 0 ) return false;
        dishes.remove(removePos);
        notifyItemRemoved(removePos);
        return true;
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
        dishHolder.isSelect.setChecked(selectMap.get(dish));
        dishHolder.tvName.setText(dish.getName());
        dishHolder.itemView.setOnClickListener(v -> {
            selectMap.put(dish, !selectMap.get(dish));
            notifyItemChanged(i);
        });
        dishHolder.itemView.setOnLongClickListener(v -> {
            this.position = i;
            return false;
        });
    }

    @Override
    public void onViewRecycled(@NonNull DishHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return dishes == null ? 0 : dishes.size();
    }


    class DishHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        CheckBox isSelect;

        DishHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.text);
            isSelect = itemView.findViewById(R.id.cb);
        }

    }
}
