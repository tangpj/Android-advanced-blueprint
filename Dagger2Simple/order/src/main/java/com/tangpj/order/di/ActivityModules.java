package com.tangpj.order.di;

import com.tangpj.order.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class ActivityModules {

    @ContributesAndroidInjector
    abstract public MainActivity contributesMainActivity();
}
