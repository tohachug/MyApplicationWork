package com.example.myapplicationwork

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket


object ConnectionChecker {
    fun isOnline(): Boolean {
        return try {
            Socket().run {
                connect(InetSocketAddress("8.8.8.8", 53), 500)
                close()
            }
            true
        } catch (e: IOException) {
            false
        }
    }
}