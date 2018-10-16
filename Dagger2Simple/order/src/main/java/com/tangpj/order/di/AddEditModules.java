package com.tangpj.order.di;

import android.support.annotation.Nullable;

import com.tangpj.order.ui.addedit.AddEditDishActivity;
import com.tangpj.order.ui.addedit.AddEditDishContract;
import com.tangpj.order.ui.addedit.AddEditDishFragment;
import com.tangpj.order.ui.addedit.AddEditDishPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class AddEditModules {

    @ActivityScoped
    @Provides
    @Nullable
    static public String providesDishId(AddEditDishActivity activity){
        return activity.getIntent().getStringExtra(AddEditDishFragment.EDIT_DISH_ID);
    }

    @ActivityScoped
    @Binds
    abstract AddEditDishContract.Presenter addEditPresenter(AddEditDishPresenter presenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract public AddEditDishFragment addEditDishFragment();
}
