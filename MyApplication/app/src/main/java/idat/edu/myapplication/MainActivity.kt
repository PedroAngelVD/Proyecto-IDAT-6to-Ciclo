package idat.edu.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = btnCalcular as Button

        var btn2 = btnActivity as Button

        btn.setOnClickListener {
            var numero1 : Int?
            var numero2 : Int?
            numero1 = etNumero1.text.toString().toInt()
            numero2 = etNumero2.text.toString().toInt()
            var resultado = Suma(numero1, numero2)
            tvResultado.text = resultado.toString()
        }

        btn2.setOnClickListener {
            val intent = Intent ( this , Main2Activity :: class . java )
            startActivity (intent)
        }
    }

    private fun ValoresConstantes(){
        val nombre = "Pedro Vega"
        //Son valores que no se pueden modificar luego de su creación
    }

    private fun ValoresVariables(){
        var nombre : String
        nombre = "Pedro Angel"
        //Son valores que si pueden modificarse luego de su creación

        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }

    private fun ValoresNulos(){
        var nombrenulo : String ?
        nombrenulo = null
        //Son valores que pueden ser nulas
    }

    fun Suma(a: Int, b:Int) : Int{
        return a+b
    }

}
