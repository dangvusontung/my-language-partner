package com.tungdvs.mylanguagepartner.presentation.chat.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.tungdvs.mylanguagepartner.domain.model.Message
import com.tungdvs.mylanguagepartner.domain.model.OpenAIModel
import com.tungdvs.mylanguagepartner.domain.model.Role
import com.tungdvs.mylanguagepartner.domain.usecase.SendMessageInput
import com.tungdvs.mylanguagepartner.domain.usecase.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase
): ViewModel() {

    private val _messages = mutableStateListOf<Message>()
    val messages: List<Message> = _messages
    private var _currentMessage = mutableStateOf("")

    var currentMessage: String
        get() = _currentMessage.value
        set(value) {
            _currentMessage.value = value
        }


    private var _selectedModel = mutableStateOf(OpenAIModel.GPT4oMini)

    private var _enableSendButton = mutableStateOf(true)

    var enableSendButton: Boolean = _enableSendButton.value

    var selectedModel: OpenAIModel
        get() = _selectedModel.value
        set(value) {
            _selectedModel.value = value
        }

    suspend fun sendMessage() {
        _enableSendButton.value = false
        val message = Message(
            role = Role.USER,
            content = currentMessage,
            timestamp = System.currentTimeMillis()
        )

        val input = SendMessageInput(
            model = selectedModel.requestValue(),
            content = currentMessage,
            listMessage = _messages
        )

        coroutineScope {
            try {
                val newUserMessage = Message(
                    role = Role.USER,
                    content = currentMessage,
                    timestamp = System.currentTimeMillis()
                )
                _messages.add(newUserMessage)
                _currentMessage.value = ""
                val newMessage = sendMessageUseCase.execute(input)
                _enableSendButton.value = true
                _messages.add(newMessage)
            } catch (e: Exception) {
                _enableSendButton.value = true
                e.printStackTrace()
            }
        }
    }

    fun updateCurrentMessage(message: String) {
        currentMessage = message
    }
}