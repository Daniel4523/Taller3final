package com.example.taller2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class perfilActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var txtNombre: TextView
    private lateinit var txtApellido: TextView
    private lateinit var txtTelefono: TextView
    private lateinit var txtEmail: TextView
    private lateinit var editNombre: EditText
    private lateinit var editApellido: EditText
    private lateinit var editTelefono: EditText
    private lateinit var btnEditar: Button
    private lateinit var btnGuardar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        Log.d("CicloVida", "onCreate ejecutado")

        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        txtNombre = findViewById(R.id.txtNombre)
        txtApellido = findViewById(R.id.txtApellido)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtEmail = findViewById(R.id.txtEmail) // Nuevo campo

        editNombre = findViewById(R.id.editNombre)
        editApellido = findViewById(R.id.editApellido)
        editTelefono = findViewById(R.id.editTelefono)

        btnEditar = findViewById(R.id.btnEditar)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnCancelar = findViewById(R.id.btnCancelar)

        // Cargar datos guardados
        cargarDatos()

        btnEditar.setOnClickListener {
            activarModoEdicion(true)
        }

        btnGuardar.setOnClickListener {
            guardarCambios()
        }

        btnCancelar.setOnClickListener {
            activarModoEdicion(false)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloVida", "onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloVida", "onResume ejecutado")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloVida", "onPause ejecutado")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloVida", "onStop ejecutado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("CicloVida", "onRestart ejecutado")
    }

    private fun cargarDatos() {
        val nombre = sharedPreferences.getString("nombre", "") ?: ""
        val apellido = sharedPreferences.getString("apellido", "") ?: ""
        val telefono = sharedPreferences.getString("telefono", "") ?: ""
        val email = sharedPreferences.getString("email", "No registrado") ?: "No registrado"

        txtNombre.text = nombre
        txtApellido.text = apellido
        txtTelefono.text = telefono
        txtEmail.text = email // Mostrar email

        editNombre.setText(nombre)
        editApellido.setText(apellido)
        editTelefono.setText(telefono)

        activarModoEdicion(false)
    }

    private fun activarModoEdicion(editar: Boolean) {
        txtNombre.visibility = if (editar) View.GONE else View.VISIBLE
        txtApellido.visibility = if (editar) View.GONE else View.VISIBLE
        txtTelefono.visibility = if (editar) View.GONE else View.VISIBLE
        txtEmail.visibility = View.VISIBLE // Siempre visible

        editNombre.visibility = if (editar) View.VISIBLE else View.GONE
        editApellido.visibility = if (editar) View.VISIBLE else View.GONE
        editTelefono.visibility = if (editar) View.VISIBLE else View.GONE

        btnEditar.visibility = if (editar) View.GONE else View.VISIBLE
        btnGuardar.visibility = if (editar) View.VISIBLE else View.GONE
        btnCancelar.visibility = if (editar) View.VISIBLE else View.GONE
    }

    private fun guardarCambios() {
        val nuevoNombre = editNombre.text.toString().trim()
        val nuevoApellido = editApellido.text.toString().trim()
        val nuevoTelefono = editTelefono.text.toString().trim()

        if (nuevoNombre.isEmpty() || nuevoApellido.isEmpty() || nuevoTelefono.isEmpty()) {
            Toast.makeText(this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPreferences.edit().apply {
            putString("nombre", nuevoNombre)
            putString("apellido", nuevoApellido)
            putString("telefono", nuevoTelefono)
            apply()
        }

        cargarDatos()
        Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show()
    }
}
