package com.example.ultimatetrivia

import android.content.Context
import android.content.res.AssetManager
import java.io.InputStream


object HistoryConstants{

    //val ("Wars and Conflicts","Monarchs Of England(and UK)","Ancient History","History General Knowledge","EXIT")
    //CAPITAL CITIES SUBTOPICS
    fun getHistoryWarsAndConflictsSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("World War II","World War I","American Civil War","American Revolution","The Punic Wars","English Civil War","EXIT")
        return subTopicTitles
    }

    fun getHistoryMonarchsOfEnglandSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("World War II","World War I","American Civil War","American Revolution","The Punic Wars","English Civil War","EXIT")
        return subTopicTitles
    }

    //EUROPEAN SUB SUB HIGHSCORES
    fun getHistoryWarsAndConflictsHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,World War II",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,World War I",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,American Civil War",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,American Revolution",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,The Punic Wars",Context.MODE_PRIVATE)
        val hs4 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,English Civil War",Context.MODE_PRIVATE)
        val hs5 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3,hs4,hs5)
        return arrayList
    }


    fun getHistoryWarsAndConflictsProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,World War II",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,World War I",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,American Civil War",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,American Revolution",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,The Punic Wars",Context.MODE_PRIVATE)
        val pr4 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("History,Wars and Conflicts,English Civil War",Context.MODE_PRIVATE)
        val pr5 = sharedPreferences.getString("ProgressCount","")!!
        val arrayList = arrayListOf(pr0,pr1,pr2,pr3,pr4,pr5)
        return arrayList
    }



    //WarsAndConflicts QUESTIONS

    fun getHistoryWorldWarIIQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/Wars and Conflicts/worldWarII.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryWorldWarIQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/Wars and Conflicts/worldWarI.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryAmericanCivilWarQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/Wars and Conflicts/americanCivilWar.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryAmericanRevolutionQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/Wars and Conflicts/americanRevolution.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryPunicWarsQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/Wars and Conflicts/thePunicWars.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryEnglishCivilWarQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/Wars and Conflicts/englishCivilWar.txt")
        val list = returnArrayList(IS)
        return list
    }

    //Other History Questions
    fun getHistoryMonarchsQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/monarchsQuiz.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryAncientHistoryQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/ancientHistory.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun getHistoryGKQuestions(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS: InputStream = manager.open("History/historyGK.txt")
        val list = returnArrayList(IS)
        return list
    }

    //This function takes an inputstream and returns a nice clean arraylist
    fun returnArrayList(IS:InputStream):ArrayList<Array<ArrayList<String>>>{
        var list = arrayListOf<Array<ArrayList<String>>>()

        IS.bufferedReader().forEachLine {
            var line = it
            var array = line.split("#").toTypedArray()
            var questionArray = arrayListOf(array[0])
            var answers = arrayListOf<String>()

            for (element in array){
                if (element != array[0]){
                    //Append this element to answers array
                    answers.add(element)
                }
            }
            var qAndA = arrayOf(questionArray,answers)
            list.add(qAndA)
        }

        return list
    }
}
