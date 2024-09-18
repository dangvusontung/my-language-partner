package com.tungdvs.mylanguagepartner.data.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ElevenLabTTSRequestModel(
    @SerialName("text")
    val text: String,
    @SerialName("model_id")
    val modelId: String,
)
