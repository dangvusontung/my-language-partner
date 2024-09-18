package com.tungdvs.mylanguagepartner.di.network

import com.tungdvs.mylanguagepartner.network.openai.OpenAIClient
import com.tungdvs.mylanguagepartner.network.openai.OpenAIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OpenAIServiceModule {
    @Singleton
    @Provides
    fun provideOpenAIService(): OpenAIService {
        return OpenAIClient.retrofit.create(OpenAIService::class.java)
    }
}