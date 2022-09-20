package com.example.ultimatetrivia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ultimatetrivia.Constants.getCapitalCitiesImages
import com.example.ultimatetrivia.Constants.getCapitalCitiesSubTopics
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
import com.example.ultimatetrivia.SubSubConstants.getEuropeanCapitalCitiesSubTopics
import com.example.ultimatetrivia.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_sub_topics.*
import java.lang.Exception

class SubTopics : AppCompatActivity(), ItemAdapter.OnItemCLickListener{

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

        //This try statement will only work if we're in a the subtopic of the subtopics.
        try{
            var b = intent.getStringArrayExtra("1") as Array<String?>
            var subTopicName = b[0]!!
            var position = b[1]!!
            subSubTopicMakeRecyclerView(subTopicName,position)
            return
        }
        catch (e: Exception){
            val doNothing = 1
        }


        var a = intent.getStringExtra("1")
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
            highScores = arrayListOf("")
            progressScores = arrayListOf("")
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

    //This function generates the recycler view when its a sub sub topic. (SubTopic Of SubTopic)
    fun subSubTopicMakeRecyclerView(subTopicName:String,position:String){

        if(subTopicName == "Capital Cities"){
            if (position == "0"){
                //EUROPEAN CAPITAL CITIES

                list = getEuropeanCapitalCitiesSubTopics()
                images = arrayListOf()
                highScores = arrayListOf("")
                progressScores = arrayListOf("")
            }
        }

        //Set the LayoutManager that this recycler view will use
        recycler_view_items.layoutManager = LinearLayoutManager(this)
        //Adapter Class
        val itemAdapter = ItemAdapter(this, list as ArrayList<String>,images,highScores,progressScores,this)

        //Adapter instance is set to the recyclerview to inflate the items
        recycler_view_items.adapter = itemAdapter
    }


    override fun onItemClick(position: Int) {
        //Check whether we are in a subsubtopic
        try{
            var b = intent.getStringArrayExtra("1") as Array<String?>
            var subTopicName = b[0]!!
            var outerPosition = b[1]!!
            var innerPosition = position

            if(list.get(innerPosition) == "EXIT"){
                finish();
                return
            }

            val arr = arrayOf(subTopicName, outerPosition.toString(),innerPosition.toString())
            val intent = Intent(this, GenericQuiz::class.java)
            intent.putExtra("1", arr)
            startActivity(intent)

        }
        catch (e: Exception){
            val doNothing = 1
        }





        //When a button is clicked we move to the question screen
        if(list.get(position) == "EXIT"){
            finish();
            return
        }
        val subTopicName = this.intent.getStringExtra("1")

        if(subTopicName == "Presidents" ) {
            val intent = Intent(this, GenericQuiz::class.java)
            val arr = arrayOf(subTopicName, position.toString())
            intent.putExtra("1", arr)
            startActivity(intent)
        }

        if(subTopicName == "US States" || subTopicName == "Periodic Table"|| subTopicName == "General Knowledge") {
            val intent = Intent(this, GenericQuiz::class.java)
            val arr = arrayOf(subTopicName, position.toString())
            intent.putExtra("1", arr)
            startActivity(intent)
        }

        if(subTopicName == "Capital Cities"){
            val intent = Intent(this, SubTopics::class.java)
            val arr = arrayOf(subTopicName, position.toString())
            intent.putExtra("1",arr)
            startActivity(intent)
        }
    }

}