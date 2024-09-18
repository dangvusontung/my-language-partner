package com.tungdvs.mylanguagepartner.domain.model

enum class Role(val value: Int) {
    ASSISTANT(0),
    USER(1),
    SYSTEM(2);


    fun toInt() = value

    fun requestValue(): String = name.lowercase()

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}

enum class OpenAIModel {
    GPT4o,
    GPT4oMini,
    GPT4o240806,
    O1Preview,
    O1Mini,
    GPT4Turbo,
    TTS1,
    TTS1HD;

    fun requestValue(): String = when (this) {
        GPT4o -> "gpt-4o"
        GPT4oMini -> "gpt-4o-mini"
        GPT4o240806 -> "gpt-4o-2024-08-06"
        O1Preview -> "o1-preview"
        O1Mini -> "o1-mini"
        GPT4Turbo -> "gpt-4.0-turbo"
        TTS1 -> "tts-1"
        TTS1HD -> "tts-1-hd"
    }
}

class Message(
    val content: String,
    val role: Role,
    val timestamp: Long
)

