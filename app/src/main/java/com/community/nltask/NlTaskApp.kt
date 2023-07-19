package com.community.nltask

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.community.nltask.api.ApiConstants
import com.community.nltask.api.ApiService
import com.community.nltask.api.CustomInterceptor
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.Locale
import java.util.concurrent.TimeUnit

class NlTaskApp : MultiDexApplication() {

    private var apiService: ApiService? = null
    private var androidId = ""
    private var pushRegId = ""

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    companion object {
        private var mInstance: NlTaskApp? = null

        @Synchronized
        fun getInstance(): NlTaskApp {
            if (mInstance == null) {
                mInstance = NlTaskApp()
            }
            return mInstance!!
        }
    }

    override fun onCreate() {
        super.onCreate()

        mInstance = this
        MultiDex.install(applicationContext)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        createApiService()
    }

    fun createApiService(): ApiService {
        val gson = GsonBuilder().setLenient().create()
        val httpCacheDirectory = File(cacheDir, "cache_file")
        val cache = Cache(httpCacheDirectory, 20 * 1024 * 1024)

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .connectionPool(ConnectionPool(0, 5 * 60 * 1000, TimeUnit.SECONDS))
            .addInterceptor(CustomInterceptor(getInstance(), Locale.getDefault().language, "1"))
            .cache(cache)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiService = retrofit.create(ApiService::class.java)
        return apiService!!
    }

    fun getApiService(): ApiService? {
        return apiService
    }

}