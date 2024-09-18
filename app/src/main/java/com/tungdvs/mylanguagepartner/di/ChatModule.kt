package com.tungdvs.mylanguagepartner.di

import com.tungdvs.mylanguagepartner.data.repositories.ChatRepositoryImpl
import com.tungdvs.mylanguagepartner.domain.repositories.ChatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ChatModule {
    @Binds
    abstract fun bindChatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository
}