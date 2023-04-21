package com.cristian.casoestudiocomponentes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComprar: Button = findViewById(R.id.btnComprar)
        val btnDatos: Button = findViewById(R.id.btnDatos)
        val btnAyuda: Button = findViewById(R.id.btnAyuda)

        btnComprar.setOnClickListener {
                var intent = Intent(this, Registro::class.java)
                startActivity(intent)
        }

        btnDatos.setOnClickListener {
                var intent = Intent(this, Datos::class.java)
                startActivity(intent)
        }

        btnAyuda.setOnClickListener {
                var intent = Intent(this, Ayuda::class.java)
                startActivity(intent)
        }


    }
}