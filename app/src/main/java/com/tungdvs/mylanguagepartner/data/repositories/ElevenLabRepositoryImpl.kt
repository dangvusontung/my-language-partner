package com.tungdvs.mylanguagepartner.data.repositories

import com.tungdvs.mylanguagepartner.domain.model.Voice
import com.tungdvs.mylanguagepartner.domain.repositories.ElevenLabRepository
import com.tungdvs.mylanguagepartner.network.elevenlabs.ElevenLabsService
import javax.inject.Inject

class ElevenLabRepositoryImpl @Inject constructor(
    private val elevenLabService: ElevenLabsService
): ElevenLabRepository() {


    override suspend fun getVoices(): List<Voice> {

    }

    override suspend fun textToSpeech(text: String, voiceId: String): ByteArray {
        TODO("Not yet implemented")
    }
}