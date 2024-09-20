package com.tungdvs.mylanguagepartner.data.mappers

import com.tungdvs.mylanguagepartner.data.models.request.elevenlabs.VoiceLanguageModel
import com.tungdvs.mylanguagepartner.data.models.request.elevenlabs.VoiceModel
import com.tungdvs.mylanguagepartner.data.models.response.ElevenLabModel
import com.tungdvs.mylanguagepartner.domain.model.ElevenLabsTTSModel
import com.tungdvs.mylanguagepartner.domain.model.ModelLanguage
import com.tungdvs.mylanguagepartner.domain.model.Voice

fun ElevenLabsTTSModel.toModel() = ElevenLabModel(
    modelId = modelId,
    name = name,
    description = description,
    languages = languages.map { it.toModel() }
)

fun ElevenLabModel.toDomain() = ElevenLabsTTSModel(
    modelId = modelId,
    name = name,
    description = description,
    languages = languages.map { it.toDomain() }
)

fun VoiceLanguageModel.toDomain() = ModelLanguage(
    languageId = languageId,
    name = name
)

fun ModelLanguage.toModel() = VoiceLanguageModel(
    languageId = languageId,
    name = name
)

fun VoiceModel.toDomain() = Voice(
    voiceId = modelId,
    name = name
)

fun Voice.toModel() = VoiceModel(
    modelId = voiceId,
    name = name
)

