package com.tungdvs.mylanguagepartner.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tungdvs.mylanguagepartner.presentation.chat.MessageListView

@Composable
fun MainView(navController: NavHostController) {
   MessageListView()
}

