package com.duran.architecture_pattern.bare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.duran.architecture_pattern.databinding.ActivityBareLoginBinding

// 어떠한 패턴도 없는 경우
// 혼돈의 카오스이다..... 레이아웃, 데이터 취득, 이벤트처리, 로직판정 등등 엑티비티 안에서 모든걸 처리하고 있다
// 앱이 동작하기는 하지만 코드가 뒤죽박죽이라 흐름 파악하기도 어려울 뿐더러 기능 추가나 테스트 조차도 기대할 수 없다....

class BareLoginActivity : AppCompatActivity() {
    private val binding: ActivityBareLoginBinding by lazy {
        ActivityBareLoginBinding.inflate(layoutInflater)
    }

    var userName: String? = null
    var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 처리
        setContentView(binding.root)

        binding.included.loginBtn.setOnClickListener {

            // 데이터 취득
            val isLoginSuccessful = login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString(),
            )

            // 이벤트 처리
            if (isLoginSuccessful) {
                Toast.makeText(this@BareLoginActivity, "$userName Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@BareLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 로직 판정
    fun login(userName: String?, password: String?): Boolean {
        if (userName == secretName && password == secretWord) {
            this.userName = userName
            this.password = password
            return true
        }
        return false
    }

    companion object {
        const val secretName = "user"
        const val secretWord = "1234"
    }
}