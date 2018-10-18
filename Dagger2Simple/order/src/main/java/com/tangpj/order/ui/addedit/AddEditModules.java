package com.tangpj.order.ui.addedit;

import android.support.annotation.Nullable;

import com.tangpj.order.di.FragmentScoped;
import com.tangpj.order.ui.addedit.AddEditDishActivity;
import com.tangpj.order.ui.addedit.AddEditDishContract;
import com.tangpj.order.ui.addedit.AddEditDishFragment;
import com.tangpj.order.ui.addedit.AddEditDishPresenter;
import com.tangpj.order.ui.dishes.DishesFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class AddEditModules {

    @Provides
    @Nullable
    static public String providesDishId(AddEditDishActivity activity){
        return activity.getIntent().getStringExtra(AddEditDishFragment.EDIT_DISH_ID);
    }

    @Binds
    abstract AddEditDishContract.Presenter addEditPresenter(AddEditDishPresenter presenter);


    @FragmentScoped
    @ContributesAndroidInjector()
    abstract public AddEditDishFragment addEditDishFragment();

}
