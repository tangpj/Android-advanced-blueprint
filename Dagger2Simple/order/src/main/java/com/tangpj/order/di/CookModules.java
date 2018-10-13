package com.tangpj.order.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CookModules {

    private static final String KEY_MENU = "menu";
    private static final String SP_COOK = "cook";

    @Singleton
    @Provides
    public Map<String, Boolean> providerMenus(SharedPreferences sp, Gson gson){
        Map<String, Boolean> menus;
        String menuJson = sp.getString(KEY_MENU, null);
        if (menuJson == null){
            return new LinkedHashMap<>();
        }
        menus = gson.fromJson(menuJson, new TypeToken<Map<String, Boolean>>(){}.getType());
        return menus;
    }

    @Singleton
    @Provides
    public SharedPreferences providerSharedPreferences(Context context){
        return context.getSharedPreferences(SP_COOK, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public Gson providerGson(){
        return new Gson();
    }
}
