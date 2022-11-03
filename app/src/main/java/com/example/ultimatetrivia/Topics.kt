package com.example.ultimatetrivia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ultimatetrivia.Constants.getCapitalCitiesImages
import com.example.ultimatetrivia.Constants.getCapitalCitiesTopics
import com.example.ultimatetrivia.Constants.getGKHighScores
import com.example.ultimatetrivia.Constants.getGKProgressScores
import com.example.ultimatetrivia.Constants.getGKTopics
import com.example.ultimatetrivia.Constants.getHistoryTopics
import com.example.ultimatetrivia.Constants.getPeriodicTableHighScores
import com.example.ultimatetrivia.Constants.getPeriodicTableImages
import com.example.ultimatetrivia.Constants.getPeriodicTableProgressScores
import com.example.ultimatetrivia.Constants.getPeriodicTableTopics
import com.example.ultimatetrivia.Constants.getPresidentHighScores
import com.example.ultimatetrivia.Constants.getPresidentImages
import com.example.ultimatetrivia.Constants.getPresidentProgressScores
import com.example.ultimatetrivia.Constants.getPresidentTopics
import com.example.ultimatetrivia.Constants.getUSStatesHighScores
import com.example.ultimatetrivia.Constants.getUSStatesImages
import com.example.ultimatetrivia.Constants.getUSStatesProgressScores
import com.example.ultimatetrivia.Constants.getUSStatesTopics
import com.example.ultimatetrivia.CapitalCityConstants.getAfricanCapitalCitiesHighScores
import com.example.ultimatetrivia.CapitalCityConstants.getAfricanCapitalCitiesProgressCount
import com.example.ultimatetrivia.CapitalCityConstants.getAfricanCapitalCitiesSubTopics
import com.example.ultimatetrivia.CapitalCityConstants.getAsianCapitalCitiesHighScores
import com.example.ultimatetrivia.CapitalCityConstants.getAsianCapitalCitiesProgressCount
import com.example.ultimatetrivia.CapitalCityConstants.getAsianCapitalCitiesSubTopics
import com.example.ultimatetrivia.CapitalCityConstants.getCapitalCityGK
import com.example.ultimatetrivia.CapitalCityConstants.getEuropeanCapitalCitiesHighScores
import com.example.ultimatetrivia.CapitalCityConstants.getEuropeanCapitalCitiesProgressCount
import com.example.ultimatetrivia.CapitalCityConstants.getEuropeanCapitalCitiesSubTopics
import com.example.ultimatetrivia.CapitalCityConstants.getNorthAmericanCapitalCitiesHighScores
import com.example.ultimatetrivia.CapitalCityConstants.getNorthAmericanCapitalCitiesProgressCount
import com.example.ultimatetrivia.CapitalCityConstants.getNorthAmericanCapitalCitiesSubTopics
import com.example.ultimatetrivia.CapitalCityConstants.getOceaniaCapitalCitiesHighScores
import com.example.ultimatetrivia.CapitalCityConstants.getOceaniaCapitalCitiesProgressCount
import com.example.ultimatetrivia.CapitalCityConstants.getOceaniaCapitalCitiesSubTopics
import com.example.ultimatetrivia.CapitalCityConstants.getSouthAmericanCapitalCitiesHighScores
import com.example.ultimatetrivia.CapitalCityConstants.getSouthAmericanCapitalCitiesProgressCount
import com.example.ultimatetrivia.CapitalCityConstants.getSouthAmericanCapitalCitiesSubTopics
import com.example.ultimatetrivia.HistoryConstants.getHistoryWarsAndConflictsHighScores
import com.example.ultimatetrivia.HistoryConstants.getHistoryWarsAndConflictsProgressCount
import com.example.ultimatetrivia.HistoryConstants.getHistoryWarsAndConflictsSubTopics
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
            list = getPresidentTopics()
            images = getPresidentImages()
            highScores = getPresidentHighScores(this)
            progressScores = getPresidentProgressScores(this)
        }
        else if(a == "Capital Cities"){
            list = getCapitalCitiesTopics()
            images = getCapitalCitiesImages()
            highScores = arrayListOf("")
            progressScores = arrayListOf("")
        }
        else if(a == "Periodic Table"){
            list = getPeriodicTableTopics()
            images = getPeriodicTableImages()
            highScores = getPeriodicTableHighScores(this)
            progressScores = getPeriodicTableProgressScores(this)
        }
        else if(a == "US States"){
            list = getUSStatesTopics()
            images = getUSStatesImages()
            highScores = getUSStatesHighScores(this)
            progressScores = getUSStatesProgressScores(this)
        }
        else if(a == "General Knowledge"){
            list = getGKTopics()
            images = arrayListOf()
            highScores = getGKHighScores(this)
            progressScores = getGKProgressScores(this)
        }
        else if(a == "History"){
            list = getHistoryTopics()
            images = arrayListOf()
            highScores = arrayListOf("")
            progressScores = arrayListOf("")
        }

        //Capital City SubTopics Display
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
        //History SubTopics Display
        else if (a == "History,Wars and Conflicts"){
            list = getHistoryWarsAndConflictsSubTopics()
            images = arrayListOf()
            highScores = getHistoryWarsAndConflictsHighScores(this)
            progressScores = getHistoryWarsAndConflictsProgressCount(this)
        }

        else{
            list = getPresidentTopics()
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

        //This is the only capital city topic that doesn't launch subtopics so we use a catching if statemnet
        if(topicName == "Capital Cities" && list.get(position) == "Capital City General Knowledge"){
            val intent = Intent(this, GenericQuiz::class.java)
            val quizPath = (topicName+","+list.get(position))
            intent.putExtra("QuizPath", quizPath)
            startActivity(intent)
        }

        else if(topicName == "Capital Cities" || topicName == "History"){
            val intent = Intent(this, Topics::class.java)
            val quizPath = (topicName+","+list.get(position))
            intent.putExtra("QuizPath",quizPath)
            startActivity(intent)
        }
        //Starts the Quiz and passes through the path so it can be found in the GenericQuiz Class.
        else{
            val intent = Intent(this, GenericQuiz::class.java)
            val quizPath = (topicName+","+list.get(position))
            intent.putExtra("QuizPath", quizPath)
            startActivity(intent)
        }
    }

}