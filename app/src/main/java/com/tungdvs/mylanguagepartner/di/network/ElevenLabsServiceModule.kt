package com.tungdvs.mylanguagepartner.di.network

import com.tungdvs.mylanguagepartner.network.elevenlabs.ElevenLabClient
import com.tungdvs.mylanguagepartner.network.elevenlabs.ElevenLabsService
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
object ElevenLabsServiceModule {
    @Singleton
    @Provides
    fun provideElevenLabsService(): ElevenLabsService {
        return ElevenLabClient.retrofit.create(ElevenLabsService::class.java)
    }
}