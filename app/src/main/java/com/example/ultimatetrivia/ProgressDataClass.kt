package com.example.ultimatetrivia

data class ProgressDataClass(
    val index:Int,
    val correctCounter:Int,
    val incorrectCounter:Int,
    val questionsList:ArrayList<Array<ArrayList<String>>>,
    val questionsWrongList:ArrayList<Array<ArrayList<String>>>,
)
