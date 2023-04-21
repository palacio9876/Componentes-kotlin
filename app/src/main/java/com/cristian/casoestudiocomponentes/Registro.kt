package com.cristian.casoestudiocomponentes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Registro : AppCompatActivity() {

    var nombreUsuario: EditText? = null
    var apellidoUsuario: EditText? = null
    var edadUsuario: EditText? = null
    var telefonoUsuario: EditText? = null
    var tipoA: RadioButton? = null
    var tipoB: RadioButton? = null
    var tipoC: RadioButton? = null
    var tipoNinguno: RadioButton? = null
    var btnlimpiarRegistro: Button? = null
    var btnSiguiente: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombreUsuario = findViewById(R.id.nombreUsuario)
        apellidoUsuario = findViewById(R.id.apellidoUsuario)
        edadUsuario = findViewById(R.id.edadUsuario)
        telefonoUsuario = findViewById(R.id.telefonoUsuario)
        tipoA = findViewById(R.id.tipoA)
        tipoB = findViewById(R.id.tipoB)
        tipoC = findViewById(R.id.tipoC)
        tipoNinguno = findViewById(R.id.tipoNinguno)
        btnlimpiarRegistro = findViewById(R.id.btnlimpiarRegistro)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        btnSiguiente?.setOnClickListener {
            getDatos()
        }

        btnlimpiarRegistro?.setOnClickListener {
            nombreUsuario?.setText("")
            apellidoUsuario?.setText("")
            edadUsuario?.setText("")
            telefonoUsuario?.setText("")
            tipoA?.isChecked = false
            tipoB?.isChecked = false
            tipoC?.isChecked = false
            tipoNinguno?.isChecked = false
        }
    }

    private fun getDatos(){
        val nombre = nombreUsuario?.text.toString()
        val apellido = apellidoUsuario?.text.toString()
        val edad = edadUsuario?.text.toString()
        val telefono = telefonoUsuario?.text.toString()
        val tipo = when {
            tipoA?.isChecked == true -> "Usuario tipo A"
            tipoB?.isChecked == true -> "Usuario tipo B"
            tipoC?.isChecked == true -> "Usuario tipo C"
            tipoNinguno?.isChecked == true -> "No pertenece a ningun tipo"
            else -> "No selecciono ningun tipo"
        }
        if (nombre.isEmpty() || apellido.isEmpty() || edad.isEmpty() || telefono.isEmpty() || tipo.isEmpty()){
            Toast.makeText(this, "Llene todos los campos para continuar", Toast.LENGTH_LONG).show()
        }else{

            var preferences: SharedPreferences =getSharedPreferences("credencialesUsuario", Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor = preferences.edit()
            editor.putString("nombreUser", nombre)
            editor.putString("apellidoUser", apellido)
            editor.putString("edadUser", edad)
            editor.putString("telefonoUser", telefono)
            editor.putString("usuarioUser", tipo)
            editor.commit()


            var intent = Intent(this, Compra::class.java)
            intent.putExtra("Nombre", nombre)

            startActivity(intent)
            finish()

        }




    }

}