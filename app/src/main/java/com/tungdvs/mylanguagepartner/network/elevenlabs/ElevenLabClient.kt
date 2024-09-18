package com.tungdvs.mylanguagepartner.network.elevenlabs

import com.tungdvs.mylanguagepartner.base.APIClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ElevenLabClient: APIClient() {
    override val baseURL: String
        get() = "https://api.eleven-labs.io/v1/"
    override val apiKey: String
        get() = System.getenv("ELEVENLABS_API_KEY") ?: ""
}