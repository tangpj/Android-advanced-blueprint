package com.tangpj.order.ui.addedit;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.tangpj.order.di.CookAppModules;
import com.tangpj.order.pojo.Dish;

import java.util.Set;

import javax.inject.Inject;


public class AddEditDishPresenter implements AddEditDishContract.Presenter {

    private String mId;
    private AddEditDishContract.View mView;
    private Dish mDish;

    @Inject
    SharedPreferences sp;

    @Inject
    Set<Dish> dishSet;

    @Inject
    Gson gson;

    @Inject
    public AddEditDishPresenter(@Nullable String id){
        this.mId = id;

    }

    @Override
    public void saveDish(String name, String description) {
        dishSet.remove(mDish);
        mDish = new Dish(name, description);
        dishSet.add(mDish);

        sp.edit().putString(CookAppModules.KEY_MENU, gson.toJson(dishSet)).apply();
        mView.saveSucceed(mDish);
    }

    @Override
    public void loadDish() {
        if (TextUtils.isEmpty(mId)) return;
        for (Dish dish : dishSet){
            if (mId.equals(dish.getId())){
                mDish = dish;
                mView.showDish(mDish);
            }
        }
    }


    @Override
    public void takeView(AddEditDishContract.View view) {
        mView = view;
        loadDish();

    }

    @Override
    public void dropView() {
        mView = null;
    }
}
