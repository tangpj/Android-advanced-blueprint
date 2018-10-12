package com.tangpj.dagger2simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tangpj.dagger2simple.cook.Chef;
import com.tangpj.dagger2simple.cook.Menu;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import dagger.android.support.AndroidSupportInjection;

public class MainActivity extends DaggerActivity {

    TextView tvMenu;

    @Inject
    Menu menu;

    @Inject
    Chef chef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu.menus.put("酸菜鱼", true);
        tvMenu = findViewById(R.id.tv_menu);
        tvMenu.setText(chef.cook());
    }
}
