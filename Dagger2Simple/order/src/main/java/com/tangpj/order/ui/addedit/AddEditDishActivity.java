package com.tangpj.order.ui.addedit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.tangpj.order.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static com.tangpj.order.ActivityUtils.addFragmentToActivity;

public class AddEditDishActivity extends DaggerAppCompatActivity {


    @Inject
    AddEditDishFragment mAddEditDishFragment;

    @Nullable
    @Inject
    String dishId;

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        AddEditDishFragment addEditDishFragment
                = (AddEditDishFragment)getSupportFragmentManager().findFragmentById(R.id.content_fragment);
        if (addEditDishFragment == null){
            addEditDishFragment = mAddEditDishFragment;
            addFragmentToActivity(getSupportFragmentManager(),addEditDishFragment, R.id.content_fragment);
        }

        initView();

    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (TextUtils.isEmpty(dishId)){
            getSupportActionBar().setTitle(R.string.add_dish);
        }else {
            getSupportActionBar().setTitle(R.string.edit_dish);
        }

    }
}
