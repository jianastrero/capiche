package com.jianastrero.capiche

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View

internal class CapicheActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(View(this).also {
            it.setBackgroundColor(Color.RED)
        })
    }
}