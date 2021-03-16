package com.jianastrero.capiche

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun Context.iNeed(vararg permissions: String, onGranted: (String) -> Unit, onDenied: (String) -> Unit) {
    startActivity(
        Intent(this, CapicheParams::class.java).also {
            it.putExtra(CapicheParams.KEY, CapicheParams(*permissions, onGranted = onGranted, onDenied = onDenied))
        }
    )
}

internal fun Context.getGranted(vararg permissions: String): Array<String>? =
    permissions.mapNotNull { permission ->
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED)
            permission
        else
            null
    }.toTypedArray().nullIfEmpty()


internal fun Context.getNotGranted(vararg permissions: String): Array<String>? =
    permissions.mapNotNull { permission ->
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
            permission
        else
            null
    }.toTypedArray().nullIfEmpty()

internal fun Context.getDenied(vararg permissions: String): Array<String>? =
    permissions.mapNotNull { permission ->
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED)
            permission
        else
            null
    }.toTypedArray().nullIfEmpty()

internal fun <T> Array<T>.nullIfEmpty(): Array<T>? = if (isEmpty()) null else this