package com.tungdvs.mylanguagepartner.network.elevenlabs

import com.tungdvs.mylanguagepartner.data.models.response.ElevenLabModel
import com.tungdvs.mylanguagepartner.data.models.response.GetVoiceResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ElevenLabsService {

    @GET("models")
    suspend fun getModels(): List<ElevenLabModel>

    @GET("voices")
    suspend fun getVoices(): GetVoiceResponse

    @POST("text-to-speech/{voice_id}")
    suspend fun textToSpeech(
        @Path("voice_id") voiceId: String,
        @Query("enable_logging") enableLogging: Boolean? = null,
        @Query("output_format") outputFormat: String? = null,
        @Body request: ElevenLabTextToSpeechRequest
    ): ByteArray

    @POST("text-to-speech/{voice_id}/with-timestamp")
    suspend fun textToSpeechWithTimestamp(
        @Path("voice_id") voiceId: String,
        @Query("enable_logging") enableLogging: Boolean? = null,
        @Query("output_format") outputFormat: String? = null,
        @Body request: ElevenLabTextToSpeechRequest
    ): ByteArray

    @POST("text-to-speech/{voice_id}/stream")
    suspend fun textToSpeechStreaming(
        @Path("voice_id") voiceId: String,
        @Query("enable_logging") enableLogging: Boolean? = null,
        @Query("output_format") outputFormat: String? = null,
        @Body request: ElevenLabTextToSpeechRequest
    ): ByteArray

    // stream with timestamp
    @POST("text-to-speech/{voice_id}/stream/with-timestamp")
    suspend fun textToSpeechStreamingWithTimestamp(
        @Path("voice_id") voiceId: String,
        @Query("enable_logging") enableLogging: Boolean? = null,
        @Query("output_format") outputFormat: String? = null,
        @Body request: ElevenLabTextToSpeechRequest
    ): ByteArray
}

@Serializable
class ElevenLabTextToSpeechRequest(
    val text: String,
    @SerialName("model_id")
    val modelId: String,
    @SerialName("language_code")
    val languageCode: String?,
)