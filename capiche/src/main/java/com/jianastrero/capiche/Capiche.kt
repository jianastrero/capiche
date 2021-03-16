package com.jianastrero.capiche

import android.content.Context
import android.content.Intent

fun Context.iNeed(vararg permissions: String, onGranted: (String) -> Unit, onDenied: (String) -> Unit) {
    startActivity(
        Intent(this, CapicheParams::class.java).also {
            it.putExtra(CapicheParams.KEY, CapicheParams(*permissions, onGranted = onGranted, onDenied = onDenied))
        }
    )
}