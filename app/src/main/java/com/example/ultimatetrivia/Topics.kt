package com.example.ultimatetrivia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ultimatetrivia.Constants.getCapitalCitiesImages
import com.example.ultimatetrivia.Constants.getCapitalCitiesSubTopics
import com.example.ultimatetrivia.Constants.getGKHighScores
import com.example.ultimatetrivia.Constants.getGKProgressScores
import com.example.ultimatetrivia.Constants.getGKSubTopics
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
import com.example.ultimatetrivia.SubConstants.getAfricanCapitalCitiesHighScores
import com.example.ultimatetrivia.SubConstants.getAfricanCapitalCitiesProgressCount
import com.example.ultimatetrivia.SubConstants.getAfricanCapitalCitiesSubTopics
import com.example.ultimatetrivia.SubConstants.getAsianCapitalCitiesHighScores
import com.example.ultimatetrivia.SubConstants.getAsianCapitalCitiesProgressCount
import com.example.ultimatetrivia.SubConstants.getAsianCapitalCitiesSubTopics
import com.example.ultimatetrivia.SubConstants.getEuropeanCapitalCitiesHighScores
import com.example.ultimatetrivia.SubConstants.getEuropeanCapitalCitiesProgressCount
import com.example.ultimatetrivia.SubConstants.getEuropeanCapitalCitiesSubTopics
import com.example.ultimatetrivia.SubConstants.getNorthAmericanCapitalCitiesHighScores
import com.example.ultimatetrivia.SubConstants.getNorthAmericanCapitalCitiesProgressCount
import com.example.ultimatetrivia.SubConstants.getNorthAmericanCapitalCitiesSubTopics
import com.example.ultimatetrivia.SubConstants.getOceaniaCapitalCitiesHighScores
import com.example.ultimatetrivia.SubConstants.getOceaniaCapitalCitiesProgressCount
import com.example.ultimatetrivia.SubConstants.getOceaniaCapitalCitiesSubTopics
import com.example.ultimatetrivia.SubConstants.getSouthAmericanCapitalCitiesHighScores
import com.example.ultimatetrivia.SubConstants.getSouthAmericanCapitalCitiesProgressCount
import com.example.ultimatetrivia.SubConstants.getSouthAmericanCapitalCitiesSubTopics
import com.example.ultimatetrivia.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_sub_topics.*

class Topics : AppCompatActivity(), ItemAdapter.OnItemCLickListener{

    lateinit var list:ArrayList<String>
    lateinit var images:ArrayList<Int>
    lateinit var highScores:ArrayList<String>
    lateinit var progressScores:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_topics)
        makeRecyclerView()

    }

    //This refreshes the recyclerview when the user backs up from the previous activity
    override fun onResume() {
        super.onResume()
        makeRecyclerView()
    }

    fun makeRecyclerView(){


        var a = intent.getStringExtra("QuizPath")

        if(a == "Presidents"){
            list = getPresidentSubTopics()
            images = getPresidentImages()
            highScores = getPresidentHighScores(this)
            progressScores = getPresidentProgressScores(this)
        }
        else if(a == "Capital Cities"){
            list = getCapitalCitiesSubTopics()
            images = getCapitalCitiesImages()
            highScores = arrayListOf("")
            progressScores = arrayListOf("")
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
        else if(a == "General Knowledge"){
            list = getGKSubTopics()
            images = arrayListOf()
            highScores = getGKHighScores(this)
            progressScores = getGKProgressScores(this)
        }
        else if (a == "Capital Cities,European Capital Cities"){
            list = getEuropeanCapitalCitiesSubTopics()
            images = arrayListOf()
            highScores = getEuropeanCapitalCitiesHighScores(this)
            progressScores = getEuropeanCapitalCitiesProgressCount(this)
        }
        else if (a == "Capital Cities,Asian Capital Cities"){
            list = getAsianCapitalCitiesSubTopics()
            images = arrayListOf()
            highScores = getAsianCapitalCitiesHighScores(this)
            progressScores = getAsianCapitalCitiesProgressCount(this)
        }
        else if (a == "Capital Cities,African Capital Cities"){
            list = getAfricanCapitalCitiesSubTopics()
            images = arrayListOf()
            highScores = getAfricanCapitalCitiesHighScores(this)
            progressScores = getAfricanCapitalCitiesProgressCount(this)
        }
        else if (a == "Capital Cities,Oceania Capital Cities"){
            list = getOceaniaCapitalCitiesSubTopics()
            images = arrayListOf()
            highScores = getOceaniaCapitalCitiesHighScores(this)
            progressScores = getOceaniaCapitalCitiesProgressCount(this)
        }
        else if (a == "Capital Cities,North American Capital Cities"){
            list = getNorthAmericanCapitalCitiesSubTopics()
            images = arrayListOf()
            highScores = getNorthAmericanCapitalCitiesHighScores(this)
            progressScores = getNorthAmericanCapitalCitiesProgressCount(this)
        }
        else if (a == "Capital Cities,South American Capital Cities"){
            list = getSouthAmericanCapitalCitiesSubTopics()
            images = arrayListOf()
            highScores = getSouthAmericanCapitalCitiesHighScores(this)
            progressScores = getSouthAmericanCapitalCitiesProgressCount(this)
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
        if(list.get(position) == "EXIT"){
            finish();
            return
        }
        val topicName = this.intent.getStringExtra("QuizPath")


        //LAUNCHES A SUBTOPIC MENU
        if(topicName == "Capital Cities"){
            val intent = Intent(this, Topics::class.java)
            val quizPath = (topicName+","+list.get(position))
            intent.putExtra("QuizPath",quizPath)
            startActivity(intent)
        }
        else{
            val intent = Intent(this, GenericQuiz::class.java)
            val quizPath = (topicName+","+list.get(position))
            intent.putExtra("QuizPath", quizPath)
            startActivity(intent)
        }
    }

}