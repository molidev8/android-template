package data.datasource.api

import com.molidev8.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = ""

private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.HEADERS
}

val client: OkHttpClient = OkHttpClient.Builder().apply {
    this.addInterceptor(interceptor)
}.build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface ServiceApi {

    @GET("route/")
    fun get(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
    ): Call<Any>
}

object RetrofitApi {
    val retrofitService: ServiceApi by lazy {
        retrofit.create(ServiceApi::class.java)
    }
}
