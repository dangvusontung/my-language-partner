package com.tungdvs.mylanguagepartner.data.models.request.elevenlabs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoiceModel(
    @SerialName("model_id")
    val modelId: String,
    val name: String,
)
