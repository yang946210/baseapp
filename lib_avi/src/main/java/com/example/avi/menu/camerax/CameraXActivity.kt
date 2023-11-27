package com.example.avi.menu.camerax

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import com.example.lib_avi.databinding.ActivityCameraXactivityBinding
import com.tbruyelle.rxpermissions3.RxPermissions
import com.yang.ktbase.base.BaseBindActivity
import java.io.File


val note="""
    1.Surface(填充图像数据的内存空间)、SurfaceView(显示Surface 的View)、SurfaceHolder(对外暴露Surface的接口)
    2
    
""".trimIndent()

/**
 * camerax 笔记
 */
class CameraXActivity : BaseBindActivity<ActivityCameraXactivityBinding>() {



    @SuppressLint("CheckResult")
    override fun initView(savedInstanceState: Bundle?) {
        //自定义相机管理类
        val cameraXManager=CameraXManager(this@CameraXActivity)

        binding.apply {
            tvNote.text = note

            //初始化及预览
            tvPreview.setOnClickListener {
                cameraXManager.bindPreview(pvMainView)
            }
            tvTakeVideo.setOnClickListener {
                cameraXManager.takeVideo()
            }
            tvStopVideo.setOnClickListener {
                cameraXManager.stopVideo()
            }

            //拍照
            tvTakePic.setOnClickListener {
                val rxP= RxPermissions(this@CameraXActivity)
                rxP.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe {
                    if (it) {
                        cameraXManager.takePic(File(getExternalFilesDir("camerax"),"pic${System.currentTimeMillis()}.JPEG"))
                    }
                }
            }

        }

    }
}