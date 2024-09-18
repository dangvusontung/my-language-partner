package com.tungdvs.mylanguagepartner.data.repositories

import com.tungdvs.mylanguagepartner.data.mappers.toOpenAIMessage
import com.tungdvs.mylanguagepartner.data.models.request.openai.ChatCompletionRequest
import com.tungdvs.mylanguagepartner.domain.model.Message
import com.tungdvs.mylanguagepartner.domain.model.Role
import com.tungdvs.mylanguagepartner.domain.repositories.ChatRepository
import com.tungdvs.mylanguagepartner.network.openai.OpenAIService
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val openAIService: OpenAIService
) : ChatRepository {

    override suspend fun sendMessage(model: String, content: String, listMessage: List<Message>): Message {
        val request = ChatCompletionRequest(
            model = model,
            messages = listMessage.map {
                it.toOpenAIMessage()
            }
        )
        try {
            val response = openAIService.chatCompletion(request)
            return Message(
                content = response.choices.first().message.content,
                role = Role.ASSISTANT,
                timestamp = System.currentTimeMillis()
            )

        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun textToSpeech(text: String): ByteArray {
        throw NotImplementedError()
    }
}