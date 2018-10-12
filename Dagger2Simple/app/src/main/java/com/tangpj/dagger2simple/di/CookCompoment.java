package com.tangpj.dagger2simple.di;

import dagger.Component;

@Component(modules = {CookModules.class})
public interface CookCompoment {

    void inject();
}
