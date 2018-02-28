package other

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object Client {

    var API_BASE_URL = "https://api.github.com/"

    var httpClient = OkHttpClient.Builder()

    var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    var retrofit = builder
            .client(httpClient.build())
            .build()

    var client = retrofit.create(GitHubClient::class.java)

}