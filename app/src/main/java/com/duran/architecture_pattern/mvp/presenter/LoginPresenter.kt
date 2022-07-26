package com.duran.architecture_pattern.mvp.presenter

import com.duran.architecture_pattern.mvp.model.User

interface LoginPresenter {
    val user: User

    fun login()
}