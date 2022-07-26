package com.duran.architecture_pattern.mvp.view

interface MvpLoginView {
    val userName: String?
    val password: String?

    fun onLoginResult(isLoginSuccess: Boolean?)
}