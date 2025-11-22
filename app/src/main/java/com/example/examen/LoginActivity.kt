package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen.databinding.ActivityLoginBinding
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializar ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajuste de bordes para EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configurarBotones()
    }

    private fun configurarBotones(){
        binding.btnIniciarSesionLogin.setOnClickListener {

            //Obtener el texto de los campos
            val usuario = binding.campoUsuario.text.toString()
            val contrasena = binding.campoContra.text.toString()

            // Validar si esta vacios
            if(usuario.isEmpty() || contrasena.isEmpty()){
                // Mostrar Toast Error
                Toast.makeText(
                    this,
                    "Debes rellenar todos los campos!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Cierra LoginActivity para que no vuelva con el botón atrás
            }
        }

        binding.btnRegistrarseLogin.setOnClickListener {
            Toast.makeText(
                this,
                "Funcion sin implementar",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

