package com.example.hw1_lyco

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun Random.nextInt(range: IntRange): Int {
        return range.start + nextInt(range.last - range.start)
    }
    val n = Random().nextInt(1..1001)
    var cuenta = 0
    fun validar_num(este : View){
        val numero = findViewById(R.id.Valor_dig) as EditText
        fun EditText.textValue() = text.toString()
        val dato = numero.text.toString().toInt()
        val v=n.toString()
        Toast.makeText(this, v, Toast.LENGTH_SHORT).show()
        val el_Boton = findViewById(R.id.button) as Button

        /*intente que no habilitara el boton hasta que no ingresara el numero , pero me genra error y se cierra la aplicacion
        if (numero.length() > 0) {
            Toast.makeText(this, v, Toast.LENGTH_SHORT).show()
            el_Boton.isEnabled
        }*/
        if (dato > 1000){
            println (dato)
            Toast.makeText(this, "VALOR no PERMITIDO", Toast.LENGTH_SHORT).show()
            numero.setText("")
        }
        else if(dato < n ){
            val ayuda = findViewById(R.id.textView_ayuda) as TextView
            Toast.makeText(this, "El valor ingresado es menor, intenta de nuevo", Toast.LENGTH_SHORT).show()
            cuenta = cuenta + 1
            ayuda.setText("número de intentos "+cuenta)
            numero.setText("")
        }
        else if(dato > n ){
            val ayuda = findViewById(R.id.textView_ayuda) as TextView
            Toast.makeText(this, "El valor ingresado es Mayor, intenta de nuevo", Toast.LENGTH_SHORT).show()
            cuenta = cuenta + 1
            ayuda.setText("número de intentos "+cuenta)
            numero.setText("")
        }
        else {
            val ayuda = findViewById(R.id.textView_ayuda) as TextView
            Toast.makeText(this, "Eureka, lo adivinaste", Toast.LENGTH_SHORT).show()
            ayuda.setText("Total de intentos "+cuenta)
            numero.setText("")


        }
    }
}
