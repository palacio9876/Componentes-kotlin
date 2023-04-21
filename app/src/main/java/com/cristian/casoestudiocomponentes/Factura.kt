package com.cristian.casoestudiocomponentes

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Factura : AppCompatActivity() {
    var textNombre: TextView? = null
    var textTipo: TextView? = null
    var textNombreProducto: TextView? = null
    var textDescuento: TextView? = null
    var textTotal: TextView? = null
    var btnPrincipal: Button? = null

    var nombreUsuario: String? = null
    var apellidoUsuario: String? = null
    var edadUsuario: String? = null
    var telefonoUsuario: String? = null
    var tipoUsuario: String? = null

    var nombreProducto: String? = null
    var valorProducto: String? = null
    var cantidadProducto: String? = null

    var totalPagar: Float? = null
    var descuento: Float? = null
    var mensaje: String? = null
    var cantidadDescuento: Float? = null
    var precioReal: Float? = null
    var toco: Double? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        var preferencesUsuario: SharedPreferences = getSharedPreferences("credencialesUsuario", MODE_PRIVATE)
        var preferencesProducto: SharedPreferences = getSharedPreferences("credenciales", MODE_PRIVATE)

        textNombre = findViewById(R.id.textNombre)
        textTipo = findViewById(R.id.textTipo)
        textNombreProducto = findViewById(R.id.textNombreProducto)
        textDescuento = findViewById(R.id.textDescuento)
        textTotal = findViewById(R.id.textTotal)
        btnPrincipal = findViewById(R.id.btnPrincipal)

        var nombrePreference = preferencesUsuario.getString("nombreUser", "Espacio vacio")
        var apellidoPreference = preferencesUsuario.getString("apellidoUser", "Espacio vacio")
        var edadPreference = preferencesUsuario.getString("edadUser", "Espacio vacio")
        var telefonoPreference = preferencesUsuario.getString("telefonoUser", "Espacio vacio")
        var tipoPreference = preferencesUsuario.getString("usuarioUser", "Espacio vacio")
        var nombreProductoPreference = preferencesProducto.getString("nombreProducto", "Espacio vacio")
        var valorUnitarioPreference = preferencesProducto.getString("valorProducto", "Espacio vacio")
        var cantidadProductoPreference = preferencesProducto.getString("cantidadProducto", "Espacio vacio")

        nombreUsuario = nombrePreference
        apellidoUsuario = apellidoPreference
        edadUsuario = edadPreference
        telefonoUsuario = telefonoPreference
        tipoUsuario = tipoPreference
        nombreProducto = nombreProductoPreference
        valorProducto = valorUnitarioPreference
        cantidadProducto = cantidadProductoPreference

        if (tipoUsuario == "Usuario tipo A") {
            descuento = 0.40f
            mensaje = "40% de descuento"
        } else if (tipoUsuario == "Usuario tipo B") {
            descuento = 0.20f
            mensaje = "20% de descuento"
        } else if (tipoUsuario == "Usuario tipo C"){
            descuento = 0.10f
            mensaje = "10% de descuento"
        } else {
            descuento = 0.0f
            mensaje = "No tiene descuento"
        }

        cantidadDescuento = (valorProducto?.toFloat()!! * descuento?.toFloat()!!)
        totalPagar = cantidadDescuento?.toFloat()!! * cantidadProducto?.toFloat()!!


        textNombre?.text = "$nombreUsuario $apellidoUsuario"
        textTipo?.text = "$tipoUsuario"
        textNombreProducto?.text = "$nombreProducto"
        textDescuento?.text = "$mensaje"
        textTotal?.text = "$totalPagar"

        btnPrincipal?.setOnClickListener {
            Toast.makeText(this, tipoUsuario, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}