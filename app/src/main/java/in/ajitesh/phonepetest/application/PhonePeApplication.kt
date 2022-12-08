package `in`.ajitesh.phonepetest.application

import `in`.ajitesh.phonepetest.di.DIApplication
import `in`.ajitesh.phonepetest.di.DaggerQAComponent
import `in`.ajitesh.phonepetest.di.QAComponent
import android.app.Application

class PhonePeApplication : Application(), DIApplication {

    private var component: QAComponent? = null

    init {
        this.component = DaggerQAComponent.builder().build()
    }

    override fun getComponent(): QAComponent {
        return component!!
    }
}