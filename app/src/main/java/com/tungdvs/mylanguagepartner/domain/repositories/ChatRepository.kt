package com.tungdvs.mylanguagepartner.domain.repositories

import com.tungdvs.mylanguagepartner.domain.model.Message

interface ChatRepository {
    suspend fun sendMessage(model: String, content: String, listMessage: List<Message>): Message

    suspend fun textToSpeech(text: String): ByteArray
}