package `in`.ajitesh.phonepetest.presenter

import `in`.ajitesh.phonepetest.data.DataProvider
import `in`.ajitesh.phonepetest.data.Question
import `in`.ajitesh.phonepetest.di.DIApplication
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.random.Random

class MainViewModel(app: Application) : AndroidViewModel(app) {

    @Inject
    @JvmField
    var dataProvider: DataProvider?= null

    init {
        require(app is DIApplication) {
            "app provides is not DIApplication"
        }

        (app as DIApplication).getComponent().injectMainViewModel(this)

        this.dataProvider!!.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                this.allQuestions.postValue(it)
                moveToNextQuestion()
            }
    }

    private val points = MutableLiveData<Int>()
    private val currQuestion = MutableLiveData<Question>()
    private val userAnswer = MutableLiveData<String>()
    private val allQuestions = MutableLiveData<List<Question>>()

    fun getPoints() = points as LiveData<Int>
    fun getCurrQuestion() = currQuestion as LiveData<Question>
    fun getUserAnswer() = userAnswer as LiveData<String>

    fun onAnswerSubmit() {
        val submittedAnswer = userAnswer.value ?: ""
        if (submittedAnswer == currQuestion.value!!.name) {
            points.value = (points.value ?: 0) + 1
        }
        moveToNextQuestion()
    }

    private fun moveToNextQuestion() {
        val questions = this.allQuestions.value ?: emptyList()
        val nextQuestion = questions[Random.nextInt(0, questions.size)]
        this.currQuestion.postValue(nextQuestion)
    }
}