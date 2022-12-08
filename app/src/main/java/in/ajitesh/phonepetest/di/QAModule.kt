package `in`.ajitesh.phonepetest.di

import `in`.ajitesh.phonepetest.data.DataProvider
import `in`.ajitesh.phonepetest.data.DiskDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QAModule {

    @Provides
    @Singleton
    fun providesDataProvider(): DataProvider{
        return DiskDataProvider()
    }
}