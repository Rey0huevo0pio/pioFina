package com.example.pio_final_trabajo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ContactoAdapter(private val context: Context, private val contactos: List<Contacto>) : BaseAdapter() {
    override fun getCount() = contactos.size
    override fun getItem(position: Int) = contactos[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_contacto, parent, false)
        val contacto = contactos[position]

        val img = itemView.findViewById<ImageView>(R.id.ivImagen)
        val nombre = itemView.findViewById<TextView>(R.id.tvNombre)
        val desc = itemView.findViewById<TextView>(R.id.tvDescripcion)

        img.setImageResource(contacto.imagen)
        nombre.text = contacto.nombre
        desc.text = contacto.descripcion

        return itemView
    }
}