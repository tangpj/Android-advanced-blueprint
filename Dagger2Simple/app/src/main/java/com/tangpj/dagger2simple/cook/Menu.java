package com.tangpj.dagger2simple.cook;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Menu {

    @Inject
    public Map<String,Boolean> menus;

    Map<String,Boolean> getMenus(){
        return menus;
    }

    @Inject
    public Menu(){}

}
