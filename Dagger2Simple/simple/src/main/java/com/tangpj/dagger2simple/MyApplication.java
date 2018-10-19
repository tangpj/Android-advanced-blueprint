package com.tangpj.dagger2simple;




import com.tangpj.dagger2simple.cook.Chef;
import com.tangpj.dagger2simple.di.DaggerCookAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyApplication extends DaggerApplication{

    @Inject
    Chef chef;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerCookAppComponent.builder().create(this);
    }
}
