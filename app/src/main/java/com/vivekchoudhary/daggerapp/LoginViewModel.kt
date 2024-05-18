package com.vivekchoudhary.daggerapp

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository): ViewModel() {


    fun getApiData() : String {
        return loginRepository.getApiData()
    }

}