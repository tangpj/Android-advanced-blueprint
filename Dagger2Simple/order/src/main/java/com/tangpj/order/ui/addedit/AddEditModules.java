package com.tangpj.order.ui.addedit;


import com.tangpj.order.di.ActivityScoped;
import com.tangpj.order.di.FragmentScoped;


import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class AddEditModules {

    @Provides
    @ActivityScoped
     public static String providesDishId(AddEditDishActivity activity){
        return activity.getIntent().getStringExtra(AddEditDishFragment.EDIT_DISH_ID);
    }

    @Binds
    abstract AddEditDishContract.Presenter addEditDishesPresenter(AddEditDishPresenter presenter);

    @Binds
    abstract AddEditDishContract.View addEditView(AddEditDishFragment addEditDishFragment);

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract public AddEditDishFragment addEditDishFragment();

}
