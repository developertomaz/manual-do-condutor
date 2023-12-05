package com.manualdocondutor.manualdocondutor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView



class LogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        val btn_logo: ImageView= findViewById(R.id.btn_logo)
        btn_logo.setOnClickListener {

            val go = Intent(this, MainActivity::class.java)
            startActivity(go)
        }
    }
}