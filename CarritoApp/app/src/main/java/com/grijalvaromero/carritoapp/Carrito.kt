package com.grijalvaromero.carritoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grijalvaromero.carritoapp.adapters.CarritoAdapter
import com.grijalvaromero.carritoapp.adapters.ProductoAdapter
import com.grijalvaromero.carritoapp.modelos.ItemCarito
import com.grijalvaromero.carritoapp.modelos.Producto

class Carrito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)
        var recyclerView =findViewById<RecyclerView>(R.id.listaCarrito)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var productos=ArrayList<ItemCarito>()
        productos.add(ItemCarito("Olla 1","20.00","defalut.jpg","Descripcion","1"))
        productos.add(ItemCarito("Olla 2","20.00","defalut.jpg","Descripcion","1"))
        productos.add(ItemCarito("Olla 3","20.00","defalut.jpg","Descripcion","1"))
        val adapter = CarritoAdapter(productos)
        recyclerView.adapter = adapter
    }
}