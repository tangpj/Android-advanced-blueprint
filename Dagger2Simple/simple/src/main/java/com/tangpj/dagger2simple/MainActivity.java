package com.tangpj.dagger2simple;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tangpj.dagger2simple.cook.Chef;
import com.tangpj.dagger2simple.cook.Menu;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import dagger.android.support.AndroidSupportInjection;

public class MainActivity extends DaggerActivity {

    private static final String TAG = "MainActivity";

    @Inject
    Chef chef;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCook(View view){
        Toast.makeText(this, chef.cook(), Toast.LENGTH_SHORT).show();
    }
}
