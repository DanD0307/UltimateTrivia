package com.example.ultimatetrivia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ultimatetrivia.Constants.returnNumberByPresidents
import com.example.ultimatetrivia.Constants.returnPresidentsByNumber
import com.example.ultimatetrivia.Constants.returnPresidentsByYear
import com.example.ultimatetrivia.Constants.returnPresidentsGK
import com.example.ultimatetrivia.Constants.returnStateByStateCapital
import com.example.ultimatetrivia.Constants.returnStateCapitalByState
import com.example.ultimatetrivia.Constants.returnStateGK
import kotlinx.android.synthetic.main.activity_quiz.*
import java.util.*
import kotlin.collections.ArrayList


class GenericQuiz : AppCompatActivity() {
    //Question details
    var index = 0
    var correctCounter = 0
    private var incorrectCounter = 0
    var endOfQuizFlag = false
    var continueFlag = false

    //List Variables
    private lateinit var questionsList :  ArrayList<Array<ArrayList<String>>>
    private var questionsWrongList =  arrayListOf<Array<ArrayList<String>>>()
    private lateinit var answersList : ArrayList<String>
    private var question = arrayOf<ArrayList<String>>()

    //Getting what type of quiz we're in
    lateinit var arr: Array<String?>
    var subTopicName = ""
    var position = ""
    var firstAttempt = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        //Make Text Hint dissapear when clicked
        etEnterAnswer.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) etEnterAnswer.setHint("") else etEnterAnswer.setHint("Enter Answer")
            }
        })

        //CLEAR HIGHSCORE TEMPORARY CODE
        //val pref = getSharedPreferences("sharedPreferences",Context.MODE_PRIVATE)
        //pref.edit().clear().commit();


        arr = intent.getStringArrayExtra("1") as Array<String?>
        subTopicName = arr[0]!!
        position = arr[1]!!

        //Based on what questions we need we return the list
        getQuestions()


        //If enter is pressed on the editText
        etEnterAnswer.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                btConfirm.performClick();
                return@OnKeyListener true
            }
            false
        })

        //This button is the Confirm/Yes/Continue button
        btConfirm.setOnClickListener {

            var len = questionsList.size
            //IF THEY GOT 100% on QUIZ
            if (endOfQuizFlag && correctCounter == len){
                //if(firstAttempt)
                    //saveHighScore("$correctCounter/$correctCounter", position)

                restartQuiz()
                getQuestions()
            }
            //Quiz is finished and they got less than 100%
            else if (endOfQuizFlag && correctCounter <= len){
                //if(firstAttempt)
                    //saveHighScore("$correctCounter/$len", position)


                //restart with incorrect answers only
                questionsList = questionsWrongList

                restartQuiz()
                randomiseQuestions()
                askQuestion()
            }

            //User has pressed continue so we ask next question
            else if(continueFlag){

                tvCorrectIncorrect.text = ""
                etEnterAnswer.setVisibility(View.VISIBLE)
                btConfirm.text="CONFIRM"
                continueFlag = false
                askQuestion()
            }

            //User has entered nothing so we do nothing.
            else if(etEnterAnswer.text.toString() == ""){
                etEnterAnswer.setText("")
            }

            //User has pressed confirm so we check their answer
            else {
                var inputtedAnswer = etEnterAnswer.text.toString()
                checkAnswer(inputtedAnswer)

            }
        }

        btExitQuiz.setOnClickListener{
            val intent = Intent(this, SubTopics::class.java)
            intent.putExtra("1","Presidents")
            startActivity(intent)
            finish();
        }
        //Figure out what questions to ask - We need to retrieve data from the list of sub topics activit
        getQuestions()
    }



    fun getQuestions(){
        if (subTopicName == "US States") {

            if (position == "0") {
                questionsList = returnStateByStateCapital(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "1") {
                questionsList = returnStateCapitalByState(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "2") {
                questionsList = returnStateGK(this)
                randomiseQuestions()
                askQuestion()
            }
        }
    }

    fun randomiseQuestions(){
        var length = questionsList.size
        val questions = questionsList
        var tempList : Array<ArrayList<String>>
        val randomisedList = arrayListOf<Array<ArrayList<String>>>()
        val min = 0
        var getRandomValue = 0
        while (length>0){
            getRandomValue = (Math.random() * (length - min)).toInt() + min
            tempList = questions.removeAt(getRandomValue)
            randomisedList.add(tempList)
            length = questions.size
        }
        questionsList = randomisedList
    }

    fun askQuestion(){
        //If no more questions left don't continue
        if(index==questionsList.size){
            runFinalScreen()
            return
        }
        val totalQuestion = questionsList.get(index)
        val questionText = totalQuestion[0].get(0)
        val answersArrayList = totalQuestion[1]
        answersList = answersArrayList
        question = totalQuestion

        tvQuestionText.text=questionText
    }


    //TODO Allow spaces in answer
    fun checkAnswer(inputtedAnswer:String){

        val answer = answersList.get(0)
        answersList.replaceAll { it.lowercase(Locale.getDefault()) }
        var InputtedAnswer=inputtedAnswer.lowercase()

        //remove spaces from end of answer
        val l = InputtedAnswer.trimEnd().trimStart()

        if(l in answersList){
            tvCorrectIncorrect.text = "Correct!"
            etEnterAnswer.text.clear()
            etEnterAnswer.setVisibility(View.INVISIBLE)
            index += 1
            correctCounter += 1
            btConfirm.text="CONTINUE"
            hideKeyboard(etEnterAnswer)
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    continueFlag = true
                },
                200 // value in milliseconds
            )
        }
        else{
            tvCorrectIncorrect.text = "Incorrect the correct answer was: $answer"
            etEnterAnswer.text.clear()
            etEnterAnswer.setVisibility(View.INVISIBLE)
            index += 1
            incorrectCounter += 1
            questionsWrongList.add(question)
            btConfirm.text="CONTINUE"
            hideKeyboard(etEnterAnswer)
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    continueFlag = true
                },
                200 // value in milliseconds
            )
        }


    }

    fun runFinalScreen(){
        btExitQuiz.setVisibility(View.VISIBLE)
        btConfirm.setText("Yes")
        etEnterAnswer.setVisibility(View.INVISIBLE)
        var len = questionsList.size
        tvCorrectIncorrect.setVisibility(View.INVISIBLE)

        

        val sharedPreference =  getSharedPreferences("HIGHSCORE",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putInt("score",correctCounter)
        editor.commit()

        if (correctCounter == len)
            tvQuestionText.setText("You got 100% well done! Do you want to do the quiz again?")
        else
            tvQuestionText.setText("You got $correctCounter/$len. \n \n Do you want to redo the quiz with the questions you got wrong?")
        endOfQuizFlag = true

        //Save High Score
        saveHighScore("$correctCounter/${questionsList.size}", position)



    }

    fun restartQuiz(){
        index = 0
        correctCounter = 0
        incorrectCounter = 0
        endOfQuizFlag = false
        firstAttempt = false
        questionsWrongList = arrayListOf<Array<ArrayList<String>>>()
        btConfirm.setText("Confirm")
        etEnterAnswer.setVisibility(View.VISIBLE)
        tvCorrectIncorrect.setVisibility(View.VISIBLE)
    }

    fun saveHighScore(highScore:String, quizName:String){

        val sharedPreferences = getSharedPreferences(subTopicName,Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString(quizName,highScore)
        }.apply()

    }

    //This function is called to make the softKeyboard disappear
    fun hideKeyboard(view:View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}