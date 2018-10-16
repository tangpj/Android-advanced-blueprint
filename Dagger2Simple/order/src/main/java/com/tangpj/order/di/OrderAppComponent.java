package com.tangpj.order.di;

import com.tangpj.order.OrderApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityModules.class,
        LayoutManagerModules.class,
        FragmentBuildersModule.class,
        PresenterModules.class,
        DishesModules.class,
        CookAppModules.class})
public interface OrderAppComponent extends AndroidInjector<OrderApp>{

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<OrderApp>{
    }

}
