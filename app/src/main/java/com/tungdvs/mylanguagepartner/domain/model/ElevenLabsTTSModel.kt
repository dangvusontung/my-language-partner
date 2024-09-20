package com.tungdvs.mylanguagepartner.domain.model

data class ElevenLabsTTSModel(
    val modelId: String,
    val name: String,
    val description: String,
    val languages: List<ModelLanguage>
)
