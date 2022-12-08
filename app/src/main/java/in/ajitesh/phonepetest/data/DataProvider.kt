package `in`.ajitesh.phonepetest.data

import io.reactivex.Single

interface DataProvider {
    fun getData() : Single<List<Question>>
}