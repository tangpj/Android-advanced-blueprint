package com.tangpj.order.ui.dishes;

import com.tangpj.order.BaseView;
import com.tangpj.order.pojo.Dish;

import java.util.ArrayList;
import java.util.Set;

import javax.inject.Inject;

public class DishesPresenter implements DishesContract.Presenter{

    private DishesContract.View mView;

    @Inject
    Set<Dish> dishes;

    @Inject
    public DishesPresenter(){

    }

    @Override
    public void loadDishes() {
        mView.showDishes(new ArrayList<>(dishes));
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
