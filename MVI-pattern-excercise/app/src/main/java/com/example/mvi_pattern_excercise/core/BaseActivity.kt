package com.example.mvi_pattern_excercise.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseActivity<VB : ViewBinding>(
    private val bindingClass: KClass<VB>
) : AppCompatActivity() {

    // ViewBinding 객체
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화 및 설정
        val method = bindingClass.java.getMethod("inflate", android.view.LayoutInflater::class.java)
        _binding = method.invoke(null, layoutInflater) as VB
        setContentView(binding.root)

        // 기본적인 초기화 함수 호출
        initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null  // 메모리 누수 방지
    }

    /**
     * 초기화 로직을 서브클래스에서 구현
     */
    abstract fun initialize()
}