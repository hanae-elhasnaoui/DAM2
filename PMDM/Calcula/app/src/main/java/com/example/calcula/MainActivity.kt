package com.example.calcula

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var operacionActual=""
    var firstNumber:Double =0.00
    var segunNumber:Double= 0.00
    lateinit var inputTv: TextView
    lateinit var resultTv: TextView

    val mult="X"
    val div="÷"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputTv = findViewById(R.id.solution_tv)
        resultTv = findViewById(R.id.result_tv)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }

    fun onClick(butt: View) {

        val b = butt as Button

        if (b.text.toString() == "=") {
            igual(b)

        } else if (
            b.text.toString() == "+" ||
            b.text.toString() == "-" ||
            b.text.toString() == "X" ||
            b.text.toString() == "÷" ||
            b.text.toString() == "%"
        ) {
            operatorSelected(b)

        }else if (b.text.toString() == "C") {
            delete()
        }else if (b.text.toString() == "AC") {
            allclear()
        }else {
            numberSelected(b)
        }

    }

    @SuppressLint("SetTextI18n")
    fun numberSelected(butt: View){
        val b =butt as Button
        if(inputTv.text.toString()=="0"){
            inputTv.text=b.text.toString()
        }else {
            inputTv.text=inputTv.text.toString()+b.text.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun operatorSelected(butt: View){
        val b=butt as Button
        firstNumber = inputTv.text.toString().toDouble()

        operacionActual = if (b.text.toString()==mult){
            "*"
        }else if (b.text.toString()==div) {
            "/"
        }else {
            b.text.toString().trim()
        }
        inputTv.text = firstNumber.toString() + b.text.toString()

    }

    fun saveSecondNumber() {

        val texto = inputTv.text.toString()
        val operador : String = when (operacionActual) {
            "*" -> "X"
            "/" -> "÷"
            else -> operacionActual
        }

        val numero2 = texto.substringAfter(operador)

        segunNumber = numero2.toDouble()
    }
    fun igual(butt: View){

        val b=butt as Button

        if(b.text.toString()=="="){

            if (inputTv.text.toString().isNotEmpty() &&
                operacionActual.isNotEmpty()) {

                saveSecondNumber()
                calculate()

            }
        }

        operacionActual=""
        inputTv.text = resultTv.text.toString()

    }

    @SuppressLint("SetTextI18n")
    fun calculate(){

        when(operacionActual){
            "+" ->  resultTv.text = (firstNumber + segunNumber).toString()
            "-" ->  resultTv.text = (firstNumber - segunNumber).toString()
            "*" ->  resultTv.text = (firstNumber * segunNumber).toString()
            "/" ->   if (segunNumber == 0.0) {
                        resultTv.text = "Error"
                        } else {
                            resultTv.text = (firstNumber / segunNumber).toString()
                        }
            "%" ->  resultTv.text = (firstNumber % segunNumber).toString()

        }
    }

    fun allclear() {
        inputTv.text = "0"
        resultTv.text = "0"
        firstNumber = Double.NaN
        segunNumber = Double.NaN
        operacionActual = ""
    }
    fun delete() {
        val text = inputTv.text.toString()

        if (text.length > 1) {
            inputTv.text = text.dropLast(1)
        } else {
            inputTv.text = "0"
        }
    }

}