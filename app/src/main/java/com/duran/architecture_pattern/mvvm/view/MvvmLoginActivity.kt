package com.duran.architecture_pattern.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.duran.architecture_pattern.databinding.ActivityMvvmLoginBinding
import com.duran.architecture_pattern.mvvm.viewmodel.LoginViewModel

/*
MVVM(Model View ViewModel)

M(Model) : MVC의 Model과 동일한 역할,
           모델은 데이터와 비즈니스 로직이라고 불리는 앱의 UI와 관계없는 부분을 담당, 앱의 두뇌라고 볼 수 있다.

V(ViewModel) : viewModel은 View를 만드는데 필요한 로직을 가지고 있는 model이기 때문에 viewModel이라는 이름이 붙었다.
               viewModel은 view를 참조하지 않기 때문에 viewModel과 view가 1:n관계를 가지게 되고 따라서
               중복되는 코드를 viewModel에 묶어서 줄일수도 있게 되었다.

V(View) : 사용자에게 보여지는 UI파트
          데이터 바인딩을 통해서 viewModel로부터 일방적으로 통지받은 데이터를 표시하는 역할만을 한다.
          viewModel은 view를 참조하지 않지만 view의 바인딩을 Observer 데이터를 가지고 있기 때문에
          view가 이를 옵저빙 함으로써 UI를 갱신할 수 있다.

MVVM Pattern의 특징
1. view와 model사이에 의존성이 없으며, viewModel도 view에 의존성을 가지지 않는다.
2. 참조는 view > viewModel > model 순으로 단방향으로만 일어나기 때문에 유지보수가 용이하다.
*/

class MvvmLoginActivity : AppCompatActivity() {
    private val binding: ActivityMvvmLoginBinding by lazy {
        ActivityMvvmLoginBinding.inflate(layoutInflater)
    }
    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.included.loginBtn.setOnClickListener {
            loginViewModel.login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString()
            )
        }
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.isLoginSuccessfulFlag.observe(this, loginObserver)
    }

    // 데이터 바인딩
    private val loginObserver = Observer<Boolean> { isLoginSuccessful ->
        if (isLoginSuccessful) {
            Toast.makeText(
                this@MvvmLoginActivity, loginViewModel.userName + " Login Successful",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(this@MvvmLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}