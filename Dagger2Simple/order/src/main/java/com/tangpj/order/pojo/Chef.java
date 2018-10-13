package com.tangpj.order.pojo;


import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Chef implements Cooking{

    Menu menu;

    @Inject
    public Chef(Menu menu){
        this.menu = menu;
    }

    @Override
    public String cook(){
        Map<String,Boolean> menuList = menu.getMenus();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Boolean> entry : menuList.entrySet()){
            if (entry.getValue()){
                sb.append(entry.getKey()).append(",");
            }
        }

        return sb.toString();
    }
}
