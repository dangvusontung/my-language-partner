package com.tungdvs.mylanguagepartner.data.models.request.openai

import kotlinx.serialization.Serializable

@Serializable
data class ChatCompletionRequest(val model: String, val messages: List<OpenAIMessage>)