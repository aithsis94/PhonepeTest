package `in`.ajitesh.phonepetest.data

import io.reactivex.Single

class DiskDataProvider : DataProvider {

    override fun getData(): Single<List<Question>> {

        //assume they are coming from disk
        return Single.just(

            listOf(
                Question(
                    "http://www.dsource.in/sites/default/files/resource/logo-design/logos/logos-representing-india/images/01.jpeg",
                    "AADHAAR"
                ),
                Question(
                    "https://static.digit.in/default/thumb_101067_default_td_480x480.jpeg",
                    "PHONEPE"
                )
            )
        )
    }
}