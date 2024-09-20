package com.tungdvs.mylanguagepartner.data.models.response

import com.tungdvs.mylanguagepartner.data.models.request.elevenlabs.VoiceLanguageModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ElevenLabModel(
    @SerialName("model_id")
    val modelId: String,
    val name: String,
    val description: String,
    val languages: List<VoiceLanguageModel>
)
