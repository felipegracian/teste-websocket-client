package com.example.testewebsocket.model

import androidx.lifecycle.ViewModel

class WebSocketViewModel: ViewModel() {
    private val webSocketClient = WebSocketClient("wss://10.107.144.19:3000")

    init {
        webSocketClient.connect()
    }

    fun sendMessage(message: String) {
        webSocketClient.send(message)
    }

    override fun onCleared() {
        webSocketClient.disconnect()
    }
}