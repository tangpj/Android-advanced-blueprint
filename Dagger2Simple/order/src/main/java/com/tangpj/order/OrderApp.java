package com.tangpj.order;

import com.tangpj.order.di.DaggerOrderAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class OrderApp extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerOrderAppComponent.builder().create(this);
    }
}
