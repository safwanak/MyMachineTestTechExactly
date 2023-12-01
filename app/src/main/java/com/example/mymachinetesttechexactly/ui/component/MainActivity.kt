package com.example.mymachinetesttechexactly.ui.component


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mymachinetesttechexactly.data.dto.AppResponse
import com.example.mymachinetesttechexactly.databinding.ActivityMainBinding
import com.example.mymachinetesttechexactly.ui.base.BaseActivity
import com.example.mymachinetesttechexactly.ui.component.fragments.AppsFragment
import com.example.mymachinetesttechexactly.ui.component.fragments.SettingsFragment
import com.example.mymachinetesttechexactly.utils.livedataevent.observe
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getAppsList(378)


        val viewPager = binding.tabViewpager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.tabViewpager.adapter =adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> tab.text = "Application"
                1 -> tab.text = "Settings"
            }
        }.attach()

        attachListener()

    }

    private fun attachListener() {
        binding.back.setOnClickListener {
            finish()
        }

    }

    override fun observeViewModel() {
//        observe(mainViewModel.loginLoading, ::handleLoadingResult)
//        observe(mainViewModel.appDataLiveData, ::handleAppList)
    }

//    private fun handleAppList(appsResponse: AppResponse) {
//        Log.d("test", appsResponse.message)
//    }

//    private fun handleLoadingResult(status: Boolean) {
//        when (status) {
//            true -> {
//                Toast.makeText(this, "finished", Toast.LENGTH_SHORT).show()
//            }
//
//            false -> {
//                Toast.makeText(this, "started", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(binding.root)
    }
}