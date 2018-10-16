package com.tangpj.order.di;

import com.tangpj.order.ui.addedit.AddEditDishActivity;
import com.tangpj.order.ui.dishes.DishesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class ActivityModules {

    @ActivityScoped
    @ContributesAndroidInjector(modules = AddEditModules.class)
    abstract public AddEditDishActivity contributesAddEditDishActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = DishesModules.class)
    abstract public DishesActivity contributesDishActivity();
}
