package com.example.intensivo8_ocean_android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*btAlterar.setOnClickListener {
            val nomeDigitado = etNome.text.toString()

            tvNome.text = nomeDigitado
        }*/

//        btAlterar.setOnClickListener {
//            Toast.makeText(this, "Informação", Toast.LENGTH_LONG).show()

//            alert("Mensagem", "Título") {
//                yesButton {
//                    longToast("Yes Button")
//                }
//                noButton {
//                    longToast("No Button")
//                }
//            }.show()
//        }

        btAlterar.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}