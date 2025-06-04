package com.warting.bubbles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatBubblesTheme {
                var messages by remember { 
                    mutableStateOf(
                        listOf(
                            ChatMessage("Hello bubbles!", false),
                            ChatMessage("Welcome to the modernized chat bubbles example!", false),
                            ChatMessage("This uses Jetpack Compose with no PNG images!", false),
                            ChatMessage("Try typing a message below.", false)
                        )
                    ) 
                }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(R.string.app_name)) }
                        )
                    }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ChatScreen(
                            messages = messages,
                            onSendMessage = { messageText ->
                                messages = messages + ChatMessage(
                                    text = messageText,
                                    isFromUser = true
                                )
                                
                                // Simulate a response after a short delay
                                // In a real app, this would be handled differently
                                val responses = listOf(
                                    "That's interesting!",
                                    "Tell me more about that.",
                                    "I see what you mean.",
                                    "Thanks for sharing!",
                                    "Cool! 😊"
                                )
                                val response = responses.random()
                                messages = messages + ChatMessage(
                                    text = response,
                                    isFromUser = false
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ChatBubblesTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChatBubblesTheme {
        ChatScreen(
            messages = listOf(
                ChatMessage("Hello bubbles!", false),
                ChatMessage("Hi there!", true)
            ),
            onSendMessage = { }
        )
    }
}