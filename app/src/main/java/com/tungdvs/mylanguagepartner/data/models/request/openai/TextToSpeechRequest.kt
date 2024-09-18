package com.tungdvs.mylanguagepartner.data.models.request.openai

import com.tungdvs.mylanguagepartner.domain.model.OpenAIModel
import kotlinx.serialization.Serializable

@Serializable
data class TextToSpeechRequest(
    val model: OpenAIModel,
    val input: String,
    val voice: OpenAIVoice,
    val audioOutputFormat: AudioOutputFormat,
    val speed: Double = 1.0,
)

enum class OpenAIVoice {
    ALLOY, ECHO, FABLE, ONYX, NOVA, SHIMMER;
    fun requestValue(): String = name.lowercase()
}

enum class AudioOutputFormat {
    MP3, OPUS, AAC, FLAC, WAV, PCM;
    fun requestValue(): String = name.lowercase()
}