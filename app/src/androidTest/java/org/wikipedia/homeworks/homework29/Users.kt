package org.wikipedia.homeworks.homework29

import org.wikipedia.BuildConfig

object Users {
    val alphaLogin = "alphaLogin"
    val betaLogin = "betaLogin"
    val blaLogin = "blaLogin"
}

object Credentials {
    private val map = mapOf(
        Users.alphaLogin to BuildConfig.alphaLogin,
        Users.betaLogin to BuildConfig.betaLogin,
        Users.blaLogin to BuildConfig.blaLogin
    )

    fun getPassword(user: String) : String {
        return map.getOrElse(user) {
            throw IllegalArgumentException("User does not exist")
        }
    }
}