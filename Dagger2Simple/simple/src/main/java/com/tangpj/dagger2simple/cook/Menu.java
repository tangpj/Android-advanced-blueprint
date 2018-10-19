package com.tangpj.dagger2simple.cook;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;


public class Menu {

    public Map<String,Boolean> menus;

    @Inject
    public Menu( Map<String,Boolean> menus){
        this.menus = menus;
    }

    Map<String,Boolean> getMenus(){
        return menus;
    }

}
