package com.example.ultimatetrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val presidentData = Constants.getPresidentSubTopics()

        btPresidents.setOnClickListener {
            val intent = Intent(this, SubTopics::class.java)
            intent.putExtra("1","Presidents")
            startActivity(intent)
        }

        btUSStates.setOnClickListener {
            val intent = Intent(this, SubTopics::class.java)
            intent.putExtra("1","US States")
            startActivity(intent)
        }

        btPeriodicTable.setOnClickListener {
            val intent = Intent(this, SubTopics::class.java)
            intent.putExtra("1","Periodic Table")
            startActivity(intent)
        }

        btCapitalCities.setOnClickListener {
            val intent = Intent(this, SubTopics::class.java)
            intent.putExtra("1","Capital Cities")
            startActivity(intent)
        }




    }
}