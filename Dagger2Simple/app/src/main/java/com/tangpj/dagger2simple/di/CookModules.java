package com.tangpj.dagger2simple.di;

import java.util.LinkedHashMap;
import java.util.Map;


import dagger.Module;
import dagger.Provides;

@Module
public class CookModules {

    @Provides
    public Map<String, Boolean> providerMenus(){
        Map<String, Boolean> menus = new LinkedHashMap<>();
        menus.put("酸菜鱼", false);
        menus.put("土豆丝", false);
        menus.put("铁板牛肉", false);

        return menus;
    }
}
