package com.shustreek.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

abstract class CoreActivity(
    @NavigationRes private val graph: Int,
    @LayoutRes layout: Int = R.layout.activity_main
) : AppCompatActivity(layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findNavController(R.id.navHostFragment).setGraph(graph)

    }
}
