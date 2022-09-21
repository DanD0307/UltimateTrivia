package com.example.ultimatetrivia

import android.content.Context
import android.content.res.AssetManager
import java.io.InputStream


object Constants {

    fun getPresidentSubTopics():ArrayList<String>{
        val subTopicTitles = arrayListOf("Presidents by Number","Number by President","President by Years","Presidents GK","EXIT")
        return subTopicTitles
    }

    fun getPresidentImages():ArrayList<Int>{
        val images = arrayListOf(R.drawable.georgewashington,R.drawable.number,R.drawable.lincoln,R.drawable.whitehouse)
        return images
    }
    fun getPresidentHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Presidents,Presidents by Number",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Presidents,Number by President",Context.MODE_PRIVATE)
        var hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Presidents,President by Years",Context.MODE_PRIVATE)
        var hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Presidents,Presidents GK",Context.MODE_PRIVATE)
        var hs3 = sharedPreferences.getString("HighScore","")!!
        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }
    fun getPresidentProgressScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Presidents,Presidents by Number",Context.MODE_PRIVATE)
        var pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Presidents,Number by President",Context.MODE_PRIVATE)
        var pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Presidents,President by Years",Context.MODE_PRIVATE)
        var pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Presidents,Presidents GK",Context.MODE_PRIVATE)
        var pr3 = sharedPreferences.getString("ProgressCount","")!!
        val arrayList = arrayListOf(pr0,pr1,pr2,pr3)
        return arrayList
    }

    fun getCapitalCitiesSubTopics():ArrayList<String>{

        val subTopicTitles = arrayListOf("European Capital Cities","Asian Capital Cities","African Capital Cities","Oceania Capital Cities", "Capital City General Knowledge", "Capital from Country","Country from Capital","EXIT")
        return subTopicTitles
    }
    fun getCapitalCitiesImages():ArrayList<Int>{
        val images = arrayListOf(R.drawable.europe,R.drawable.asianew,R.drawable.africa,R.drawable.oceania,R.drawable.europe)
        return images
    }

    fun getPeriodicTableSubTopics():ArrayList<String>{

        val subTopicTitles = arrayListOf("Element by Symbol","Symbol by Element","Element General Knowledge","Alloy General Knowledge","EXIT")
        return subTopicTitles
    }

    fun getPeriodicTableImages():ArrayList<Int>{
        val images = arrayListOf(R.drawable.goldbrick,R.drawable.goldsymbol,R.drawable.magnet,R.drawable.steel)
        return images
    }

    fun getPeriodicTableHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Periodic Table,Element by Symbol",Context.MODE_PRIVATE)
        val hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Periodic Table,Symbol by Element",Context.MODE_PRIVATE)
        val hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Periodic Table,Element General Knowledge",Context.MODE_PRIVATE)
        val hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("Alloy General Knowledge",Context.MODE_PRIVATE)
        val hs3 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }
    fun getPeriodicTableProgressScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("Periodic Table,Element by Symbol",Context.MODE_PRIVATE)
        val pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Periodic Table,Symbol by Element",Context.MODE_PRIVATE)
        val pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Periodic Table,Element General Knowledge",Context.MODE_PRIVATE)
        val pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("Alloy General Knowledge",Context.MODE_PRIVATE)
        val pr3 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3)
        return arrayList
    }

    fun getUSStatesSubTopics():ArrayList<String>{

        val subTopicTitles = arrayListOf("State by State Capital","State Capital by State","State General Knowledge","EXIT")
        return subTopicTitles
    }

    fun getUSStatesImages():ArrayList<Int>{
        val images = arrayListOf(R.drawable.texas,R.drawable.saltlakecity,R.drawable.libertybell,)
        return images
    }

    fun getUSStatesHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("US States,State by State Capital",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("US States,State Capital by State",Context.MODE_PRIVATE)
        var hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("US States,State General Knowledge",Context.MODE_PRIVATE)
        var hs2 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2)
        return arrayList
    }
    fun getUSStatesProgressScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("US States,State by State Capital",Context.MODE_PRIVATE)
        var pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("US States,State Capital by State",Context.MODE_PRIVATE)
        var pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("US States,State General Knowledge",Context.MODE_PRIVATE)
        var pr2 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2)
        return arrayList
    }

    fun getGKSubTopics():ArrayList<String>{

        val subTopicTitles = arrayListOf("General Knowledge Quiz 1","General Knowledge Quiz 2","General Knowledge Quiz 3","General Knowledge Quiz 4","General Knowledge Quiz 5","EXIT")
        return subTopicTitles
    }
    fun getGKHighScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 1",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 2",Context.MODE_PRIVATE)
        var hs1 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 3",Context.MODE_PRIVATE)
        var hs2 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 4",Context.MODE_PRIVATE)
        var hs3 = sharedPreferences.getString("HighScore","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 5",Context.MODE_PRIVATE)
        var hs4 = sharedPreferences.getString("HighScore","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2,hs3,hs4)
        return arrayList
    }

    fun getGKProgressScores(context:Context):ArrayList<String>{
        var sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 1",Context.MODE_PRIVATE)
        var pr0 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 2",Context.MODE_PRIVATE)
        var pr1 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 3",Context.MODE_PRIVATE)
        var pr2 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 4",Context.MODE_PRIVATE)
        var pr3 = sharedPreferences.getString("ProgressCount","")!!
        sharedPreferences = context.getSharedPreferences("General Knowledge,General Knowledge Quiz 5",Context.MODE_PRIVATE)
        var pr4 = sharedPreferences.getString("ProgressCount","")!!

        val arrayList = arrayListOf(pr0,pr1,pr2,pr3,pr4)
        return arrayList
    }

    //---------------------------------------------------------------//
    //                  PRESIDENTS QUESTIONS                         //
    //---------------------------------------------------------------//
    fun returnNumberByPresidents(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("NumberByPresidents.txt")
        var presidentsList = arrayListOf<Array<ArrayList<String>>>()

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
            presidentsList.add(qAndA)
        }
        return presidentsList
    }

    fun returnPresidentsByNumber(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("PresidentsByNumber.txt")
        var presidentsList = arrayListOf<Array<ArrayList<String>>>()

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
            presidentsList.add(qAndA)
        }

        return presidentsList
    }

    fun returnPresidentsByYear(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("PresidentsByYear.txt")
        var presidentsList = arrayListOf<Array<ArrayList<String>>>()

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
            presidentsList.add(qAndA)
        }

        return presidentsList
    }

    fun returnPresidentsGK(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("PresidentsGK.txt")
        var presidentsList = arrayListOf<Array<ArrayList<String>>>()

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
            presidentsList.add(qAndA)
        }

        return presidentsList
    }

    //---------------------------------------------------------------//
    //                  US STATES QUESTIONS                          //
    //---------------------------------------------------------------//

    fun returnStateByStateCapital(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("stateByStateCapital.txt")
        val list = returnArrayList(IS)
        return list

    }

    fun returnStateCapitalByState(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("statecapitalByState.txt")
        val list = returnArrayList(IS)
        return list

    }

    fun returnStateGK(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("stateGK.txt")
        val list = returnArrayList(IS)
        return list

    }

    //---------------------------------------------------------------//
    //                  PERIODIC  TABLE QUESTIONS                    //
    //---------------------------------------------------------------//

    fun returnElementBySymbol(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("elementBySymbol.txt")
        val list = returnArrayList(IS)
        return list

    }
    fun returnSymbolbyElement(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("symbolByElement.txt")
        val list = returnArrayList(IS)
        return list

    }
    fun returnElementGK(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("elementGK.txt")
        val list = returnArrayList(IS)
        return list

    }
    fun returnAlloyGK(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("alloyGK.txt")
        val list = returnArrayList(IS)
        return list

    }

    //---------------------------------------------------------------//
    //                  GENERAL KNOWLEDGE QUESTIONS                  //
    //---------------------------------------------------------------//

    fun returnGK1(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("gk1.txt")
        val list = returnArrayList(IS)
        return list
    }

    fun returnGK2(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("gk2.txt")
        val list = returnArrayList(IS)
        return list
    }
    fun returnGK3(context:Context):ArrayList<Array<ArrayList<String>>> {
        val manager: AssetManager = context.getAssets()
        val IS : InputStream = manager.open("gk3.txt")
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