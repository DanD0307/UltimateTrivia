package com.example.ultimatetrivia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ultimatetrivia.Constants.getCapitalCitiesImages
import com.example.ultimatetrivia.Constants.getCapitalCitiesSubTopics
import com.example.ultimatetrivia.Constants.getPeriodicTableHighScores
import com.example.ultimatetrivia.Constants.getPeriodicTableImages
import com.example.ultimatetrivia.Constants.getPeriodicTableProgressScores
import com.example.ultimatetrivia.Constants.getPeriodicTableSubTopics
import com.example.ultimatetrivia.Constants.getPresidentHighScores
import com.example.ultimatetrivia.Constants.getPresidentImages
import com.example.ultimatetrivia.Constants.getPresidentProgressScores
import com.example.ultimatetrivia.Constants.getPresidentSubTopics
import com.example.ultimatetrivia.Constants.getUSStatesHighScores
import com.example.ultimatetrivia.Constants.getUSStatesImages
import com.example.ultimatetrivia.Constants.getUSStatesProgressScores
import com.example.ultimatetrivia.Constants.getUSStatesSubTopics
import com.example.ultimatetrivia.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_sub_topics.*

class SubTopics : AppCompatActivity(), ItemAdapter.OnItemCLickListener{

    lateinit var list:ArrayList<String>
    lateinit var images:ArrayList<Int>
    lateinit var highScores:ArrayList<String>
    lateinit var progressScores:ArrayList<String>


    //TODO Make function so it can be called from both onCreate and onRestart()/onResume()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_topics)
        makeRecyclerView()

    }

    override fun onResume() {
        super.onResume()
        makeRecyclerView()
    }

    fun makeRecyclerView(){
        var a = intent.getStringExtra("1")
        if(a == "Presidents"){
            list = getPresidentSubTopics()
            images = getPresidentImages()
            highScores = getPresidentHighScores(this)
            progressScores = getPresidentProgressScores(this)
            //Constants.returnPresidents(this)
        }
        else if(a == "Capital Cities"){
            list = getCapitalCitiesSubTopics()
            images = getCapitalCitiesImages()
            highScores = getPresidentHighScores(this)
        }
        else if(a == "Periodic Table"){
            list = getPeriodicTableSubTopics()
            images = getPeriodicTableImages()
            highScores = getPeriodicTableHighScores(this)
            progressScores = getPeriodicTableProgressScores(this)
        }
        else if(a == "US States"){
            list = getUSStatesSubTopics()
            images = getUSStatesImages()
            highScores = getUSStatesHighScores(this)
            progressScores = getUSStatesProgressScores(this)
        }
        else{
            list = getPresidentSubTopics()
            images = getPresidentImages()
            highScores = getPresidentHighScores(this)

        }


        //Set the LayoutManager that this recycler view will use
        recycler_view_items.layoutManager = LinearLayoutManager(this)
        //Adapter Class
        val itemAdapter = ItemAdapter(this, list as ArrayList<String>,images,highScores,progressScores,this)

        //Adapter instance is set to the recyclerview to inflate the items
        recycler_view_items.adapter = itemAdapter
    }

    override fun onItemClick(position: Int) {

        //When a button is clicked we move to the question screen
        val subTopicName = this.intent.getStringExtra("1")
        if(list.get(position) == "EXIT"){
            finish();
            return
        }

        if(subTopicName == "Presidents") {
            val intent = Intent(this, GenericQuiz::class.java)
            val arr = arrayOf(subTopicName, position.toString())
            intent.putExtra("1", arr)
            startActivity(intent)
        }

        if(subTopicName == "US States" || subTopicName == "Periodic Table") {
            val intent = Intent(this, GenericQuiz::class.java)
            val arr = arrayOf(subTopicName, position.toString())
            intent.putExtra("1", arr)
            startActivity(intent)
        }
    }

}