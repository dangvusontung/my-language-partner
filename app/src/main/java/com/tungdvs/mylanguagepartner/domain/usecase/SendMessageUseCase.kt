package com.tungdvs.mylanguagepartner.domain.usecase

import com.tungdvs.mylanguagepartner.base.UseCase
import com.tungdvs.mylanguagepartner.domain.model.Message
import com.tungdvs.mylanguagepartner.domain.repositories.ChatRepository
import javax.inject.Inject

class SendMessageInput(
    val model: String,
    val content: String,
    val listMessage: List<Message>
)

class SendMessageUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) : UseCase<SendMessageInput, Message>() {
    override suspend fun execute(input: SendMessageInput): Message =
        chatRepository.sendMessage(input.model, input.content, input.listMessage)
}