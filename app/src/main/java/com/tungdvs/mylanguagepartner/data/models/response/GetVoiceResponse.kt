package com.tungdvs.mylanguagepartner.data.models.response

import com.tungdvs.mylanguagepartner.data.models.request.elevenlabs.VoiceModel
import kotlinx.serialization.Serializable

@Serializable
data class GetVoiceResponse(
    val voices: List<VoiceModel>
)
