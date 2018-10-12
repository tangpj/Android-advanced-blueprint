package com.tangpj.dagger2simple;

import com.tangpj.dagger2simple.di.DaggerCookComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;

public class MyApplication extends DaggerApplication{



    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerCookComponent.builder().create(this);
    }
}
