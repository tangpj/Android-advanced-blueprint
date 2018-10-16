package com.tangpj.order.di;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tangpj.order.ui.dishes.DishesAdapter;
import com.tangpj.order.ui.dishes.DishesContract;
import com.tangpj.order.ui.dishes.DishesFragment;
import com.tangpj.order.ui.dishes.DishesPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DishesModules {

    @Binds
    abstract DishesContract.Presenter dishesPresenter(DishesPresenter presenter);

    @Provides
    static DishesAdapter providerDishesAdapter(){
        return new DishesAdapter();
    }

    @Binds
    abstract public RecyclerView.LayoutManager layoutManager(LinearLayoutManager linearLayoutManager);

    @ContributesAndroidInjector
    abstract public DishesFragment dishesFragment();
}
