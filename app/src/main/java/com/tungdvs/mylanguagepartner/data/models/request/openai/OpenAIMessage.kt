package com.tungdvs.mylanguagepartner.data.models.request.openai

import kotlinx.serialization.Serializable

@Serializable
data class OpenAIMessage(val content: String, val role: String)
