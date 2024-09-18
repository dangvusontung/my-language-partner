package com.tungdvs.mylanguagepartner.domain.usecase

import com.tungdvs.mylanguagepartner.base.UseCase
import com.tungdvs.mylanguagepartner.di.factory.TextToSpeechAPIFactory
import javax.inject.Inject

enum class SpeechProvider {
    OPEN_AI, ELEVEN_LABS
}

class GenerateSpeechUseCaseInput(
    val content: String,
    val provider: SpeechProvider
)

class GenerateSpeechUseCase @Inject constructor(
    private val factory: TextToSpeechAPIFactory
) : UseCase<GenerateSpeechUseCaseInput, ByteArray>() {
    override suspend fun execute(input: GenerateSpeechUseCaseInput): ByteArray {
       return factory.createTextToSpeechAPI(input.provider).textToSpeech(input.content)
    }
}