package com.tangpj.simplecalces

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_library1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("simple://library1"))
            startActivity(intent)
        }
        btn_library2.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("simple://library2"))
            startActivity(intent)
        }

    }
}
