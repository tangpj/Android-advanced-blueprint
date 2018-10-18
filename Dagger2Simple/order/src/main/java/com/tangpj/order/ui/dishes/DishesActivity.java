package com.tangpj.order.ui.dishes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tangpj.order.ActivityUtils;
import com.tangpj.order.R;
import com.tangpj.order.ui.addedit.AddEditDishActivity;

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
        setContentView(R.layout.activity_dishes);

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

        FloatingActionButton fb = findViewById(R.id.fab);
        fb.setOnClickListener(v -> {
            String order = mDishesFragment.order();
            if (!TextUtils.isEmpty(order)) Snackbar.make(toolbar, order, Snackbar.LENGTH_SHORT).show();

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dishes, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(this, AddEditDishActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
