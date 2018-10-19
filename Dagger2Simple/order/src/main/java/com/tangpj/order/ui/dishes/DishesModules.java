package com.tangpj.order.ui.dishes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tangpj.order.di.DishesScoped;


import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DishesModules {

    @ContributesAndroidInjector
    abstract public DishesFragment dishesFragment();

    @Provides
    static DishesAdapter providerDishesAdapter(){
        return new DishesAdapter();
    }

    @DishesScoped
    @Binds
    abstract DishesContract.Presenter dishesPresenter(DishesPresenter presenter);

    @Binds
    abstract DishesContract.View dishesView(DishesFragment dishesFragment);

    @Binds
    abstract RecyclerView.LayoutManager layoutManager(LinearLayoutManager linearLayoutManager);


}
