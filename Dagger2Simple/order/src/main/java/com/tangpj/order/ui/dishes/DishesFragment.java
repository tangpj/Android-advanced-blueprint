package com.tangpj.order.ui.dishes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangpj.order.R;
import com.tangpj.order.pojo.Dish;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class DishesFragment extends DaggerFragment implements DishesContract.View{

    RecyclerView rvDishes;

    @Inject
    DishesAdapter dishesAdapter;

    @Inject
    RecyclerView.LayoutManager layoutManager;

    @Inject
    DishesContract.Presenter mPresenter;

    @Inject
    public DishesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dishes, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    public void initView(View view){
        rvDishes = view.findViewById(R.id.rv_dishes);
        rvDishes.setAdapter(dishesAdapter);
        rvDishes.setLayoutManager(layoutManager);

    }

    @Override
    public void showDishes(List<Dish> dishes) {
        dishesAdapter.setDishes(dishes);
    }

}
