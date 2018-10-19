package com.tangpj.order.ui.dishes;

import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.tangpj.order.di.CookAppModules;
import com.tangpj.order.di.DishesScoped;
import com.tangpj.order.pojo.Dish;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

public class DishesPresenter implements DishesContract.Presenter{

    private DishesContract.View mView;

    @Inject
    Set<Dish> dishes;

    @Inject
    Gson gson;

    @Inject
    SharedPreferences sp;

    @Inject
    public DishesPresenter(){

    }

    @Override
    public void loadDishes() {
        mView.showDishes(new ArrayList<>(dishes));
    }

    @Override
    public String order(Map<Dish, Boolean> selectMap) {
        if (selectMap == null || selectMap.size() == 0) return "";
        StringBuilder sb = new StringBuilder();

        for (Dish dish : dishes){
            if (selectMap.get(dish)){
                sb.append(dish.getName()).append("、");
            }
        }
        if (TextUtils.isEmpty(sb.toString())) return "";

        return "烹饪: " + sb.toString();
    }

    @Override
    public boolean deleteDish(String id) {
        for (Dish dish : dishes){
            if (dish.getId().equals(id)){
                dishes.remove(dish);
                sp.edit().putString(CookAppModules.KEY_MENU, gson.toJson(dishes)).apply();
                return true;
            }
        }
        return false;
    }


    @Override
    public void takeView(DishesContract.View view) {
        mView = view;
        loadDishes();
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
