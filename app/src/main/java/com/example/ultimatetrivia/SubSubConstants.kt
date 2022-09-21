package com.example.ultimatetrivia

import android.content.Context
import android.content.res.AssetManager
import java.io.InputStream


object SubSubConstants{

    fun getEuropeanCapitalCitiesSubTopics():ArrayList<String>{

        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Medium","Capital By Country Hard","Capital By Country All","EXIT")
        return subTopicTitles
    }


    //EUROPEAN SUB SUB HIGHSCORES
    fun getEuropeanCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country Medium",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }

    fun getEuropeanCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country Medium",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3)
        return arrayList
    }


    //EUROPEAN SUB SUB QUESTIONS

    fun getEuropeanCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("europeanCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getEuropeanCapitalByCountryMedium(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("europeanCapitalByCountryMedium.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getEuropeanCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("europeanCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getEuropeanCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("europeanCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
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
