package com.tangpj.order.ui.addedit;

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
    public AddEditDishPresenter(String id, AddEditDishContract.View view){
        this.mId = id;
        this.mView = view;

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
    public void start() {
        mView.setPresenter(this);
        loadDish();
    }
}
