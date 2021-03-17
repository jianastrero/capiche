package com.jianastrero.capichesample

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jianastrero.capiche.iNeed
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun requestCamera(view: View) {
        iNeed(
            Manifest.permission.CAMERA,
            onGranted = {
                tvCameraStatus.setText(R.string.camera_enabled)
            },
            onDenied = {
                tvCameraStatus.setText(R.string.camera_disabled)
            }
        )
    }
}