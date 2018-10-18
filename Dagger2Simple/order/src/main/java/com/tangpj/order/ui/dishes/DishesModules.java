package com.tangpj.order.ui.dishes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tangpj.order.di.FragmentScoped;
import com.tangpj.order.ui.addedit.AddEditDishFragment;
import com.tangpj.order.ui.dishes.DishesActivity;
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

    @Provides
    static DishesAdapter providerDishesAdapter(){
        return new DishesAdapter();
    }

    @Binds
    abstract DishesContract.Presenter dishesPresenter(DishesPresenter presenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract public DishesFragment dishesFragment();

    @Binds
    abstract RecyclerView.LayoutManager layoutManager(LinearLayoutManager linearLayoutManager);


}
