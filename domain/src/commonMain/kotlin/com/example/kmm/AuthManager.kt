package com.example.kmm

import com.example.kmm.data.Dummy.users

data class AuthManager(val context: KContext) {
    fun login(
        userName: String,
        password: String,
        rememberMe: Boolean = false
    ): Boolean {
        return (users[userName] == password).also {
            if (rememberMe) {
                LocalData(context).setBoolean("isLogin", true)
            }
        }
    }

    fun isLogin() = LocalData(context).getBoolean("isLogin")
}