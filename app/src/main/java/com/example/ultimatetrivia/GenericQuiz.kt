package com.example.ultimatetrivia

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ultimatetrivia.Constants.returnAlloyGK
import com.example.ultimatetrivia.Constants.returnElementBySymbol
import com.example.ultimatetrivia.Constants.returnElementGK
import com.example.ultimatetrivia.Constants.returnGK1
import com.example.ultimatetrivia.Constants.returnStateByStateCapital
import com.example.ultimatetrivia.Constants.returnStateCapitalByState
import com.example.ultimatetrivia.Constants.returnStateGK
import com.example.ultimatetrivia.Constants.returnSymbolbyElement
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_quiz.*
import java.util.*
import kotlin.math.roundToInt


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
    private var fullQuizLength = 0

    //Getting what type of quiz we're in
    lateinit var arr: Array<String?>
    var subTopicName = ""
    var position = ""
    var fullQuizFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        //Make Text Hint dissapear when clicked
        etEnterAnswer.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) etEnterAnswer.setHint("") else etEnterAnswer.setHint("Enter Answer")
            }
        })



        arr = intent.getStringArrayExtra("1") as Array<String?>
        subTopicName = arr[0]!!
        position = arr[1]!!


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
                //if(fullQuizFlag)
                    //saveHighScore("$correctCounter/$correctCounter", position)

                restartQuiz()
                fullQuizFlag = true //Resetting the flag so a new HighScore can be set
                getQuestions()
            }

            //Quiz is finished and they got less than 100%
            else if (endOfQuizFlag && correctCounter <= len){
                //restart with incorrect answers only
                questionsList = questionsWrongList
                var tempCor = correctCounter
                restartQuiz()
                //If they got 0 on the full quiz then any score should be saved as a highscore
                if(tempCor == 0 && len == fullQuizLength)
                    fullQuizFlag=true
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
            saveProgress()
            finish();
        }
        //--CLEAR HIGHSCORE TEMPORARY CODE--
        //val pref = getSharedPreferences(subTopicName,Context.MODE_PRIVATE)
        //pref.edit().clear().commit();

        val a = restoreProgress()
        if(a == true)
            return



        //Based on what questions we need we return the list
        getQuestions()

    }


    override fun onBackPressed() {
        saveProgress()
        finish()
    }



    fun getQuestions(){

        if (subTopicName == "Presidents"){
            if(position == "0") {
                questionsList = Constants.returnPresidentsByNumber(this)
                randomiseQuestions()
            }
            else if(position == "1") {
                questionsList = Constants.returnNumberByPresidents(this)
                randomiseQuestions()
            }
            else if(position == "2") {
                questionsList = Constants.returnPresidentsByYear(this)
                randomiseQuestions()
            }
            else if(position == "3") {
                questionsList = Constants.returnPresidentsGK(this)
                randomiseQuestions()
            }
            askQuestion()
        }

        else if (subTopicName == "US States") {

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

        else if(subTopicName == "Periodic Table"){
            if (position == "0") {
                questionsList = returnElementBySymbol(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "1") {
                questionsList = returnSymbolbyElement(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "2") {
                questionsList = returnElementGK(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "3") {
                questionsList = returnAlloyGK(this)
                randomiseQuestions()
                askQuestion()
            }
        }
        else if(subTopicName == "General Knowledge"){
            if (position == "0") {
                questionsList = returnGK1(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "1") {
                questionsList = returnSymbolbyElement(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "2") {
                questionsList = returnElementGK(this)
                randomiseQuestions()
                askQuestion()
            } else if (position == "3") {
                questionsList = returnAlloyGK(this)
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
        fullQuizLength = questionsList.size
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


    fun checkAnswer(inputtedAnswer:String){

        val answer = answersList.get(0)
        answersList.replaceAll { it.lowercase(Locale.getDefault()) }
        var InputtedAnswer=inputtedAnswer.lowercase()

        //remove spaces from end of answer and start of answer
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
        updateProgress()


    }

    //This will update the textView of the progress and the score
    fun updateProgress(){
        val score = "Score:\n$correctCounter/${correctCounter+incorrectCounter}"
        tvScore.setText(score)

        val total = (correctCounter+incorrectCounter).toDouble()
        val percent = (total/questionsList.size)*100
        val percentRounded = percent.roundToInt()
        val progress = "Progress:\n$percentRounded%\n($index/${questionsList.size})"
        tvProgress.setText(progress)
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

        if (correctCounter == len && fullQuizFlag)
            tvQuestionText.setText("You got 100% well done! Do you want to do the quiz again?")
        else if(correctCounter == len && fullQuizFlag != true){
            tvQuestionText.setText("You got 100% (Of the SubQuiz) well done! Do you want to do the quiz again?")
        }
        else
            tvQuestionText.setText("You got $correctCounter/$len. \n \n Do you want to redo the quiz with the questions you got wrong?")
        endOfQuizFlag = true

        //Save High Score
        val highScore = returnHighScore()
        if (fullQuizFlag && correctCounter>highScore)
            saveHighScore("$correctCounter/${questionsList.size}", position)



    }

    fun restartQuiz(){
        index = 0
        correctCounter = 0
        incorrectCounter = 0
        endOfQuizFlag = false
        fullQuizFlag = false
        questionsWrongList = arrayListOf<Array<ArrayList<String>>>()
        btConfirm.setText("Confirm")
        tvScore.setText("Score:\n0/0")
        tvProgress.setText("Progress:\n0%")
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

    fun returnHighScore():Int{
        val sharedPreferences = getSharedPreferences(subTopicName,Context.MODE_PRIVATE)
        val highScore = sharedPreferences.getString(position,"-1")!!
        val hsList = highScore.split("/")
        val hs = hsList.get(0)
        return hs.toInt()
    }

    fun saveProgress(){
        val sharedPreferences = getSharedPreferences(subTopicName,Context.MODE_PRIVATE)
        val count = correctCounter+incorrectCounter

        //If it's the end of the quiz simply reset the progress and return
        if(endOfQuizFlag || fullQuizFlag==false || count ==0){
            val editor = sharedPreferences.edit()
            editor.remove("Progress$position")
            editor.remove("ProgressCount$position")
            editor.apply()
            return
        }

        val newObj:ProgressDataClass = ProgressDataClass(
            index,
            correctCounter,
            incorrectCounter,
            questionsList,
            questionsWrongList
        )

        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(newObj)
        editor.putString("Progress$position", json)

        val prog = "Progress: $count/${questionsList.size}"
        editor.putString("ProgressCount$position", prog)
        editor.apply()
    }

    fun restoreProgress():Boolean{
        val sharedPreferences = getSharedPreferences(subTopicName,Context.MODE_PRIVATE)
        //val progess = sharedPreferences.getString("Progress","0")!!

        val gson = Gson()
        val json: String = sharedPreferences.getString("Progress$position", "0")!!
        println(json)
        if(json!="0") {
            val progress: ProgressDataClass = gson.fromJson(json, ProgressDataClass::class.java)
            index = progress.index
            correctCounter = progress.correctCounter
            incorrectCounter = progress.incorrectCounter
            questionsList = progress.questionsList
            questionsWrongList = progress.questionsWrongList
            updateProgress()
            askQuestion()
            return true
        }
        return false


    }

    //This function is called to make the softKeyboard disappear
    fun hideKeyboard(view:View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}