package com.jianastrero.capiche

import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat

internal const val CAPICHE_REQUEST = 1
internal const val CAPICHE_PARAMS_KEY = "CAPICHE_PARAMS_KEY"

internal class CapicheActivity : Activity() {

    private lateinit var capicheParams: CapicheParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(View(this).also {
            it.setBackgroundColor(Color.RED)
        })

        intent.getSerializableExtra(CAPICHE_PARAMS_KEY)?.let {
            capicheParams = it as CapicheParams
        } ?: finish()

        ActivityCompat.requestPermissions(this, capicheParams.permissions, CAPICHE_REQUEST)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAPICHE_REQUEST) {
            permissions.forEachIndexed { index, permission ->
                if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                    capicheParams.onGranted
                } else {
                    capicheParams.onDenied
                }.consume(permission)
            }
            finish()
        }
    }
}