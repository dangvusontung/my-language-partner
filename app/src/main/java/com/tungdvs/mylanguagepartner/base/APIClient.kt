package com.tungdvs.mylanguagepartner.base

import com.tungdvs.mylanguagepartner.network.openai.OpenAIClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class APIClient {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    abstract val baseURL: String
    abstract val apiKey: String

    private fun provideHeaderLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }

    private fun provideBodyLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request().newBuilder()
                .header("Authorization", "Bearer $apiKey")
                .header("Content-Type", "application/json")
                .method(it.request().method, it.request().body)
                .build()
            return@addInterceptor it.proceed(request)
        }
        .addInterceptor(provideHeaderLogging())
        .addInterceptor(provideBodyLogging())
        .build()
}