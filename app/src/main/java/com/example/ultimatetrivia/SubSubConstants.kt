package com.example.ultimatetrivia

import android.content.Context
import android.content.res.AssetManager
import java.io.InputStream


object SubSubConstants{

    fun getEuropeanCapitalCitiesSubTopics():ArrayList<String>{

        val subTopicTitles = arrayListOf("Capital by Country Easy","Capital By Country Medium","Capital By Country Hard","Capital By Country All","EXIT")
        return subTopicTitles
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
