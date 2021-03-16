package com.jianastrero.capiche

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

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

    }
}