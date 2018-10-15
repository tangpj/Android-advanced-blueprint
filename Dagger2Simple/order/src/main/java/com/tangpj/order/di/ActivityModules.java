package com.tangpj.order.di;

import com.tangpj.order.MainActivity;
import com.tangpj.order.ui.addedit.AddEditDishActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class ActivityModules {

    @ContributesAndroidInjector
    abstract public MainActivity contributesMainActivity();

    @ContributesAndroidInjector(modules = AddEditModules.class)
    abstract public AddEditDishActivity contributesAddEditDishActivity();
}
