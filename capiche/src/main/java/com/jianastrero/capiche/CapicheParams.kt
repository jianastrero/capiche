package com.jianastrero.capiche

import java.io.Serializable

internal class CapicheParams(
    vararg val permissions: String,
    val onGranted: Consumer<String, Unit>,
    val onDenied: Consumer<String, Unit>
) : Serializable