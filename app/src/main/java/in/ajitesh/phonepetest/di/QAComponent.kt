package `in`.ajitesh.phonepetest.di

import `in`.ajitesh.phonepetest.presenter.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [QAModule::class])
@Singleton
interface QAComponent {
    fun injectMainViewModel(mainViewModel: MainViewModel)
}