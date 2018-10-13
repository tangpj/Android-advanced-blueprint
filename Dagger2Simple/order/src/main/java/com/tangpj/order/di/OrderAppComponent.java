package com.tangpj.order.di;

import com.tangpj.order.OrderApp;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityModules.class,
        CookModules.class})
public interface OrderAppComponent extends AndroidInjector<OrderApp>{

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<OrderApp>{}

}
