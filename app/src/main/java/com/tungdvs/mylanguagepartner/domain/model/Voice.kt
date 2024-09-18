package com.tungdvs.mylanguagepartner.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Voice(
    @SerialName("voice_id")
    val voiceId: String,
    val name: String,
)
