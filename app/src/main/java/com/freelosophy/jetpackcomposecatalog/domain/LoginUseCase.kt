package com.freelosophy.jetpackcomposecatalog.domain

import com.freelosophy.jetpackcomposecatalog.data.repositories.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}