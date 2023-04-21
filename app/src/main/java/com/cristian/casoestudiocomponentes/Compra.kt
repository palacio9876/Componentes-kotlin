package com.cristian.casoestudiocomponentes

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Compra : AppCompatActivity() {

    var usuario: TextView? = null
    var nombreProducto: EditText? = null
    var valorProducto: EditText? = null
    var cantidadProducto: EditText? = null
    var btnlimpiarCompra: Button? = null
    var btnComprarr: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        var nombreUsuario = intent.getStringExtra("Nombre Usuario")

        usuario = findViewById(R.id.usuario)
        nombreProducto = findViewById(R.id.nombreProducto)
        valorProducto = findViewById(R.id.valorProducto)
        cantidadProducto = findViewById(R.id.cantidadProducto)
        btnlimpiarCompra = findViewById(R.id.btnlimpiarCompra)
        btnComprarr = findViewById(R.id.btnComprar)

        usuario?.text = nombreUsuario

        btnlimpiarCompra?.setOnClickListener {
            nombreProducto?.setText("")
            valorProducto?.setText("")
            cantidadProducto?.setText("")
        }

        btnComprarr?.setOnClickListener {
            getDatosCompra()
        }

    }

    private fun getDatosCompra() {
        var nombreProducto = nombreProducto?.text.toString()
        var valorProducto = valorProducto?.text.toString()
        var cantidadProducto = cantidadProducto?.text.toString()

        if (nombreProducto.isEmpty() || valorProducto.isEmpty() || cantidadProducto.isEmpty()) {
            Toast.makeText(this, "Completa los campos para continuar", Toast.LENGTH_LONG).show()
        }

        var miIntent = Intent(this, Factura::class.java)

        var preferences: SharedPreferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("nombreProducto", nombreProducto)
        editor.putString("valorProducto", valorProducto)
        editor.putString("cantidadProducto", cantidadProducto)

        editor.commit()

        startActivity(miIntent)
        finish()
    }

}