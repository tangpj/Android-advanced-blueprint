package com.tangpj.order.di;

import com.tangpj.order.ui.addedit.AddEditDishActivity;
import com.tangpj.order.ui.addedit.AddEditModules;
import com.tangpj.order.ui.dishes.DishesActivity;
import com.tangpj.order.ui.dishes.DishesModules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModules {

    @ContributesAndroidInjector(modules = DishesModules.class)
    abstract public DishesActivity contributesDishActivity();

    @ContributesAndroidInjector(modules = AddEditModules.class)
    abstract public AddEditDishActivity contributesAddEditDishActivity();

}
