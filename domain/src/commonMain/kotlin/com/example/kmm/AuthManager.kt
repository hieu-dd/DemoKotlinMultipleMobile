package com.example.kmm

import com.example.kmm.data.Dummy.users

data class AuthManager(val context: KContext) {
    fun login(userName: String, password: String): Boolean {
        return (users[userName] == password).also {
            LocalData(context).setBoolean("isLogin", true)
        }
    }

    fun isLogin() = LocalData(context).getBoolean("isLogin")
}