package com.example.ultimatetrivia

import android.content.Context
import android.content.res.AssetManager
import java.io.InputStream


object CapitalCityConstants{

    //CAPITAL CITIES SUBTOPICS

    fun getEuropeanCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Medium","Capital By Country Hard","Capital By Country All","Country By Capital All","EXIT")
        return subTopicTitles
    }
    fun getAsianCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Medium","Capital By Country Hard","Capital By Country All","Country By Capital All","EXIT")
        return subTopicTitles
    }
    fun getAfricanCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Medium","Capital By Country Hard","Capital By Country All","Country By Capital All","EXIT")
        return subTopicTitles
    }
    fun getOceaniaCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Hard","Capital By Country All","Country By Capital All","EXIT")
        return subTopicTitles
    }
    fun getNorthAmericanCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Hard","Capital By Country All","Country By Capital All","EXIT")
        return subTopicTitles
    }
    fun getSouthAmericanCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country Easy","Capital By Country Hard","Capital By Country All","Country By Capital All","EXIT")
        return subTopicTitles
    }
    fun getAllCapitalCitiesSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Capital By Country","Country By Capital","EXIT")
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
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val hs4 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3,hs4)
        return arrayList
    }
    fun getAsianCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country Medium",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val hs4 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3,hs4)
        return arrayList
    }
    fun getAfricanCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country Medium",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val hs4 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3,hs4)
        return arrayList
    }
    fun getOceaniaCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }
    fun getNorthAmericanCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }
    fun getSouthAmericanCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }
    fun getAllCapitalCitiesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,All Capital Cities,Capital By Country",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,All Capital Cities,Country By Capital",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1)
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
        sharedPreferences = context.getSharedPreferences("Capital Cities,European Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val pr4 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3,pr4)
        return arrayList
    }
    fun getAsianCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country Medium",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Asian Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val pr4 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3,pr4)
        return arrayList
    }
    fun getAfricanCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country Medium",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,African Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val pr4 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3,pr4)
        return arrayList
    }
    fun getOceaniaCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,Oceania Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3)
        return arrayList
    }
    fun getNorthAmericanCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,North American Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2)
        return arrayList
    }
    fun getSouthAmericanCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Capital By Country Easy",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Capital By Country Hard",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Capital By Country All",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,South American Capital Cities,Country By Capital All",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3)
        return arrayList
    }
    fun getAllCapitalCitiesProgressCount(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Capital Cities,All Capital Cities,Capital By Country",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Capital Cities,All Capital Cities,Country By Capital",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1)
        return arrayList
    }


    //EUROPEAN SUB SUB QUESTIONS

    fun getEuropeanCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/europeanCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getEuropeanCapitalByCountryMedium(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/europeanCapitalByCountryMedium.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getEuropeanCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/europeanCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getEuropeanCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/europeanCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getEuropeanCountryByCapitalAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/europeanCountryByCapitalAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //ASIAN
    fun getAsianCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/asianCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getAsianCapitalByCountryMedium(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/asianCapitalByCountryMedium.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getAsianCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/asianCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getAsianCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/asianCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getAsianCountryByCapitalAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/asianCountryByCapitalAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //AFRICAN QUESTIONS
    fun getAfricanCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/africanCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getAfricanCapitalByCountryMedium(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/africanCapitalByCountryMedium.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getAfricanCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/africanCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getAfricanCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/africanCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getAfricanCountryByCapitalAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/africanCountryByCapitalAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //OCEANIA QUESTIONS
    fun getOceaniaCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/oceaniaCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getOceaniaCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/oceaniaCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getOceaniaCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/oceaniaCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getOceaniaCountryByCapitalAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/oceaniaCountryByCapitalAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //North American Questions
    fun getNorthAmericanCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/northAmericanCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getNorthAmericanCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/northAmericanCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getNorthAmericanCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/northAmericanCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getNorthAmericanCountryByCapitalAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/northAmericanCountryByCapitalAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //South American Questions
    fun getSouthAmericanCapitalByCountryEasy(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/southAmericanCapitalByCountryEasy.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    fun getSouthAmericanCapitalByCountryHard(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/southAmericanCapitalByCountryHard.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getSouthAmericanCapitalByCountryAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/southAmericanCapitalByCountryAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getSouthAmericanCountryByCapitalAll(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/southAmericanCountryByCapitalAll.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //ALL CONTINENTS
    fun getAllCapitalByCountry(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/allCapitalByCountry.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }
    fun getAllCountryByCapital(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/allCountryByCapital.txt")
        val list = Constants.returnArrayList(IS)
        return list
    }

    //Get Capital City general knowledge
    fun getCapitalCityGK(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("Capital Cities/capitalCityGK.txt")
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
