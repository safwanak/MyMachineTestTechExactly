package com.example.mymachinetesttechexactly.ui.component.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymachinetesttechexactly.R
import com.example.mymachinetesttechexactly.databinding.FragmentAppsBinding
import com.example.mymachinetesttechexactly.ui.base.BaseFragment
import com.example.mymachinetesttechexactly.ui.component.AppsAdapter
import com.example.mymachinetesttechexactly.ui.component.MainViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppsFragment : BaseFragment() {

    private lateinit var binding: FragmentAppsBinding

    private lateinit var mainViewModel: MainViewModel
    private lateinit var appsAdapter: AppsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]


        mainViewModel.getAppsList(378)

        observeTheApiChanges()

        attachListener()

    }

    private fun attachListener() {
        binding.etSearch.doOnTextChanged { text, start, before, count ->
            appsAdapter.filter.filter(text)
        }

    }



    private fun observeTheApiChanges() {
        mainViewModel.appDataLiveData.observe(requireActivity()) {
            appsAdapter = AppsAdapter(requireContext(), it.data.app_list)


            binding.recyclerView.isNestedScrollingEnabled = false
            binding.recyclerView.setHasFixedSize(false)
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = appsAdapter
        }
        mainViewModel.loginLoading.observe(requireActivity()){
            handleLoadingResult(it)
        }

    }

    private fun handleLoadingResult(status: Boolean) {
        when (status) {
            true -> {
                binding.progress.visibility = View.VISIBLE
            }

            false -> {
                binding.progress.visibility = View.GONE
            }
        }
    }

}