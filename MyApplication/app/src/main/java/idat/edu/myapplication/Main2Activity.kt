package idat.edu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var btn = btnCalcularIMC as Button

        btn.setOnClickListener {
            var talla : Double
            var peso : Double
            talla = etTalla.text.toString().toDouble()
            peso = etPeso.text.toString().toDouble()
            var resultadoIMC = CalcularIMC( peso, talla)
            tvResultadoIMC.text = "Su IMC es : "+resultadoIMC.toString()
        }
    }

    fun CalcularIMC(peso : Double, talla : Double) : Double{
        var tallam : Double
        tallam = talla/100

        return peso/(tallam*tallam)
    }
}
