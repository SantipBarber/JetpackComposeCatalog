package com.freelosophy.jetpackcomposecatalog.data.repositories

import com.freelosophy.jetpackcomposecatalog.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}