package com.cristian.casoestudiocomponentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Datos : AppCompatActivity() {
    var textViewNombre: TextView? = null
    var textViewApellido: TextView? = null
    var textViewEdad: TextView? = null
    var textViewTelefono: TextView? = null
    var textViewTipo: TextView? = null
    var btnBorrarDatos: Button? = null
    var btnVolver: Button? = null

    var nombre: String? = null
    var apellido: String? = null
    var edad: String? = null
    var telefono: String? = null
    var tipo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        var preferences = getSharedPreferences("credencialesUsuario", MODE_PRIVATE)
        var preferencesInfo = preferences.contains("nombreUser")

        textViewNombre = findViewById(R.id.textViewNombre)
        textViewApellido = findViewById(R.id.textViewApellido)
        textViewEdad = findViewById(R.id.textViewEdad)
        textViewTelefono = findViewById(R.id.textViewTelefono)
        textViewTipo = findViewById(R.id.textViewTipo)
        btnVolver = findViewById(R.id.btnVolver)
        btnBorrarDatos = findViewById(R.id.btnBorrarDatos)

        var nombrePreference = preferences.getString("nombreUser", "Espacio vacio")
        var apellidoPreference = preferences.getString("apellidoUser", "Espacio vacio")
        var edadPreference = preferences.getString("edadUser", "Espacio vacio")
        var telefonoPreference = preferences.getString("telefonoUser", "Espacio vacio")
        var tipoPreference = preferences.getString("usuarioUser", "Espacio vacio")

        textViewNombre?.text = nombrePreference
        textViewApellido?.text = apellidoPreference
        textViewEdad?.text = edadPreference
        textViewTelefono?.text = telefonoPreference
        textViewTipo?.text = tipoPreference

        if (preferencesInfo) {
            btnBorrarDatos?.setOnClickListener {
                var editor = preferences.edit()
                editor.clear()
                editor.apply()
                Toast.makeText(this, "Datos borrados", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_LONG).show()
        }

        btnVolver?.setOnClickListener {
            finish()
        }
    }
}