package com.grijalvaromero.carritoapp.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grijalvaromero.carritoapp.R
import com.grijalvaromero.carritoapp.VerProducto
import com.grijalvaromero.carritoapp.modelos.ItemCarito
import com.grijalvaromero.carritoapp.modelos.Producto

class CarritoAdapter (val productos:ArrayList<ItemCarito>) : RecyclerView.Adapter<CarritoAdapter.ViewHolder>(){
    var position:Int=-1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoAdapter.ViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_carrito,parent,false )
        return  ViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return  productos.size
    }

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {

        }
        fun bindItems(producto : ItemCarito){
            val itemNombre = itemView.findViewById<TextView>(R.id.itemNombreCarrito)
            itemNombre.text =producto.nombre
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.position=position
        holder.bindItems(productos[position])
    }

}