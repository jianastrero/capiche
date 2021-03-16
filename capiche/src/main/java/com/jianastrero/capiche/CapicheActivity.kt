package com.jianastrero.capiche

import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

internal const val CAPICHE_REQUEST = 1

internal class CapicheActivity : Activity() {

    private lateinit var capicheParams: CapicheParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(View(this).also {
            it.setBackgroundColor(Color.RED)
        })

        intent.getParcelableExtra<CapicheParams>(CapicheParams.KEY)?.let {
            capicheParams = it
        } ?: finish()

        // Notify what passed permissions are granted
        getGranted(*capicheParams.permissions)?.forEach {
            capicheParams.onGranted(it)
        }

        // Request denied permissions
        getNotGranted(*capicheParams.permissions)?.let {
            ActivityCompat.requestPermissions(this, it, CAPICHE_REQUEST)
        } ?: finish()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAPICHE_REQUEST) {
            permissions.forEachIndexed { index, permission ->
                if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                    capicheParams.onGranted
                } else {
                    capicheParams.onDenied
                }.invoke(permission)
            }
        }
    }
}