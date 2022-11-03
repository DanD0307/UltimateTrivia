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

        btPresidents.setOnClickListener {
            val intent = Intent(this, Topics::class.java)
            intent.putExtra("QuizPath","Presidents")
            startActivity(intent)
        }

        btUSStates.setOnClickListener {
            val intent = Intent(this, Topics::class.java)
            intent.putExtra("QuizPath","US States")
            startActivity(intent)
        }

        btPeriodicTable.setOnClickListener {
            val intent = Intent(this, Topics::class.java)
            intent.putExtra("QuizPath","Periodic Table")
            startActivity(intent)
        }

        btCapitalCities.setOnClickListener {
            val intent = Intent(this, Topics::class.java)
            intent.putExtra("QuizPath","Capital Cities")
            startActivity(intent)
        }

        btGeneralKnowledge.setOnClickListener {
            val intent = Intent(this, Topics::class.java)
            intent.putExtra("QuizPath","General Knowledge")
            startActivity(intent)
        }
        btHistory.setOnClickListener {
            val intent = Intent(this, Topics::class.java)
            intent.putExtra("QuizPath","History")
            startActivity(intent)
        }




    }
}