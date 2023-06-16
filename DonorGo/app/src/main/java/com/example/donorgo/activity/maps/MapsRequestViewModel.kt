package com.example.donorgo.activity.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.donorgo.dataclass.BloodRequestItem
import com.example.donorgo.repository.ViewModelRepository

class MapsRequestViewModel(private val mViewModelRepository: ViewModelRepository) : ViewModel() {

    val messageBloodRequest: LiveData<String?> = mViewModelRepository.message

    val listBloodRequest: LiveData<List<BloodRequestItem>> = mViewModelRepository.listRequest

    val isLoading: LiveData<Boolean> = mViewModelRepository.isLoading

    val isError: LiveData<Boolean> = mViewModelRepository.isError

    fun getBloodListRequest(token: String) {
        mViewModelRepository.getAllBloodRequest(token)
    }

}