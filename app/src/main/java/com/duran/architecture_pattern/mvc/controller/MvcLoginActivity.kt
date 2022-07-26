package com.duran.architecture_pattern.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.duran.architecture_pattern.R
import com.duran.architecture_pattern.databinding.ActivityMvcLoginBinding
import com.duran.architecture_pattern.mvc.model.User

/*
MVC(Model View Controller)

M(Model) : 모델은 데이터와 비즈니스 로직이라고 불리는 앱의 UI와 관계없는 부분을 담당, 앱의 두뇌라고 볼 수 있다.

V(View) : 사용자에게 보여지는 UI화면, model의 데이터를 표시하거나 controller로 부터 갱신처리 받아들이는 UI로직을 가진다.
          android App에서는 xml레이아웃이 view에 해당하게 된다.

C(Controller) : view와 model사이에서 상호작용을 관리하는 control towel.
                외부에서 전달받은 입력을 처리해서 view의 내용을 갱신하고 표시할 view를 선택 후 화면그리기를 요청하는 presentation로직을 가지고있다.

MVC Pattern 특징
1. MVC패턴에서는 Model과 View가 완전히 분리되므로 Model은 쉽게 테스트 가능
2. Controller가 안드로이드에 종속되기 때문에 테스트가 어려워진다.
3. 안드로이드 특성상 액티비티가 View표시와 Controller역할을 같이 수행해야 하기 때문에 두 요소의 결합도가 높아진다.
4. 많은 코드가 Controller로 모이게 되어 액티비티가 비대해진다. -> Unit테스트나 기능추가가 용이하지 않게 된다...

 -> 이러한 문제를 극복하기 위해 MVP 패턴이 등장

 */

class MvcLoginActivity : AppCompatActivity() {
    private val binding: ActivityMvcLoginBinding by lazy {
        ActivityMvcLoginBinding.inflate(layoutInflater)
    }
    private lateinit var user : User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 처리
        setContentView(binding.root)

        user = User()

        // 프레젠테이션 로직
        binding.included.loginBtn.setOnClickListener {
            val isLoginSuccessful = user.login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString(),
            )

            if (isLoginSuccessful) {
                Toast.makeText(this@MvcLoginActivity, "${user.userName} Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MvcLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}