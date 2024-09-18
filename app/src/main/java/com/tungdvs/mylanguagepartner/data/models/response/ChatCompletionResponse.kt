package com.tungdvs.mylanguagepartner.data.models.response

import com.tungdvs.mylanguagepartner.data.models.request.openai.OpenAIMessage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatCompletionResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<Choice>
)

@Serializable
data class Choice(
    val index: Int,
    val logprobs: Boolean?,
    @SerialName("finish_reason")
    val finishReason: String,
    val message: OpenAIMessage,
)