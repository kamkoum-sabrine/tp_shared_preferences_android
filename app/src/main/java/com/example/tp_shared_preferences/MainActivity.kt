package com.example.tp_shared_preferences

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {
    lateinit var btnCount: Button
    lateinit var black : Button
    lateinit var red : Button
    lateinit var blue : Button
    lateinit var green : Button
    lateinit var count : TextView
    lateinit var btnSave : Button
    lateinit var btnRetrieve : Button
    lateinit var color : String
    lateinit var zero : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount = findViewById(R.id.btnCount)
        black = findViewById(R.id.black)
        red = findViewById(R.id.red)
        blue = findViewById(R.id.blue)
        green = findViewById(R.id.green)
        count = findViewById(R.id.count)
        count.setBackgroundColor(Color.GRAY)
        btnSave = findViewById(R.id.save)
        btnRetrieve = findViewById(R.id.retrieve)
        color=""
        zero = findViewById(R.id.zero)
        val sharedPreference:SharedPreference=SharedPreference(this)
        black.setOnClickListener {
            count.setBackgroundColor(Color.BLACK)
            color = "BLACK"
        }
        green.setOnClickListener {
            count.setBackgroundColor(Color.GREEN)
            color = "GREEN"
        }
        red.setOnClickListener {
            count.setBackgroundColor(Color.RED)
            color = "RED"
        }
        blue.setOnClickListener {
            count.setBackgroundColor(Color.BLUE)
            color = "BLUE"
        }
        zero.setOnClickListener {
            count.setText("0")
            count.setBackgroundColor(Color.GRAY)
            sharedPreference.clearSharedPreference()
        }
        btnCount.setOnClickListener {
            var cpt = count.text.toString().toInt()
            println(cpt)
            cpt +=1
            count.setText(cpt.toString())
            println( black.background)

        }

        btnSave.setOnClickListener {
            val count=count.text.toString()
              //  println(count)
            sharedPreference.save("count",count)
            sharedPreference.save("color",color)

            //  sharedPreference.save("email",email)
            Toast.makeText(this@MainActivity,"Data saved to shared preferences", Toast.LENGTH_SHORT).show()
        }

        btnRetrieve.setOnClickListener {
            if (sharedPreference.getValueString("count")!=null) {
                count.text = sharedPreference.getValueString("count")!!.toString()
                if(sharedPreference.getValueString("color")=="BLACK"){
                    count.setBackgroundColor(Color.BLACK)
                }
                if(sharedPreference.getValueString("color")=="RED"){
                    count.setBackgroundColor(Color.RED)
                }
                if(sharedPreference.getValueString("color")=="GREEN"){
                    count.setBackgroundColor(Color.GREEN)
                }
                if(sharedPreference.getValueString("color")=="BLUE"){
                    count.setBackgroundColor(Color.BLUE)
                }
                Toast.makeText(this@MainActivity,"Data Retrieved from shared preferences",Toast.LENGTH_SHORT).show()
            }

        }


    }
}