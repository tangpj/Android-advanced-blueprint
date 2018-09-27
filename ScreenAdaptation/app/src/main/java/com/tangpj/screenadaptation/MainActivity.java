package com.tangpj.screenadaptation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int sw = getResources().getConfiguration().smallestScreenWidthDp;
        tvSw = findViewById(R.id.tv_sw);
        tvSw.setText("sw = " + sw + "dp");
    }
}
