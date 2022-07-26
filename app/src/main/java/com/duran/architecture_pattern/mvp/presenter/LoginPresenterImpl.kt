package com.duran.architecture_pattern.mvp.presenter

import com.duran.architecture_pattern.mvp.model.User
import com.duran.architecture_pattern.mvp.view.MvpLoginView

class LoginPresenterImpl(
    private val mvpLoginView: MvpLoginView
) : LoginPresenter {

    override val user: User
        get() = User()

    override fun login() {
        val userName = mvpLoginView.userName.toString()
        val password = mvpLoginView.password.toString()
        val isLoginSuccessful: Boolean = user.login(userName, password)

        mvpLoginView.onLoginResult(isLoginSuccessful)
    }
}