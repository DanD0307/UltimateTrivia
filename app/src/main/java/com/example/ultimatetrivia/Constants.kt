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
        val sharedPreferences = context.getSharedPreferences("Presidents",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("0","")!!
        var hs1 = sharedPreferences.getString("1","")!!
        var hs2 = sharedPreferences.getString("2","")!!
        var hs3 = sharedPreferences.getString("3","")!!
        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
        return arrayList
    }
    fun getPresidentProgressScores(context:Context):ArrayList<String>{
        val sharedPreferences = context.getSharedPreferences("Presidents",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("ProgressCount0","")!!
        var hs1 = sharedPreferences.getString("ProgressCount1","")!!
        var hs2 = sharedPreferences.getString("ProgressCount2","")!!
        var hs3 = sharedPreferences.getString("ProgressCount3","")!!
        val arrayList = arrayListOf(hs0,hs1,hs2,hs3)
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
        val sharedPreferences = context.getSharedPreferences("Periodic Table",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("0","")!!
        var hs1 = sharedPreferences.getString("1","")!!
        var hs2 = sharedPreferences.getString("2","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2)
        return arrayList
    }
    fun getPeriodicTableProgressScores(context:Context):ArrayList<String>{
        val sharedPreferences = context.getSharedPreferences("Periodic Table",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("ProgressCount0","")!!
        var hs1 = sharedPreferences.getString("ProgressCount1","")!!
        var hs2 = sharedPreferences.getString("ProgressCount2","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2)
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
        val sharedPreferences = context.getSharedPreferences("US States",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("0","")!!
        var hs1 = sharedPreferences.getString("1","")!!
        var hs2 = sharedPreferences.getString("2","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2)
        return arrayList
    }
    fun getUSStatesProgressScores(context:Context):ArrayList<String>{
        val sharedPreferences = context.getSharedPreferences("US States",Context.MODE_PRIVATE)
        var hs0 = sharedPreferences.getString("ProgressCount0","")!!
        var hs1 = sharedPreferences.getString("ProgressCount1","")!!
        var hs2 = sharedPreferences.getString("ProgressCount2","")!!

        val arrayList = arrayListOf(hs0,hs1,hs2)
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