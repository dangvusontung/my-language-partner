package com.tungdvs.mylanguagepartner.data.models.request.elevenlabs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoiceLanguageModel(
    @SerialName("language_id")
    val languageId: String,
    val name: String
)
