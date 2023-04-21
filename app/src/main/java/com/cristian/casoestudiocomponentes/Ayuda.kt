package com.cristian.casoestudiocomponentes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Ayuda : AppCompatActivity() {
    var btnSalida: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        btnSalida = findViewById(R.id.btnSalida)

        btnSalida?.setOnClickListener {
            finish()
        }
    }
}