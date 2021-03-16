package com.jianastrero.capiche

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal class CapicheParams(
    vararg val permissions: String,
    val onGranted: (String) -> Unit,
    val onDenied: (String) -> Unit
) : Parcelable {

    companion object {
        const val KEY = "CAPICHE_PARAMS_KEY"
    }
}