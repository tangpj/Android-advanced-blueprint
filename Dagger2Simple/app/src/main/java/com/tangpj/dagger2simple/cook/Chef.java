package com.tangpj.dagger2simple.cook;

import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

public class Chef implements Cooking{

    public static final String TAG = "Chef";

    @Inject
    Menu menu;

    @Override
    public String cook(){
        Map<String,Boolean> menuList = menu.getMenus();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Boolean> entry : menuList.entrySet()){
            if (entry.getValue()){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
