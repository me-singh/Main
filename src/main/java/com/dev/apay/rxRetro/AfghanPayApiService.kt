package com.dev.apay.rxRetro

import android.util.Log
import com.dev.apay.utils.GlobalConstants
import com.google.gson.JsonObject
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

/**
 * @author pankaj
 */
interface AfghanPayApiService {

    @POST(GlobalConstants.LoginURL)
    fun initLoginRequest(): Observable<JsonObject>

    @POST(GlobalConstants.VerifyOTPURL)
    fun initVerifyOTPRequest(): Observable<JsonObject>

    @POST(GlobalConstants.RegisterURL)
    fun initRegisterRequest(): Observable<JsonObject>

    companion object {
        private val TAG: String = "AfghanPayApiService"
        fun create(): AfghanPayApiService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .baseUrl(GlobalConstants.BaseURL)
                    .build()
            Log.i(TAG, "Creating retro object")
            return retrofit.create(AfghanPayApiService::class.java)
        }

        private fun getOkHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .build()
        }
    }
}