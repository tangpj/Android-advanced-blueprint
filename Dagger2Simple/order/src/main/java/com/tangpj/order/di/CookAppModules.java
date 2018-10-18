package com.tangpj.order.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tangpj.order.OrderApp;
import com.tangpj.order.pojo.Dish;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class CookAppModules {

    public static final String KEY_MENU = "menu";
    private static final String SP_COOK = "cook";

    @Singleton
    @Provides
    public static Set<Dish> providerMenus(SharedPreferences sp, Gson gson){
        Set<Dish> menus;
        String menuJson = sp.getString(KEY_MENU, null);
        if (menuJson == null){
            return new LinkedHashSet<>();
        }
        menus = gson.fromJson(menuJson, new TypeToken<Set<Dish>>(){}.getType());
        return menus;
    }

    @Singleton
    @Provides
    public static SharedPreferences providerSharedPreferences(Context context){
        return context.getSharedPreferences(SP_COOK, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public static Gson providerGson(){
        return new Gson();
    }

    @Singleton
    @Binds
    public abstract Context context(OrderApp application);

}
