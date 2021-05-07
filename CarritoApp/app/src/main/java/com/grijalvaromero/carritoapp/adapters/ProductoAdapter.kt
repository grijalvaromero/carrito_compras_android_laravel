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
import com.grijalvaromero.carritoapp.modelos.Producto

class ProductoAdapter (val productos:ArrayList<Producto>) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>(){
    var position:Int=-1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoAdapter.ViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false )
        return  ViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return  productos.size
    }

    override fun onBindViewHolder(holder: ProductoAdapter.ViewHolder, position: Int) {
        this.position=position
        holder.bindItems(productos[position])
    }
    class  ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                Log.e("POSICION", this.adapterPosition.toString())
                var contexto = itemView.context
                contexto.startActivity( Intent(contexto, VerProducto::class.java) )
            }
        }
        fun bindItems(producto :Producto){
            val itemNombre = itemView.findViewById<TextView>(R.id.item_nombre)
            itemNombre.text =producto.nombre
        }
    }

}