package com.grijalvaromero.carritoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar


class VerProducto : AppCompatActivity() {
    lateinit var btnMas:Button
    lateinit var btnMenos:Button
    lateinit var txtCantidad:TextView
    lateinit var btnAgregar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_producto)
        var toolbar =findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        btnMas = findViewById(R.id.btnMas)
        btnMenos = findViewById(R.id.btnMenos)
        btnAgregar = findViewById(R.id.btnAgregar)
        txtCantidad = findViewById(R.id.txtCantidad)
        txtCantidad.text="1"
        btnMas.setOnClickListener{
            txtCantidad.text = (txtCantidad.text.toString().toInt()+1).toString()

        }
        btnMenos.setOnClickListener{
            if (txtCantidad.text.toString().toInt() > 1){
                txtCantidad.text = (txtCantidad.text.toString().toInt()-1).toString()
            }
        }
        btnAgregar.setOnClickListener{
            startActivity(Intent(this, Carrito::class.java))
        }

    }
}