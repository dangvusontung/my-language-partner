package com.tungdvs.mylanguagepartner.domain.repositories

import com.tungdvs.mylanguagepartner.domain.model.ElevenLabsTTSModel
import com.tungdvs.mylanguagepartner.domain.model.Voice
import java.io.InputStream

abstract class ElevenLabRepository {
    abstract suspend fun getModels(): List<ElevenLabsTTSModel>
    abstract suspend fun getVoices(): List<Voice>
    abstract suspend fun textToSpeech(text: String, voiceId: String): ByteArray
}