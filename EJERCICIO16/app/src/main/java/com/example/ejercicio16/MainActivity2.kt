package com.example.ejercicio16

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio16.R.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val buttonOk : Button=findViewById<Button>(R.id.seguinte);

        buttonOk.setOnClickListener {
            val intentResultado = Intent() ;
            val isSel=findViewById<RadioGroup>(R.id.radioID).checkedRadioButtonId
            val provinciaSelec= findViewById<RadioButton>(isSel).text.toString();

            intentResultado.putExtra("provincia key" , provinciaSelec);
            setResult(RESULT_OK,intentResultado)
            finish()
        }

    }

}