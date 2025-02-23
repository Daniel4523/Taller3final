package com.example.taller2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val boton2 = findViewById<Button>(R.id.boton2)
        val boton1 = findViewById<Button>(R.id.botoncomenzar)
        boton2.setOnClickListener {
            val intent = Intent(this, SesionActivity::class.java)
            startActivity(intent)
        }
        boton1.setOnClickListener {
            val intent = Intent(this, SesionActivity::class.java)
            startActivity(intent)
        }
    }
}