package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity(), View.OnClickListener{


    private var mCurrentPosition: Int = 1                         // initializing variable to keep a check on which question we are
    private var mQuestionsList: ArrayList<Question>? = null       // declaring list of questions variable as null
    private var mSelectedOption: Int = 0                          // initializing variable to keep a check on which option is selected by user
    private  var mUserName: String? = null                        // declaring var this will hold user name passed by intent
    private var mCorrectAns: Int = 0                              // this will hold the value of correct ans passed by intent

    private var progressBar: ProgressBar? = null                  // var which will check in position of progressbar
    private var tvProgress: TextView? = null                      // var which will check the number of progress bar
    private var tvQuestion: TextView? = null                      // var which will display question at the top
    private var tvImage: ImageView? = null                        // var which will display image

    private var optionOne: TextView? = null                        // var which will display option 1
    private var optionTwo: TextView? = null                        // var which will display option 2
    private var optionThree: TextView? = null                        // var which will display option 3
    private var optionFour: TextView? = null                        // var which will display option 4
    private var submitBtn: Button? = null                        // declaring btn to submit the que

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mUserName = intent.getStringExtra(Constants.userName)          // initializing username via intent
        progressBar = findViewById(R.id.progressBar)                   // initializing
        tvProgress = findViewById(R.id.tvProgress)                   // initializing
        tvQuestion = findViewById(R.id.tvQuestion)                   // initializing
        tvImage = findViewById(R.id.tvImage)                   // initializing
        optionOne = findViewById(R.id.tv_option_one)                   // initializing
        optionTwo = findViewById(R.id.tv_option_two)                   // initializing
        optionThree = findViewById(R.id.tv_option_three)                   // initializing
        optionFour = findViewById(R.id.tv_option_four)                   // initializing
        submitBtn = findViewById(R.id.submitBtn)                   // initializing

        optionOne?.setOnClickListener(this)                        // putting on click listen on options setting the current class,(which implements OnClickListener) as the click listener for the optionOne view.
        optionTwo?.setOnClickListener(this)                        //same
        optionThree?.setOnClickListener(this)                        //same
        optionFour?.setOnClickListener(this)                        //same
        submitBtn?.setOnClickListener(this)                        //same

        mQuestionsList = Constants.getQuestions()                    // initializing question list by getting questiosn from contants

        setQuestion()                                                // calling the set question method
    }

    private fun setQuestion() {
        defeaultOptionView()                                        // so that every time new question comes, things look like default
        val question: Question = mQuestionsList !! [mCurrentPosition - 1] // initializing a var which will show que (starting from 0) , here current position is 1, but questions starts at index 0 of the list
        tvImage?.setImageResource(question.image)                    // it will set the image from question property
        progressBar?.progress = mCurrentPosition                     // progress bar will align with current number of questions
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"   // text view beside the progress bar
        tvQuestion?.text = question.question                          // we will take text property from question
        optionOne?.text = question.optionOne                          // we will take option property from question
        optionTwo?.text = question.optionTwo                          // we will take option property from question
        optionThree?.text = question.optionThree                          // we will take option property from question
        optionFour?.text = question.optionFour                          // we will take option property from question

        if(mCurrentPosition == mQuestionsList!!.size){                // it will keep the text of button to submit
            submitBtn?.text = "SUBMIT"                                // no need of this step can be done in direct XML
        }else{
            submitBtn?.text = "SUBMIT"
        }
    }

    private fun defeaultOptionView(){                                 // it will set the screen and options back to default view
        val options = ArrayList<TextView>()                          // making an array list of text views

        optionOne?.let {                                    // adding option 1 to list as a string at index 0
            options.add(0,it)
        }
        optionTwo?.let {                                    // adding option 1 to list as a string at index 1
            options.add(1,it)
        }
        optionThree?.let {                                    // adding option 1 to list as a string at index 2
            options.add(2,it)
        }
        optionFour?.let {                                    // adding option 1 to list as a string at index 3
            options.add(3,it)
        }

        for (option in options){                                      // this for loop will set everything (options) to default
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg                      // default bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){  // function to show selected option
        defeaultOptionView()                                                   // everytime invoked first of all things will get default
        mSelectedOption = selectedOptionNumber                            // initializing the selected option via parameter passed
        tv.setTextColor(Color.parseColor("#A15AD8"))             // we will change the text colour of the selected option
        tv.setTypeface(tv.typeface, Typeface.BOLD)                       // bold the text
        tv.background = ContextCompat.getDrawable(                       // change the bg
            this,
            R.drawable.selected_border                                  // in drawable
        )
    }

    override fun onClick(view: View?) {                                     // fun for clicking on question
        when(view?.id){                                               // passing ids in when block
            R.id.tv_option_one -> {                                    // id for option 1
                optionOne?.let {                              // if option 1 is clicked , selected option fun will be called on option 1, with the specified parameters
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option_two -> {                                    //same
                optionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_three -> {                                    //same
                optionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_four -> {                                    //same
                optionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.submitBtn -> {                                          // will work when submit btn is pressed on each que
                if(mSelectedOption == 0){                                // if there is no option selected
                    mCurrentPosition++                                   // current position will be increased by 1, to set new questions every time
                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {    // it will keep on changing the questions until list end is reached
                            setQuestion()
                        }
                        else -> {                                           // else part of when block, when list end is there, all questions have been performed
                            val intent = Intent(this, MainActivity3::class.java)  //initializing object of intent class for activity 3
                            intent.putExtra(Constants.userName, mUserName)  // passing username with key as constant username
                            intent.putExtra(Constants.correctAnswers, mCorrectAns)  // passing correct ans with key as correctAnswers
                            intent.putExtra(Constants.totalQuestions, mQuestionsList?.size) // passing correct ans with key as correctAnswers
                            startActivity(intent)                                           // starting activity 3
                            finish()                                           // finishing this activity
                        }
                    }
                }else{                                                       // if some option is selected
                    val question = mQuestionsList?.get(mCurrentPosition - 1)   // we will gte question from question list
                    if(question!!.correctAnswer != mSelectedOption){            // if selected uqe is not correct answer
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)   // selected option bg will turn red
                    }else{
                        mCorrectAns++                                               // since ans is correct we will put the number of answers user has entered which are correct in a var
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)  // selected option is correct or not we will display correct option bg as green
                    if(mCurrentPosition == mQuestionsList!!.size){                 // when the questions are at end
                        submitBtn?.text = "FINISH TEST"                            // button text will change to finish
                    }else{
                        submitBtn?.text = "GO TO NEXT QUESTION "                   // else go to next que
                    }
                    mSelectedOption = 0                                            // after every selection we have to reset the selected option to 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){  // this func will get correct answer od the question and also the green border as parameter and will green the border of parameter
        when(answer){                             // simple when block
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}