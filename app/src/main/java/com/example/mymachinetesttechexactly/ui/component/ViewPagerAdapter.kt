package com.example.mymachinetesttechexactly.ui.component

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mymachinetesttechexactly.ui.component.fragments.AppsFragment
import com.example.mymachinetesttechexactly.ui.component.fragments.SettingsFragment

private const val NUM_TABS = 2
public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AppsFragment()
            1 -> return SettingsFragment()
            else -> throw java.lang.IllegalArgumentException("Invalid position")
        }
    }
}