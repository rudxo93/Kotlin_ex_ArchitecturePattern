package com.duran.architecture_pattern.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.duran.architecture_pattern.databinding.ActivityMvpLoginBinding
import com.duran.architecture_pattern.mvp.presenter.LoginPresenterImpl

/*
MVC패턴의 문제를 극복하기 위해 MVP패턴이 등장

MVP(Model View Presenter)

M(Model) : MVC와 동일하지만 View와 직접적인 의존성이 사라지고 Presenter가 중간에서 관리한다.
           본질적으로 MVC의 controller와 같은 역할을 하지만 view의 참조를 직접 거치지 않고
           interface를 통해 교신하기 때문에 결합이 상대적으로 느슨해진다.
           controller와 달리 android의존성을 가지지 않기 때문에 text도 용이해진다.

V(View) : MVC에서 view와 controller를 겸하고 있었던 activity, fragment가 MVP에서는 온전한 view로 간주된다.
          model참조가 없어진 대신 presenter의 참조가 생겼다.

P(Presenter) : view와 model의 참조를 가져서 view로부터 action을 전달받고 필요한 경우에는 model로부터 데이터를 취득해서
               그 결과를 view에 전달

MVP Pattern의 특징
1. view와 model사이의 데이터흐름이 사라지고 presenter가 중간에서 데이터 흐름을 제어
2. interface를 추가로 구현해야 하기 때문에 구현비용이 올라가게 된다.
3. view와 presenter가 1:1로 대응해야 하기 때문에, 앱이 커질수록 두 요소의 의존성이 강해지게 된다.
*/

class MvpLoginActivity : AppCompatActivity(), MvpLoginView {
    private val binding: ActivityMvpLoginBinding by lazy {
        ActivityMvpLoginBinding.inflate(layoutInflater)
    }
    private lateinit var loginPresenterImpl: LoginPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loginPresenterImpl = LoginPresenterImpl(this)
        binding.included.loginBtn.setOnClickListener { loginPresenterImpl.login() }
    }

    override val userName: String
        get() = binding.included.etUserName.text.toString()
    override val password: String
        get() = binding.included.etPassword.text.toString()

    override fun onLoginResult(isLoginSuccess: Boolean?) {
        if (isLoginSuccess == true) {
            Toast.makeText(this@MvpLoginActivity, "$userName Login Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MvpLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}