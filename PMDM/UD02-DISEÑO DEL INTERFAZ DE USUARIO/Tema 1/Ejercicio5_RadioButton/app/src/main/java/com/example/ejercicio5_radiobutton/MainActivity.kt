package com.example.ejercicio5_radiobutton

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val choix=findViewById<TextView>(R.id.tvChoix)
        val radiogp = findViewById<RadioGroup>(R.id.radioGroup)
        val checkbox=findViewById<CheckBox>(R.id.checkBox)

        radiogp.setOnCheckedChangeListener { _, checkedId ->
            //Devuelve -1 si no hay ninguno seleccionado.
            if (checkedId !=-1){
                val juego=findViewById<RadioButton>(checkedId).text.toString()
                choix.text = "Veo que te gusta el $juego."
            }
        }

        checkbox.setOnCheckedChangeListener { _, bool ->

            if(bool){
                choix.text= "¡Sí que te mola!"
            }else{
                choix.text="¡¿No te molan!?"
            }
        }
    }
}