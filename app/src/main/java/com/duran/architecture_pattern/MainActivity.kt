package com.duran.architecture_pattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.duran.architecture_pattern.bare.BareLoginActivity
import com.duran.architecture_pattern.databinding.ActivityMainBinding
import com.duran.architecture_pattern.mvc.controller.MvcLoginActivity
import com.duran.architecture_pattern.mvp.view.MvpLoginActivity
import com.duran.architecture_pattern.mvvm.view.MvvmLoginActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bareBtn.setOnClickListener(this)
        binding.mvcBtn.setOnClickListener(this)
        binding.mvpBtn.setOnClickListener(this)
        binding.mvvmBtn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bare_btn -> {
                val bareIntent = Intent(this, BareLoginActivity::class.java)
                startActivity(bareIntent)
            }

            R.id.mvc_btn -> {
                val mvcIntent = Intent(this, MvcLoginActivity::class.java)
                startActivity(mvcIntent)
            }
            R.id.mvp_btn -> {
                val mvpIntent = Intent(this, MvpLoginActivity::class.java)
                startActivity(mvpIntent)
            }
            R.id.mvvm_btn -> {
                val mvvmIntent = Intent(this, MvvmLoginActivity::class.java)
                startActivity(mvvmIntent)
            }
            else -> {}
        }
    }
}
