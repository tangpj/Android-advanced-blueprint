package com.tangpj.order.di;

import com.tangpj.order.OrderApp;
import com.tangpj.order.ui.dishes.DishesModules;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        LayoutManagerModules.class,
        CookAppModules.class,
        ActivityModules.class})
public interface OrderAppComponent extends AndroidInjector<OrderApp>{

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<OrderApp>{
    }

}
