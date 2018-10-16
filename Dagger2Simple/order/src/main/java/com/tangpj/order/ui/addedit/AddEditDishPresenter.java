package com.tangpj.order.ui.addedit;

import android.support.annotation.Nullable;

import com.tangpj.order.pojo.Dish;

import java.util.Set;

import javax.inject.Inject;

public class AddEditDishPresenter implements AddEditDishContract.Presenter {

    private String mId;
    private AddEditDishContract.View mView;
    private Dish mDish;

    @Inject
    Set<Dish> dishSet;

    @Inject
    public AddEditDishPresenter(@Nullable String id){
        this.mId = id;

    }

    @Override
    public void saveDish(String name, String description) {
        dishSet.remove(mDish);
        mDish = new Dish(mDish.getName(), mDish.getDescription(), mDish.getIsSelect());
        dishSet.add(mDish);
    }

    @Override
    public void loadDish() {
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
