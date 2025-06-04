# Android Chat Bubbles

A modern Android chat application example built with **Jetpack Compose** that demonstrates how to create chat bubbles without using PNG images.

## Features

- **Modern UI**: Built entirely with Jetpack Compose
- **No PNG Images**: Chat bubbles are drawn programmatically using Compose shapes
- **Material 3 Design**: Follows the latest Material Design guidelines
- **Responsive Layout**: Adaptive chat bubble positioning based on sender
- **State Management**: Uses Compose state management for messages
- **Auto-scroll**: Automatically scrolls to new messages

## Architecture

This project has been modernized from the original Java/XML implementation to use:

- **Jetpack Compose** instead of XML layouts and ListView
- **Kotlin data classes** instead of Java POJOs
- **LazyColumn** for efficient scrolling instead of ListView
- **Programmatic shapes** instead of PNG drawable resources
- **Modern Android project structure** with Gradle

## Key Components

### ChatMessage.kt
Data class representing a chat message with text content and sender information.

### ChatBubble.kt
Composable that renders individual chat bubbles with:
- Dynamic positioning (left/right based on sender)
- Programmatically drawn rounded corners
- Material 3 color theming
- No dependency on PNG resources

### ChatScreen.kt
Main chat interface composable featuring:
- LazyColumn for message list
- Text input with send button
- Auto-scroll to latest messages
- Material 3 design components

### MainActivity.kt
Main activity using Compose with:
- State management for message list
- Simulated chat responses
- Modern Compose theming

## Building the Project

1. Open the project in Android Studio
2. Sync the project to download dependencies
3. Run the app on an emulator or device

## Requirements

- Android Studio Arctic Fox or later
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 33
- Kotlin 1.8.10+
- Jetpack Compose BOM 2023.05.01

## What's New

This modernized version replaces:
- ❌ ListView → ✅ LazyColumn
- ❌ PNG bubble images → ✅ Compose shapes
- ❌ XML layouts → ✅ Jetpack Compose
- ❌ Java → ✅ Kotlin
- ❌ Eclipse project structure → ✅ Modern Gradle structure
- ❌ Custom ArrayAdapter → ✅ Compose state management

The result is a cleaner, more maintainable, and more performant chat application that showcases modern Android development practices.