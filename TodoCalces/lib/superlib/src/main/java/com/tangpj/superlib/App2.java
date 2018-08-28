package com.tangpj.superlib;

import android.app.Application;
import android.util.Log;

public class App2 extends Application{

    private static final String TAG = "App2";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate App2");
    }
}
