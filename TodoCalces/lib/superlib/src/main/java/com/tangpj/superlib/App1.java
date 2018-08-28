package com.tangpj.superlib;

import android.app.Application;
import android.util.Log;

public class App1 extends Application{
    private static final String TAG = "App1";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate App1");
    }
}
