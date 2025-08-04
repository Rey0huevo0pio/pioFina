package com.example.pio_final_trabajo

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContactosActivity : AppCompatActivity() {

    private lateinit var listaContactos: List<Contacto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_contactos)

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val listView = findViewById<ListView>(R.id.listViewContactos)

        val prefs = getSharedPreferences("usuario_pref", Context.MODE_PRIVATE)
        val nombreUsuario = prefs.getString("nombre_usuario", "Usuario")
        tvSaludo.text = "Hola, $nombreUsuario"

        listaContactos = listOf(
            Contacto("Neftali mi amor", "El amor de mi vida de todo lo amo al joto este", R.drawable.dictador),
            Contacto("May", "Omosexual de la vida", R.drawable.youjo),
            Contacto("mariana ", "xoxoxo", R.drawable.elfa)
        )

        val adaptador = ContactoAdapter(this, listaContactos)
        listView.adapter = adaptador

        listView.setOnItemClickListener { _, _, position, _ ->
            val contacto = listaContactos[position]
            Toast.makeText(this, "Llamando a: ${contacto.nombre}", Toast.LENGTH_SHORT).show()
        }
    }
}