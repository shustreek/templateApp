package com.shustreek.core.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import com.shustreek.core.R

abstract class FlowFragment(
    @NavigationRes private val navGraph: Int,
    @LayoutRes layout: Int = R.layout.fragment_flow
) : BaseFragment(layout) {

    protected lateinit var flowController: NavController
        private set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        flowController = (requireNotNull(childFragmentManager.findFragmentById(R.id.flowHostFragment),
            { "Need fragment with id flowHostFragment" })
            .findNavController() as NavHostController).apply {
            setViewModelStore(viewModelStore)
            enableOnBackPressed(true)
            setGraph(navGraph)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}