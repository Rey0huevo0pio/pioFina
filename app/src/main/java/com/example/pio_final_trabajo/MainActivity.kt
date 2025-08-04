package com.example.pio_final_trabajo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombreUsuario = findViewById<EditText>(R.id.etNombreUsuario)
        val btnGuardarNombre = findViewById<Button>(R.id.btnGuardarNombre)

        btnGuardarNombre.setOnClickListener {
            val nombre = etNombreUsuario.text.toString().trim()

            if (nombre.isNotEmpty()) {
                // Guardar nombre en SharedPreferences
                val prefs = getSharedPreferences("usuario_pref", Context.MODE_PRIVATE)
                prefs.edit().putString("nombre_usuario", nombre).apply()

                // Abrir la pantalla de contactos
                val intent = Intent(this, ContactosActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
