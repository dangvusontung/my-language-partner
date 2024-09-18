package com.tungdvs.mylanguagepartner.network.openai

import com.tungdvs.mylanguagepartner.base.APIService
import com.tungdvs.mylanguagepartner.data.models.request.openai.ChatCompletionRequest
import com.tungdvs.mylanguagepartner.data.models.request.openai.TextToSpeechRequest
import com.tungdvs.mylanguagepartner.data.models.response.ChatCompletionResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAIService: APIService {
    @POST("chat/completions")
    suspend fun chatCompletion(
        @Body request: ChatCompletionRequest
    ): ChatCompletionResponse

    @POST("audio/speech")
    suspend fun generateSpeech(
        @Body request: TextToSpeechRequest
    ): Call<ResponseBody>
}