package com.tungdvs.mylanguagepartner.di.factory

import com.tungdvs.mylanguagepartner.domain.usecase.SpeechProvider

interface TextToSpeechAPI {
    suspend fun textToSpeech(text: String): ByteArray
}

class TextToSpeechAPIFactory {
    fun createTextToSpeechAPI(
        provider: SpeechProvider
    ): TextToSpeechAPI {
        return when (provider) {
            SpeechProvider.OPEN_AI -> OpenAITextToSpeechAPI()
            SpeechProvider.ELEVEN_LABS -> ElevenLabsTextToSpeechAPI()
        }
    }
}

class OpenAITextToSpeechAPI : TextToSpeechAPI {
    override suspend fun textToSpeech(text: String): ByteArray {
        // Call OpenAI API to generate speech
        return byteArrayOf()
    }
}

class ElevenLabsTextToSpeechAPI : TextToSpeechAPI {
    override suspend fun textToSpeech(text: String): ByteArray {
        // Call Eleven Labs API to generate speech
        return byteArrayOf()
    }
}