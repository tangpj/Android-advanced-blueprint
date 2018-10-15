package com.tangpj.order.di;

import com.tangpj.order.ui.addedit.AddEditDishContract;
import com.tangpj.order.ui.addedit.AddEditDishFragment;
import com.tangpj.order.ui.addedit.AddEditDishPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class AddEditModules {

    @Provides
    public String providesDishId(AddEditDishFragment fragment){
        return fragment.getActivity().getIntent().getStringExtra(AddEditDishFragment.EDIT_DISH_ID);
    }

    @ContributesAndroidInjector
    abstract public AddEditDishFragment addEditDishFragment();

    @Binds
    abstract AddEditDishContract.Presenter addEditPresenter(AddEditDishPresenter presenter);
}
