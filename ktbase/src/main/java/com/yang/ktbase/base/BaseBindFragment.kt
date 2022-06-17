package com.yang.ktbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.yang.ktbase.ext.getVmClazz
import com.yang.ktbase.ext.inflateBindingWithGeneric

abstract class BaseBindFragment<B : ViewBinding> : Fragment() {

    private var _binding: B? = null

    protected val binding: B get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBindingWithGeneric(inflater, container, false)
        return binding.root
    }

    /**
     * 初始化布局
     */
    abstract fun initView(savedInstanceState: Bundle?)


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}