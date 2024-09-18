package com.tungdvs.mylanguagepartner.network.openai

import com.tungdvs.mylanguagepartner.base.APIClient

object OpenAIClient: APIClient() {
    override val baseURL: String
        get() = "https://api.openai.com/v1/"
    override val apiKey: String
        get() = System.getenv("OPENAI_API_KEY") ?: ""
}
