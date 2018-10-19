package com.tangpj.order.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class LayoutManagerModules {

    @Named("vertical")
    @Provides
    public LinearLayoutManager providesLinearLayoutManager(Context context){
        return new LinearLayoutManager(context);
    }

    @Named("horizontal")
    @Provides
    public LinearLayoutManager providesHorizontalLinearLayoutManager(Context context){
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }


}
