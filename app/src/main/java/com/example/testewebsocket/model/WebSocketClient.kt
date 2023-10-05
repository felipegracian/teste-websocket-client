package com.example.testewebsocket.model

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket

class WebSocketClient(private val url: String) {

    private val client = OkHttpClient()
    private var webSocket: WebSocket? = null

    fun connect() {
        val request = Request.Builder().url(url).build()
        client.newWebSocket(request, WebSocketListener())
    }

    fun disconnect() {
        webSocket?.close(1000, null)
    }

    fun send(message: String) {
        webSocket?.send(message)
    }

    inner class WebSocketListener : okhttp3.WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            // A conexão foi aberta com sucesso
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            // Recebeu uma mensagem do servidor WebSocket
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            // A conexão foi fechada
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            // Ocorreu uma falha na conexão WebSocket
        }
    }

}