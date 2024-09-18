package com.tungdvs.mylanguagepartner.presentation.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tungdvs.mylanguagepartner.presentation.chat.viewmodel.ChatViewModel
import kotlinx.coroutines.launch
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MessageListView(viewModel: ChatViewModel = hiltViewModel()) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            if (viewModel.messages.isEmpty()) {
                // Empty state view
                Text(
                    text = "Start conversation",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            } else {
                // Message list
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    reverseLayout = true
                ) {
                    items(viewModel.messages.asReversed()) { message ->
                        MessageRow(message)
                    }
                }
            }
        }

        // ChatInput pinned at the bottom
        ChatInput(
            content = viewModel.currentMessage,
            onContentChange = { viewModel.updateCurrentMessage(it) },
            onSend = {
                coroutineScope.launch {
                    viewModel.sendMessage()
                }
            },
            enableSendButton = viewModel.enableSendButton
        )
    }
}