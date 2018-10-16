package com.tangpj.order.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;

@Module
public class LayoutManagerModules {

    @Provides
    public LinearLayoutManager providesLinearLayoutManager(Context context){
        return new LinearLayoutManager(context);
    }
}
