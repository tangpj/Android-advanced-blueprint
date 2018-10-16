package com.tangpj.order.ui.dishes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.tangpj.order.ActivityUtils;
import com.tangpj.order.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class DishesActivity extends DaggerAppCompatActivity {

    @Inject
    DishesFragment mDishesFragment;

    @Inject
    DishesContract.Presenter mPresenter;

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        DishesFragment dishesFragment
                = (DishesFragment) getSupportFragmentManager().findFragmentById(R.id.content_fragment);

        if (dishesFragment == null){
            dishesFragment = mDishesFragment;
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), dishesFragment, R.id.content_fragment);
        }
        initView();

    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.menus);

    }
}
