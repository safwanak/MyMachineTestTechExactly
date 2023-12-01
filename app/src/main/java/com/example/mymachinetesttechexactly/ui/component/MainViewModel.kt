package com.example.mymachinetesttechexactly.ui.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mymachinetesttechexactly.data.dto.AppResponse
import com.example.mymachinetesttechexactly.network.Resource
import com.example.mymachinetesttechexactly.repository.AppsRepository
import com.example.mymachinetesttechexactly.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appsRepository: AppsRepository,

    ) : BaseViewModel() {

    private val appDataLiveDataPrivate = MutableLiveData<AppResponse>()
    val appDataLiveData: LiveData<AppResponse> get() = appDataLiveDataPrivate

    private val loginLoadingPrivate = MutableLiveData<Boolean>()
    val loginLoading: LiveData<Boolean> get() = loginLoadingPrivate

    fun getAppsList(kid_id: Int) {
        loginLoadingPrivate.value = true
        viewModelScope.launch {
            when (val response =
                appsRepository.getAppsList(kid_id)) {
                is Resource.Success -> {
                    response.value.let {
                        appDataLiveDataPrivate.value = it
                    }
                    loginLoadingPrivate.value = false
                }

                is Resource.Failure<*> -> {
                    loginLoadingPrivate.value = false
                }
            }
        }
    }
}