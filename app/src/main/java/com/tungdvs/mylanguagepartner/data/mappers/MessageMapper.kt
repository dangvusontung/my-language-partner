package com.tungdvs.mylanguagepartner.data.mappers

import com.tungdvs.mylanguagepartner.data.models.MessageModel
import com.tungdvs.mylanguagepartner.data.models.request.openai.OpenAIMessage
import com.tungdvs.mylanguagepartner.domain.model.Message
import com.tungdvs.mylanguagepartner.domain.model.Role

fun Message.toEntity(): MessageModel = MessageModel().apply {
    this.content = content
    this.role = role
    this.timestamp = timestamp
}

fun MessageModel.toDomain(): Message = Message(
    content = content,
    role = Role.fromInt(role),
    timestamp = timestamp
)

fun Message.toOpenAIMessage(): OpenAIMessage = OpenAIMessage(
    content = content,
    role = role.requestValue()
)